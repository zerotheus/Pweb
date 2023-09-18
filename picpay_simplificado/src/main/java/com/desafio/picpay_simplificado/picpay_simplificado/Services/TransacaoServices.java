package com.desafio.picpay_simplificado.picpay_simplificado.Services;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaModel;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaPF;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.Transacao;
import com.desafio.picpay_simplificado.picpay_simplificado.Repository.TransacaoRepository;

@Service
public class TransacaoServices {

    @Autowired
    private ContasServices contasServices;
    @Autowired
    private TransacaoRepository transacaoRepository;

    public Transacao validaTransacao(Long remetenteId, Long destinatarioId, double valor)
            throws Exception {
        ContaPF contaPFdoRemetente = adicionaRemetente(remetenteId);
        ContaModel contaDoDestinatario = adicionaDestinatario(destinatarioId);
        contaPFdoRemetente.transfere(valor);
        contaDoDestinatario.deposita(valor);
        System.out.println(contaPFdoRemetente);
        System.out.println(contaDoDestinatario);
        if (!foiAutorizada()) {
            throw new Exception("Nao foi autorizada");
        }
        Transacao transacao = new Transacao(contaPFdoRemetente, contaDoDestinatario, valor);
        System.out.println(transacao.toString());
        return transacaoRepository.save(transacao);
    }

    private ContaPF adicionaRemetente(Long remetenteId) throws Exception {
        ResponseEntity<ContaPF> resultadoDaBusca = contasServices.encontraContaPFPeloId(remetenteId);
        if (!resultadoDaBusca.getStatusCode().is2xxSuccessful()) {
            throw new Exception("Conta nao encontrada ou nao pode realizar este tipo de operacao");
        }
        return resultadoDaBusca.getBody();
    }

    private ContaModel adicionaDestinatario(Long destinatarioId) throws Exception {
        ResponseEntity<ContaModel> resultadoDaBusca = contasServices.encontraContaPeloId(destinatarioId);
        if (!resultadoDaBusca.getStatusCode().is2xxSuccessful()) {
            throw new Exception("Conta nao encontrada");
        }
        return resultadoDaBusca.getBody();
    }

    // Os servicos de mock do repositorio ficaram desativados por um longo tempo
    // então estou utilizando esta funcao para simular isso
    private boolean foiAutorizada() {
        Random foiAprovado = new Random();
        Random diminuiChancesDeNaoAprovae = new Random();
        return foiAprovado.nextBoolean() || diminuiChancesDeNaoAprovae.nextBoolean();
    }

    public List<Transacao> listaTodasMinhasTransacoes(long contaId) {
        return transacaoRepository.listaTodasTransacoesdeUmaConta(contaId);
    }

}
