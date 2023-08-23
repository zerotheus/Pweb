package com.desafio.picpay_simplificado.picpay_simplificado.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaPF;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaPJ;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.Users;
import com.desafio.picpay_simplificado.picpay_simplificado.Services.ContasServices;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/User")
@AllArgsConstructor
public class ContasController {

    private ContasServices contasServices;

    @PostMapping("/Register") // usado para debug
    public void createUser(@RequestBody Users user) {
        System.out.println(user);
    }

    @PostMapping("/CriaPF")
    public void createContaPF(@RequestBody ContaPF conta) {
        System.out.println(conta.getUser());
        contasServices.criaContaPF(conta);
    }

    @PostMapping("/CriaPJ")
    public void createContaPJ(@RequestBody ContaPJ contaPj) {
        System.out.println(contaPj);
    }

}
