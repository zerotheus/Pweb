package com.desafio.picpay_simplificado.picpay_simplificado.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaModel;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaPF;
import com.desafio.picpay_simplificado.picpay_simplificado.Model.ContaPJ;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Long> {

    @Query(value = "Select * FROM contas WHERE contaId = 'id' AND tipo = PF", nativeQuery = true)
    public Optional<ContaPF> findContaPFbyId(@Param("id") Long id);

    @Query(value = "Select * FROM contas WHERE contaId = 'id' AND tipo = PJ", nativeQuery = true)
    public Optional<ContaPJ> findContaPJbyId(@Param("id") Long id);

}
