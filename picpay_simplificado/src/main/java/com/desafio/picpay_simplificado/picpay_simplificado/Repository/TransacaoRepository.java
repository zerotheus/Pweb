package com.desafio.picpay_simplificado.picpay_simplificado.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.Transacao;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

    @Query(value = "Select * FROM transacao WHERE Conta_Id_destinatario = ?1 or Conta_Id_remetente = ?1 ", nativeQuery = true)
    public List<Transacao> listaTodasTransacoesdeUmaConta(@Param("id") Long id);

}
