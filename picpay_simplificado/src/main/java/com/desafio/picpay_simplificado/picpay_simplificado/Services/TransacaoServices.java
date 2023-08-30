package com.desafio.picpay_simplificado.picpay_simplificado.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.Transacao;
import com.desafio.picpay_simplificado.picpay_simplificado.Repository.ContaRepository;
import com.desafio.picpay_simplificado.picpay_simplificado.Repository.TransacaoRepository;

@Service
public class TransacaoServices {

    @Autowired
    private ContaRepository contaRepository;
    private TransacaoRepository transacaoRepository;

    public void validaTransacao(Transacao transacao) {

    }

}
