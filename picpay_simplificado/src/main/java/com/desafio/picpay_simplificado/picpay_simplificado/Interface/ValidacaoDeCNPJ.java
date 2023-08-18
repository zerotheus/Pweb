package com.desafio.picpay_simplificado.picpay_simplificado.Interface;

public interface ValidacaoDeCNPJ {

    default void validaCNPJ(String cnpj) throws Exception {
        temQuantidadeCorretadeDigitos(cnpj);
        temSomenteDigitos(cnpj);
        validaPrimeiroDigitoVerificador(cnpj);
        validaSegundoDigitoVerificador(cnpj);
    }

    private void temQuantidadeCorretadeDigitos(String cnpj) throws Exception {
        if (cnpj.length() != 14) {
            throw new Exception("Quantidade Incorreta de Digitos");
        }
    }

    private void temSomenteDigitos(String cnpj) throws Exception {
        for (int i = 0; i < cnpj.length(); i++) {
            ehUmDigito(cnpj.charAt(i));
        }
    }

    private void ehUmDigito(char caractere) throws Exception {
        if (!Character.isDigit(caractere)) {
            throw new Exception("CNPJ contem somente numeros");
        }
    }

    private void validaPrimeiroDigitoVerificador(String cnpj) throws Exception {
        final int[] ordemDeMultiplicacao = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int soma = 0;
        final int digitoverificador = cnpj.charAt(12) - 48;
        for (int i = 0; i < 12; i++) {
            soma += (cnpj.charAt(i) - 48) * ordemDeMultiplicacao[i];
        }
        final int restoDaDivisao = soma % 11;
        if (restoDaDivisao < 2) {
            restoMenorQueDois(digitoverificador);
            return;
        }
        restoMaiorQueDois(restoDaDivisao, digitoverificador);
    }

    private void validaSegundoDigitoVerificador(String cnpj) throws Exception {
        final int[] ordemDeMultiplicacao = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int soma = 0;
        final int digitoverificador = cnpj.charAt(13) - 48;
        for (int i = 0; i < 13; i++) {
            soma += (cnpj.charAt(i) - 48) * ordemDeMultiplicacao[i];
        }
        final int restoDaDivisao = soma % 11;
        if (restoDaDivisao < 2) {
            restoMenorQueDois(digitoverificador);
            return;
        }
        restoMaiorQueDois(restoDaDivisao, digitoverificador);
    }

    private void restoMenorQueDois(int digitoVerificador) throws Exception {
        if (digitoVerificador != 0) {
            throw new Exception("Digito verificador Invalido");
        }
    }

    private void restoMaiorQueDois(int resto, int digitoVerificador) throws Exception {
        if ((11 - resto) != digitoVerificador) {
            throw new Exception("Digito verificador Invalido");
        }
    }

}
