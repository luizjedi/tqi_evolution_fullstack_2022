package com.tqi.bookman.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class ClienteEntity {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private EnderecoEntity cepEndereco;

    private String cpf;
    private String nome;
    private String telefone;
    private String dataNascimento;

    // Métodos
    @Override
    public String toString() {
        return "========== Cliente ==========" + '\n' +
                "Id: " + id + '\n' +
                "Nome: " + nome + '\n' +
                "Cpf: " + cpf + '\n' +
                "Telefone: " + telefone + '\n' +
                "Data de Nascimento: " + dataNascimento + '\n' +
                cepEndereco;
    }
}
