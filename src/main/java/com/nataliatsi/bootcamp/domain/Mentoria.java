package com.nataliatsi.bootcamp.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Mentoria extends Conteudo{
    private LocalDate data;

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d;
    }

    @Override
    public String toString() {
        return "Mentoria {" +
                "Título: " + getTitulo() +
                " Descrição: " + getDescricao() +
                " Data: " + data +
                '}';
    }
}
