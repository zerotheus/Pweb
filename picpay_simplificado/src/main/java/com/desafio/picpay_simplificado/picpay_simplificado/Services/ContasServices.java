package com.desafio.picpay_simplificado.picpay_simplificado.Services;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaPF;
import com.desafio.picpay_simplificado.picpay_simplificado.Repository.ContaRepository;

@Service
public class ContasServices {

    @Autowired
    private ContaRepository contaRepository;

    public ContaPF criaContaPF(ContaPF contaPF) {
        return contaRepository.save(contaPF);
    }

}
