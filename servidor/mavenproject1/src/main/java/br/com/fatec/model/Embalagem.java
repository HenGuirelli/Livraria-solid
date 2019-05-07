package br.com.fatec.model;

public class Embalagem {

    private int quantidade;

    private static Embalagem instance;

    private Embalagem() {
    }

    public static Embalagem getInstance() {
        if (instance == null) {
            instance = new Embalagem();
        }
        return instance;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
