package com.desafio.picpay_simplificado.picpay_simplificado.Controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaModel;
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
        contasServices.criaContaPJ(contaPj);
    }

    @PostMapping("/Deposita")
    public ResponseEntity deposita(@RequestBody Map<String, String> json) throws NumberFormatException, Exception {
        final long id = Long.parseLong(json.get("id"));
        final double valor = Double.parseDouble(json.get("valor"));
        return contasServices.deposita(id, valor);
    }
}
