package com.example.formulario_api.services;

import com.example.formulario_api.exception.ValidacaoException;
import com.example.formulario_api.repository.TokenEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TokenService {

    @Autowired
    private TokenEmailRepository repository;

    public String getTokenByEmail(String email) {
        try {
            var tk = this.repository.findByEmail(email);
            return tk.getToken();
        } catch (Exception e){
            throw new ValidacaoException(e.getMessage());
        }
    }

    public void confirmToken(String email) {
        try{
            var tokenRegister = repository.findByEmail(email);
            if(tokenRegister == null){
                throw new ValidacaoException("Não foi enviado token para este email! Tente reenviar.");
            }
            tokenRegister.setToken(null);
            repository.save(tokenRegister);
        }catch (Exception e){
            throw new ValidacaoException(e.getMessage());
        }
    }

    public String gerarToken(){
        // It will generate 6 digit random Number.
        // from 0 to 999999
        Random rnd = new Random();
        int number = rnd.nextInt(999999);

        // this will convert any number sequence into 6 character.
        return String.format("%06d", number);
    }
}
