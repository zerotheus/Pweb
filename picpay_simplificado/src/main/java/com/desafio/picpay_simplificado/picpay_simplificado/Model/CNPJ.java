package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import com.desafio.picpay_simplificado.picpay_simplificado.Interface.ValidacaoDeCNPJ;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Embeddable
@Data
public class CNPJ implements ValidacaoDeCNPJ {

    private String cnpj;

    public CNPJ(String cnpj) throws Exception {
        validaCNPJ(cnpj);
        this.cnpj = cnpj;
    }

}
