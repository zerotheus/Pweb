package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import jakarta.persistence.Entity;
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
    private Long TrasancaoId;
    @ManyToOne
    @JoinColumn(name = "Conta_Id", insertable = false, updatable = false)
    private ContaPF remente;
    @ManyToOne
    @JoinColumn(name = "Conta_Id", insertable = false, updatable = false)
    private ContaModel destinatario;
    private double valor;

    public Transacao() {
    }

    public Transacao(ContaPF remetente, ContaModel destinatario, double valor) {
        this.remente = remetente;
        this.destinatario = destinatario;
        this.valor = valor;
    }

}
