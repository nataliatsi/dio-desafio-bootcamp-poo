package com.nataliatsi.bootcamp.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Curso extends Conteudo{
    private int cargaHoraria;

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    @Override
    public String toString() {
        return "Curso {" +
                "Título: " + getTitulo() +
                " Descrição: " + getDescricao() +
                " Carga Horária: " + cargaHoraria +
                '}';
    }
}
