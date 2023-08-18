package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@ToString
@Data
@Embeddable
@Getter
public class Email {

    private String email;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);

    public Email(String email) throws Exception {
        ehUmEmailValido(email);
        this.email = email;
    }

    private void ehUmEmailValido(String email) throws Exception {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        if (!matcher.matches()) {
            throw new Exception("Email invalido");
        }
    }

    public void EnviaEmaildeCadastro() {

    }

}
