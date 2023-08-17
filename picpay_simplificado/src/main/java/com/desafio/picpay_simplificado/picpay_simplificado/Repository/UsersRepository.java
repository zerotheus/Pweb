package com.desafio.picpay_simplificado.picpay_simplificado.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.Users;

interface UsersRespositoy extends JpaRepository<Users, Long> {
}