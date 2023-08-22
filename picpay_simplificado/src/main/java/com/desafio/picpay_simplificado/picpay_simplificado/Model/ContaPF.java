package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.desafio.picpay_simplificado.picpay_simplificado.Interface.Depositos;
import com.desafio.picpay_simplificado.picpay_simplificado.Interface.EnvioDeTransferencias;
import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

//@ToString
@Getter
@Entity
@Table(name = "contas")
@DiscriminatorValue(value = "PF")
public class ContaPF extends ContaModel implements EnvioDeTransferencias {

    public void deposita(float valorADepositar) throws Exception {
        if (valorADepositar <= 0) {
            throw new Exception("Nao se pode depositar valores negativos");
        }
        super.saldo += valorADepositar;
    }

    public void transfere(float valorDaTransferencia) throws Exception {
        if (valorDaTransferencia > super.saldo) {
            throw new Exception("super.Saldo insuficiente");
        }
        if (valorDaTransferencia <= 0) {
            throw new Exception("Nao se pode trasnferir valores negativos");
        }
        super.saldo -= valorDaTransferencia;
    }

    @JsonCreator
    public ContaPF(Users user) {
        super(user, "PF");
    }

}
