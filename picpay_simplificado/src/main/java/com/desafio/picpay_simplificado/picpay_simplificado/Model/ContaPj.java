package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.Calistenics.CNPJ;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Table(name = "contas")
@Getter
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

    @Override
    public String toString() {
        return super.toString() + " " + this.cnpj.toString();
    }
    
    private ContaPJ(){
        
    }

}
