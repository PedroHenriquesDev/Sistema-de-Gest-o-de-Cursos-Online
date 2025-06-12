package model;

import java.util.ArrayList;
import java.util.List;

public class Curso extends Conteudo {
    private int cargaHoraria;
    private Instrutor instrutor;
    private List<Aula> aulas;

    public Curso(String nome, String descricao, int cargaHoraria, Instrutor instrutor) {
        super(nome, descricao);
        this.cargaHoraria = cargaHoraria;
        this.instrutor = instrutor;
        this.aulas = new ArrayList<>();
    }

    // Getters e Setters
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void adicionarAula(Aula aula) {
        aulas.add(aula);
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Carga Horária: " + cargaHoraria + " horas");
        System.out.println("Instrutor: " + instrutor.getNome());
        System.out.println("Aulas:");
        for (Aula aula : aulas) {
            aula.exibir();
        }
        System.out.println("------------------------");
    }
}
