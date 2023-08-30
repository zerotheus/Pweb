package com.desafio.picpay_simplificado.picpay_simplificado.Controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.Transacao;
import com.desafio.picpay_simplificado.picpay_simplificado.Services.TransacaoServices;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/Transfere")
@AllArgsConstructor
public class TransacaoController {

    private TransacaoServices transacaoServices;

    @PostMapping("/Para")
    @ResponseStatus(code = HttpStatus.CREATED)
    public HttpStatus transfere(@RequestBody Map<String, String> json) {
        System.out.println(json);
        try {
            final int remetenteId = Integer.parseInt(json.get("remetenteId"));
            final int destinatarioId = Integer.parseInt(json.get("destinatarioId"));
            final double valor = Double.parseDouble(json.get("valor"));
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
        transacaoServices.validaTransacao(new Transacao());
        return HttpStatus.CREATED;
    }

}
