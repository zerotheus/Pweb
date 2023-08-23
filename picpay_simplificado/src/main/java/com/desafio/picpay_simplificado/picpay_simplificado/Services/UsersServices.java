package com.desafio.picpay_simplificado.picpay_simplificado.Services;

import com.desafio.picpay_simplificado.picpay_simplificado.Model.Users;
import com.desafio.picpay_simplificado.picpay_simplificado.Repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {

    @Autowired
    private UsersRepository usersRepository;
    

    public Users createUser(Users users) {
        return usersRepository.save(users);
    }

}
