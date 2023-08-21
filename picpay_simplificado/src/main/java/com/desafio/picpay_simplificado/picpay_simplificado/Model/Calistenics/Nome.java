package com.desafio.picpay_simplificado.picpay_simplificado.Model.Calistenics;

import com.desafio.picpay_simplificado.picpay_simplificado.Interface.TratadorDeStrings;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@Embeddable
@Getter
@ToString
public class Nome implements TratadorDeStrings {

    private String nome;

    public Nome(String nome) throws Exception {
        temMaisDe3caracteres(nome);
        naoNulo(this.getClass().getSimpleName(), nome);
        naoVazio(this.getClass().getSimpleName(), nome);
        naoEmBranco(this.getClass().getSimpleName(), nome);
        this.nome = nome;
    }

    private void temMaisDe3caracteres(String nome) throws Exception {
        if (nome.length() < 3) {
            throw new Exception("Nome deve ter mais de 3 caracteres");
        }
    }

}
