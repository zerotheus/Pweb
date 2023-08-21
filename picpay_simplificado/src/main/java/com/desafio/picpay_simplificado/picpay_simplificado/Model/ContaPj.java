package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContaPj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ContaId;
    @Embedded
    private Users user;
    private double saldo;
    @Embedded
    @Column(unique = true, nullable = false)
    private CNPJ cnpj;
}
