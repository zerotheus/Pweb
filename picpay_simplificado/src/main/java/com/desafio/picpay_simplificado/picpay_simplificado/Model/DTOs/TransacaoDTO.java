package com.desafio.picpay_simplificado.picpay_simplificado.Model.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransacaoDTO {

    private final long numerodetransacao;
    private final long destinatarioId;
    private final long remetenteId;
    private final double valor;

    public TransacaoDTO(long numerodetransacao,long remetenteId, long destinatarioId, double valor) {
        this.numerodetransacao = numerodetransacao;
        this.destinatarioId = destinatarioId;
        this.remetenteId = remetenteId;
        this.valor = valor;
    }

}
