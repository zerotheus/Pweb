package com.desafio.picpay_simplificado.picpay_simplificado.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.CPF;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/User")
@AllArgsConstructor
public class UserController {

    @PostMapping("/Register")
    public void createUser(@RequestBody CPF cpf) {
        System.out.println(cpf);
    }

}
