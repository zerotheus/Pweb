package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity(name = "users")
@Getter
@ToString
@RequiredArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @Embedded
    @Column(nullable = false, unique = true)
    private final CPF cpf;
    @Embedded
    @Column(nullable = false, unique = true)
    private final Email email;
    @Embedded
    private final Nome nome;

    @JsonCreator
    public Users(@JsonProperty("cpf") String cpf, @JsonProperty("email") String email,
            @JsonProperty("nome") String nome) throws Exception {
        this.cpf = new CPF(cpf);
        this.email = new Email(email);
        this.nome = new Nome(nome);
    }

}
