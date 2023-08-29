package com.desafio.picpay_simplificado.picpay_simplificado.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/Transfere")
@AllArgsConstructor
public class TransacaoController {

    @PostMapping("/{Myid}/{destinatarioId}")
    public void transfere(@PathVariable String Myid,
            @PathVariable String destinatarioId) {
        System.out.println(Myid);
        System.out.println(destinatarioId);
    }

}
