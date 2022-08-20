package com.tqi.bookman.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.NumberFormat;

@Setter
@Getter
@Entity
public class CompraEntity {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long quantidade;

    @ManyToOne(cascade = CascadeType.ALL)
    private LivroEntity livro;

    private Double valorUnitário;

    // Métodos

    @Override
    public String toString() {
        return "========== Compra ==========" + '\n' +
                "Id: " + id + '\n' +
                "Quantidade: " + quantidade + '\n' +
                "Livro: " + livro.getTitulo() + '\n' +
                "Valor Unitário: " +
                NumberFormat.getCurrencyInstance().format(valorUnitário) + '\n' +
                "=============================";
    }
}
