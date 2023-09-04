package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.Calistenics.CPF;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.Calistenics.Email;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.Calistenics.Nome;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity(name = "users")
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = { "cpf", "email" }))
@Getter
@ToString
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;
    @Embedded
    @Column(nullable = false, unique = true)
    private CPF cpf;
    @Embedded
    @Column(nullable = false, unique = true, name = "email")
    private Email email;
    @Embedded
    private Nome nome;
    @CreationTimestamp
    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;

    @JsonCreator
    public Users(@JsonProperty("cpf") String cpf, @JsonProperty("email") String email,
            @JsonProperty("nome") String nome) throws Exception {
        this.cpf = new CPF(cpf);
        this.email = new Email(email);
        this.nome = new Nome(nome);
    }

    private Users() {

    }

}
