package br.com.fatec.model.produto;

public interface Negociavel {
    public void comprar(int quantidade);
    public void vender(int quantidade);
    
    public float getPreco();
}
