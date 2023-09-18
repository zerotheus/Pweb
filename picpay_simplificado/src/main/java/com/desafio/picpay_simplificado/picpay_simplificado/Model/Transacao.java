package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Entity
@Setter
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long TrasancaoId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Conta_Id_remetente", updatable = false)
    private ContaPF remetente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Conta_Id_destinatario", updatable = false)
    private ContaModel destinatario;
    private double valor;

    public Transacao() {
    }

    public Transacao(ContaPF remetente, ContaModel destinatario, double valor) {
        this.remetente = remetente;
        this.destinatario = destinatario;
        this.valor = valor;
    }

}
