package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
@Entity
@Setter
public class Transacao {

    @Id
    private Long TrasancaoId;
    @ManyToOne
    @JoinColumn(name = "Conta_Id", insertable = false, updatable = false)
    private ContaPF remente;
    @ManyToOne
    @JoinColumn(name = "Conta_Id", insertable = false, updatable = false)
    private ContaModel destinatario;
    private double valor;

}
