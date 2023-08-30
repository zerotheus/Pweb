package com.desafio.picpay_simplificado.picpay_simplificado.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

}
