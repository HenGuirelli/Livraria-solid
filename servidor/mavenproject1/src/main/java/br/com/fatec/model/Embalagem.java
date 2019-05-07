package br.com.fatec.model;

import br.com.fatec.model.produto.Negociavel;

public class Embalagem implements Negociavel {

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

    public void consumir(int quantidade) {
        this.quantidade -= quantidade;
    }
    
    @Override
    public void comprar(int quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public void vender(int quantidade) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public float getPreco() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
