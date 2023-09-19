package com.desafio.picpay_simplificado.picpay_simplificado.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.Transacao;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.DTOs.TransacaoDTO;
import com.desafio.picpay_simplificado.picpay_simplificado.Services.TransacaoServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/Transacoes")
@AllArgsConstructor
public class TransacaoController {

    private TransacaoServices transacaoServices;

    @PostMapping("/Transfere")
    public ResponseEntity<Object> transfere(@RequestBody Map<String, String> json) {
        System.out.println(json);
        final long remetenteId;
        final long destinatarioId;
        final double valor;
        try {
            remetenteId = Integer.parseInt(json.get("remetenteId"));
            destinatarioId = Integer.parseInt(json.get("destinatarioId"));
            valor = Double.parseDouble(json.get("valor"));
            if (valor <= 0) {
                return ResponseEntity.badRequest().body("Valor invalido");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Forneça somente numeros");
        }
        try {
            Transacao transacaoConcluida = transacaoServices.validaTransacao(remetenteId,
                    destinatarioId, valor);
            System.out.println(transacaoConcluida.toString());
            return ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.toString());
        }
    }

    @GetMapping("/MinhasTransacoes")
    public ResponseEntity<List<TransacaoDTO>> listaTodasMinhasTransacoes(@RequestBody Map<String, String> json) {
        long userId = Long.parseLong(json.get("userId"));
        List<Transacao> transacoesEncontradas = transacaoServices.listaTodasMinhasTransacoes(userId);
        final List<TransacaoDTO> transacoesDtos = new ArrayList<TransacaoDTO>();
        for (Transacao transacao : transacoesEncontradas) {
            transacoesDtos
                    .add(new TransacaoDTO(transacao.getTrasancaoId(), transacao.getRemetente().getContaId(),
                            transacao.getDestinatario().getContaId(), transacao.getValor()));
        }
        return ResponseEntity.ok().body(transacoesDtos);
    }

    @GetMapping("/Entradas")
    public ResponseEntity<List<TransacaoDTO>> listaTodasMinhasEntradas(@RequestBody Map<String, String> json) {
        long userId = Long.parseLong(json.get("userId"));
        List<Transacao> transacoesEncontradas = transacaoServices.listaTodasMinhasEntradas(userId);
        final List<TransacaoDTO> transacoesDtos = new ArrayList<TransacaoDTO>();
        for (Transacao transacao : transacoesEncontradas) {
            transacoesDtos
                    .add(new TransacaoDTO(transacao.getTrasancaoId(), transacao.getRemetente().getContaId(),
                            transacao.getDestinatario().getContaId(), transacao.getValor()));
        }
        return ResponseEntity.ok().body(transacoesDtos);
    }

    @GetMapping("/Saidas")
    public ResponseEntity<List<TransacaoDTO>> listaTodasMinhasSaidas(@RequestBody Map<String, String> json) {
        long userId = Long.parseLong(json.get("userId"));
        List<Transacao> transacoesEncontradas = transacaoServices.listaTodasMinhasSaidas(userId);
        final List<TransacaoDTO> transacoesDtos = new ArrayList<TransacaoDTO>();
        for (Transacao transacao : transacoesEncontradas) {
            transacoesDtos
                    .add(new TransacaoDTO(transacao.getTrasancaoId(), transacao.getRemetente().getContaId(),
                            transacao.getDestinatario().getContaId(), transacao.getValor()));
        }
        return ResponseEntity.ok().body(transacoesDtos);
    }

}
