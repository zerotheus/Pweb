package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import org.checkerframework.common.aliasing.qual.Unique;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Entity
@Getter
@ToString
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Embedded
    @Unique
    private CPF cpf;
    @Embedded
    @Unique
    private Email email;

}
