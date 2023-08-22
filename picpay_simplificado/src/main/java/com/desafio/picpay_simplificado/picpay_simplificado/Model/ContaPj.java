package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.desafio.picpay_simplificado.picpay_simplificado.Interface.Depositos;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.Calistenics.CNPJ;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.Super;

@Entity
@Table(name = "contas")
@Getter
@ToString
@DiscriminatorValue(value = "PJ")
public class ContaPJ extends ContaModel {

    @Embedded
    @Column(unique = true, nullable = false)
    private CNPJ cnpj;

    @JsonCreator
    public ContaPJ(@JsonProperty("user") Users user, @JsonProperty("cnpj") String cnpj) throws Exception {
        super(user, "PJ");
        this.cnpj = new CNPJ(cnpj);
    }

}
