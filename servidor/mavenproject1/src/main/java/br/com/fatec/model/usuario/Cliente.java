package br.com.fatec.model.usuario;

import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.pedido.Pedido;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Cliente extends Usuario {

    private String nome;
    private Date nascimento;
    private String cpf;
    private DadosPagamento dadosPagamento;
    private Carrinho carrinho;
    private List<Pedido> pedidos = new ArrayList<>();

    // construtor
    public Cliente() {
        this.carrinho = new Carrinho();
    }

    public void addPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void removerPedido(Pedido pedido) {
        pedidos.remove(pedido);
    }

    public List<Pedido> getPedidos() {
        return this.pedidos;
    }
    
    public void setPedidos(List<Pedido> pedidos){
        this.pedidos = pedidos;
    }

    // getters e setters
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
