package com.desafio.picpay_simplificado.picpay_simplificado.Controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.desafio.picpay_simplificado.picpay_simplificado.Services.TransacaoServices;

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
        final long remetenteId;
        final long destinatarioId;
        final double valor;
        try {
            remetenteId = Integer.parseInt(json.get("remetenteId"));
            destinatarioId = Integer.parseInt(json.get("destinatarioId"));
            valor = Double.parseDouble(json.get("valor"));
            if (valor <= 0) {
                return HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
        try {
            transacaoServices.validaTransacao(remetenteId, destinatarioId, valor);
        } catch (Exception e) {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.CREATED;
    }

}
