package br.com.fatec.model.produto;

public class Filme extends Produto implements Vendavel, Compravel {

    private int duracao;
    private boolean is3D;
    private boolean legendado;
    private Diretor diretor;

    // getters e setters
    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Diretor getDiretor() {
        return diretor;
    }

    public void setDiretor(Diretor diretor) {
        this.diretor = diretor;
    }
    
    public boolean isIs3D() {
        return is3D;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public boolean isLegendado() {
        return legendado;
    }

    public void setLegendado(boolean legendado) {
        this.legendado = legendado;
    }

    public void vender(int quantidade) {
        // atualiza model
        int novaQuantidade = this.getQuantidade() - quantidade;
        this.setQuantidade(novaQuantidade);
        if (this.getQuantidade() == 0) {
            this.setEsgotado(true);
        }
    }

    public void comprar(int quantidade) {
        this.setQuantidade(this.getQuantidade() + quantidade);
    }
}
