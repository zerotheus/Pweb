package com.desafio.picpay_simplificado.picpay_simplificado.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaModel;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaPF;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaPJ;
import com.desafio.picpay_simplificado.picpay_simplificado.Repository.ContaRepository;
import com.desafio.picpay_simplificado.picpay_simplificado.Repository.UsersRepository;

@Service
public class ContasServices {

    @Autowired
    private ContaRepository contaRepository;
    @Autowired
    private UsersRepository usersRepository;

    public ContaPF criaContaPF(ContaPF contaPF) {
        usersRepository.save(contaPF.getUser());
        return contaRepository.save(contaPF);
    }

    public ContaPJ criaContaPJ(ContaPJ contaPJ) {
        usersRepository.save(contaPJ.getUser());
        return contaRepository.save(contaPJ);
    }

    public ResponseEntity<ContaModel> encontraContaPeloId(Long id) {
        return contaRepository.findById(id).map(conta -> ResponseEntity.ok().body(conta))
                .orElse(ResponseEntity.badRequest().build());
    }

    public ResponseEntity<ContaPF> encontraContaPFPeloId(Long id) {
        return contaRepository.findContaPFbyId(id).map(contaPF -> ResponseEntity.ok().body(contaPF))
                .orElse(ResponseEntity.badRequest().build());
    }

    public ResponseEntity<ContaPJ> encontraContaPJPeloId(Long id) {
        return contaRepository.findContaPJbyId(id).map(contaPJ -> ResponseEntity.ok().body(contaPJ))
                .orElse(ResponseEntity.badRequest().build());
    }

}
