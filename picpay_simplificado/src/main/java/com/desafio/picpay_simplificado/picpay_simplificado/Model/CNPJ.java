package com.desafio.picpay_simplificado.picpay_simplificado.Model;

import com.desafio.picpay_simplificado.picpay_simplificado.Interface.ValidacaoDeCNPJ;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CNPJ implements ValidacaoDeCNPJ {

    private String cnpj;

    public CNPJ(@JsonProperty("cnpj") String cnpj) throws Exception {
        validaCNPJ(cnpj);
        this.cnpj = cnpj;
    }

}
