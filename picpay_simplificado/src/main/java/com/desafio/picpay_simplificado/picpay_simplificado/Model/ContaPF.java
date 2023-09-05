package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import com.desafio.picpay_simplificado.picpay_simplificado.Interface.EnvioDeTransferencias;
import com.fasterxml.jackson.annotation.JsonCreator;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

//@ToString
@Getter
@Entity
@Table(name = "contas")
@DiscriminatorValue(value = "PF")
public class ContaPF extends ContaModel implements EnvioDeTransferencias {

    public void deposita(double valorADepositar) throws Exception {
        if (valorADepositar <= 0) {
            throw new Exception("Nao se pode depositar valores negativos");
        }
        super.saldo += valorADepositar;
    }

    public void transfere(double valorDaTransferencia) throws Exception {
        if (valorDaTransferencia > super.saldo) {
            throw new Exception("super.Saldo insuficiente");
        }
        if (valorDaTransferencia <= 0) {
            throw new Exception("Nao se pode trasnferir valores negativos");
        }
        super.saldo -= valorDaTransferencia;
    }

    private ContaPF() {
        super();
    }

    @JsonCreator
    public ContaPF(Users user) {
        super(user, "PF");
    }

}
