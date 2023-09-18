package com.desafio.picpay_simplificado.picpay_simplificado.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.Transacao;
import com.desafio.picpay_simplificado.picpay_simplificado.Services.TransacaoServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/Transfere")
@AllArgsConstructor
public class TransacaoController {

    private TransacaoServices transacaoServices;

    @PostMapping("/Para")
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

}
