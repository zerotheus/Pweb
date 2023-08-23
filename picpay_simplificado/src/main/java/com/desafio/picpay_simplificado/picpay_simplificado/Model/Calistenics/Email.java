package com.desafio.picpay_simplificado.picpay_simplificado.Model.Calistenics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.data.annotation.AccessType;

import com.desafio.picpay_simplificado.picpay_simplificado.Interface.TratadorDeStrings;
import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Access;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
@Embeddable
@Access(jakarta.persistence.AccessType.FIELD)
public class Email implements TratadorDeStrings {

    private String email;

    @JsonCreator
    public Email(String email) throws Exception {
        ehUmEmailValido(email);
        naoNulo(this.getClass().getName(), email);
        naoVazio(this.getClass().getName(), email);
        naoEmBranco(this.getClass().getName(), email);
        this.email = email;
    }

    private Email() {
    }

    private void ehUmEmailValido(String email) throws Exception {
        final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (!matcher.matches()) {
            throw new Exception("Email invalido");
        }
    }

    public void EnviaEmaildeCadastro() {

    }

}
