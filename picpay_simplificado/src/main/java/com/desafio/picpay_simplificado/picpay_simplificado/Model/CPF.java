package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Embeddable
@Getter
public class CPF {

    private String cpf;

    CPF(String cpf) throws Exception {
        validaCpf(cpf);
    }

    private void validaCpf(String cpf) throws Exception {
        if (cpf.length() != 11) {
            throw new Exception("Cpf tem numero invalido de digitos");
        }
        this.cpf = cpf;
    }

    private void temSomenteNumeros(String cpf) {

    }

    private void validaPrimeiroDigitoVerificador(String cpf) {
        int soma = 0;
        final int digitoverificador = cpf.charAt(9);
        for (int i = 0; i < 9; i++) {

        }
    }

    private void validaSegundoDigitoVerificador(String cpf) {

    }

}
