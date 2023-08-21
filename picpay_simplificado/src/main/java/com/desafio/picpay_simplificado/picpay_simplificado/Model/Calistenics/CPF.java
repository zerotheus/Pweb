package com.desafio.picpay_simplificado.picpay_simplificado.Model.Calistenics;

import com.desafio.picpay_simplificado.picpay_simplificado.Interface.ValidacaoDeCPF;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@Embeddable
@Getter
@NoArgsConstructor
public class CPF implements ValidacaoDeCPF {

    private String cpf;

    // Informa ao spring que o atributo cpf por exemplo pode ser encontrado e
    // desserializado pelo indentificador definido como cpf encontravel em JSON
    public CPF(String cpf) throws Exception {
        System.out.println(cpf.length());
        validaCpf(cpf);
        this.cpf = cpf;
    }

}
