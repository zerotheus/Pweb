package com.desafio.picpay_simplificado.picpay_simplificado.Services;

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
    private TransacaoRepository transacaoRepository;

    public ResponseEntity<Transacao> validaTransacao(Long remetenteId, Long destinatarioId, double valor)
            throws Exception {
        ContaPF contaPFdoRemetente = adicionaRemetente(remetenteId);
        ContaModel contaDoDestinatario = adicionaDestinatario(destinatarioId);
        contaPFdoRemetente.transfere(valor);
        return ResponseEntity.ok().body(new Transacao(contaPFdoRemetente, contaDoDestinatario, valor));
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

    private boolean foiAutorizada() {
        return false;
    }

}
