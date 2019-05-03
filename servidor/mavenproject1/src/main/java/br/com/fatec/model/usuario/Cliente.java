package br.com.fatec.model.usuario;

import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.livro.Livro;
import java.util.Date;

public class Cliente extends Usuario {
    private String nome;
    private Date nascimento;
    private String cpf;
    private DadosPagamento dadosPagamento;
    private Carrinho carrinho;

    public Cliente(){
        this.carrinho = new Carrinho();
    }
    
    public Carrinho getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(Carrinho carrinho) {
        this.carrinho = carrinho;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public DadosPagamento getDadosPagamento() {
        return dadosPagamento;
    }

    public void setDadosPagamento(DadosPagamento dadosPagamento) {
        this.dadosPagamento = dadosPagamento;
    }
}
