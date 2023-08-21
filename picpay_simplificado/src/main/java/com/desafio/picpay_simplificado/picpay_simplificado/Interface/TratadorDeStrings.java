package com.desafio.picpay_simplificado.picpay_simplificado.Interface;

public interface TratadorDeStrings {

    default void naoNulo(String nomeDaClasse, String string) throws Exception {
        if (string == null) {
            throw new Exception(nomeDaClasse + " Nulo");
        }
    }

    default void naoVazio(String nomeDaClasse, String string) throws Exception {
        if (string.isEmpty()) {
            throw new Exception(nomeDaClasse + " Vazio");
        }
    }

    default void naoEmBranco(String nomeDaClasse, String string) throws Exception {
        if (string == null) {
            throw new Exception(nomeDaClasse + " Em branco");
        }
    }
}
