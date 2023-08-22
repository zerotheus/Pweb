package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.desafio.picpay_simplificado.picpay_simplificado.Interface.Depositos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
//import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

//Utilizada para abstrair conta em consultas ao banco de dados
@Getter
@ToString
@MappedSuperclass
@DiscriminatorColumn(columnDefinition = "tipo")
public abstract class ContaModel implements Depositos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ContaId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;
    protected float saldo = 0;
    private final String tipo;
    @CreationTimestamp
    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;

    public void deposita(float valorADepositar) throws Exception {
        if (valorADepositar <= 0) {
            throw new Exception("Nao se pode depositar valores negativos");
        }
        this.saldo += valorADepositar;
    }

    public ContaModel(Users user, String tipo) {
        this.user = user;
        this.tipo = tipo;
    }

}
