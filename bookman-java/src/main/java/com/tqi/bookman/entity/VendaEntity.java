package com.tqi.bookman.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.text.NumberFormat;
import java.util.List;

@Setter
@Getter
@Entity
public class VendaEntity {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long quantidadeItens;

    @ElementCollection(targetClass=Long.class)
    private List<Long> idLivros;

    @ManyToOne(cascade = CascadeType.ALL)
    private ClienteEntity cliente;

    private Double precoVenda;

    // Métodos

    @Override
    public String toString() {
        return "========== Venda ============" + '\n' +
                "Id: " + id + '\n' +
                "Número de Itens: " + quantidadeItens + '\n' +
                "Valor da Venda: " +
                NumberFormat.getCurrencyInstance().format(precoVenda) + '\n' +
                "=============================";
    }
}
