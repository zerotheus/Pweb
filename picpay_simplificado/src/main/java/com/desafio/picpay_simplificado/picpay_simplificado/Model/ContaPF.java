package com.desafio.picpay_simplificado.picpay_simplificado.Model;

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

@ToString
@Getter
@Entity
@Table(name = "contas")
public class ContaPF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ContaId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;
    private float saldo;
    private final String tipo = "PF";

    public void deposita(float valorADepositar) throws Exception {
        if (valorADepositar <= 0) {
            throw new Exception("Nao se pode depositar valores negativos");
        }
        saldo += valorADepositar;
    }

    public void transfere(float valorDaTransferencia) throws Exception {
        if (valorDaTransferencia > saldo) {
            throw new Exception("Saldo insuficiente");
        }
        if (valorDaTransferencia <= 0) {
            throw new Exception("Nao se pode trasnferir valores negativos");
        }
        saldo -= valorDaTransferencia;
    }

}
