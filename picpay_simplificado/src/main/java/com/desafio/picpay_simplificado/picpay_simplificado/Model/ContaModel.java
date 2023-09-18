package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.desafio.picpay_simplificado.picpay_simplificado.Interface.RecebeDepositos;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.ToString;

//Utilizada para abstrair conta em consultas ao banco de dados
@Getter
@ToString
@Entity(name = "contas")
@DiscriminatorColumn(name = "tipo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ContaModel implements RecebeDepositos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ContaId;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;
    protected double saldo = 0;
    @Column(name = "tipo", insertable = false, updatable = false)
    private String tipo;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "destinatario")
    private List<Transacao> transacoesRecebidas;
    @CreationTimestamp
    @Column(name = "createdAt", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt", nullable = false)
    private LocalDateTime updatedAt;

    public void deposita(Double valorADepositar) throws Exception {
        if (valorADepositar <= 0) {
            throw new Exception("Nao se pode depositar valores negativos");
        }
        this.saldo += valorADepositar;
    }

    protected ContaModel() {

    }

    public ContaModel(Users user, String tipo) {
        this.user = user;
        this.tipo = tipo;
    }

}