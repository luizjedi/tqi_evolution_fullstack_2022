package com.tqi.bookman.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class EnderecoEntity {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String ddd;

    // Métodos
    @Override
    public String toString() {
        return "========== Endereço =========" + '\n' +
                "Cep: " + cep + '\n' +
                "Logradouro: " + logradouro + '\n' +
                "Complemento: " + complemento + '\n' +
                "Localidade: " + localidade + '\n' +
                "Uf: " + uf + '\n' +
                "=============================";
    }
}
