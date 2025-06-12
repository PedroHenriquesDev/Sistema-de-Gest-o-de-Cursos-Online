package model;

public abstract class Conteudo implements Exibivel {
    private String nome;
    private String descricao;

    public Conteudo(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public void exibir() {
        System.out.println("Nome: " + nome);
        System.out.println("Descrição: " + descricao);
    }
}
