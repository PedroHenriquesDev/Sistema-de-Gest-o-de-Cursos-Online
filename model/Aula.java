package model;

public class Aula extends Conteudo {
    private int duracao; // em minutos

    public Aula(String nome, String descricao, int duracao) {
        super(nome, descricao);
        this.duracao = duracao;
    }

    // Getters e Setters
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public void exibir() {
        super.exibir();
        System.out.println("Duração: " + duracao + " minutos");
        System.out.println("------------------------");
    }
}
