package model;

public class Instrutor implements Exibivel {
    private String nome;
    private String especialidade;

    public Instrutor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void exibir() {
        System.out.println("Instrutor: " + nome);
        System.out.println("Especialidade: " + especialidade);
        System.out.println("------------------------");
    }
}
