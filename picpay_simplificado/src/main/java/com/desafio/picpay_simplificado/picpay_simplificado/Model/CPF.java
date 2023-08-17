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
        temSomenteNumeros(cpf);
        validaPrimeiroDigitoVerificador(cpf);
        this.cpf = cpf;
    }

    private void temSomenteNumeros(String cpf) throws Exception {
        for (int i = 0; i < 9; i++) {
            ehUmDigito(cpf.charAt(i));
        }
    }

    private void ehUmDigito(char character) throws Exception {
        if (!Character.isDigit(character)) {
            throw new Exception("CPF deve conter somente numeros");
        }
    }

    private void validaPrimeiroDigitoVerificador(String cpf) {
        int soma = 0;
        final int digitoverificador = cpf.charAt(9);
        for (int i = 0; i < 9; i++) {
            soma = cpf.charAt(i) * (10 - i);
        }
    }

    private void validaSegundoDigitoVerificador(String cpf) {

    }

}
