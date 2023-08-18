package com.desafio.picpay_simplificado.picpay_simplificado.Controller;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.CNPJ;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.CPF;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.Email;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.Users;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/User")
@AllArgsConstructor
public class UserController {

    @PostMapping("/Register")
    public void createUser(@RequestBody Users user) {
        /*
         * System.out.println(cpf);
         * System.out.println(email);
         */
        System.out.println(user);
    }

    @PostMapping("/cnpj")
    public void testeCN(@RequestBody CNPJ cnpj) {
        /*
         * System.out.println(cpf);
         * System.out.println(email);
         */
        System.out.println(cnpj);
    }

}
