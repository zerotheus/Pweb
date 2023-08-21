package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table(name = "contas")
@Getter
@ToString
public class ContaPj {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ContaId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private double saldo;
    @Embedded
    @Column(unique = true, nullable = false)
    private CNPJ cnpj;
    private final String tipo = "PF";
}
