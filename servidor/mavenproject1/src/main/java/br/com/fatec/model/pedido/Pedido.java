package br.com.fatec.model.pedido;

import br.com.fatec.DAO.CodigoDAO;
import br.com.fatec.enums.EstadoPedido;
import br.com.fatec.enums.FormaPagamento;
import br.com.fatec.model.carrinho.ItemCarrinho;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Pedido {

    private EstadoPedido estado;
    private Date dataCriacao;
    private Date dataEmAtendimento;
    private Date entregue;
    private String codigo;
    private List<ItemCarrinho> produtos;
    private String cliente;
    private float valor;
    private float desconto;
    private float valorTotal;
    private FormaPagamento formaPagamento;
    
    public Pedido() {
        setCodigo(Pedido.gerarNovoCodigo());
        dataCriacao = new Date(System.currentTimeMillis());
        produtos = new ArrayList<>();
        estado = EstadoPedido.emAtendimento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valor = valorTotal - this.desconto;
        this.valorTotal = valorTotal;
    }
    
    public float getValor() {
        return valor;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.valor = this.valorTotal - desconto;
        this.desconto = desconto;
    }
    
    private static String gerarNovoCodigo() {
        CodigoDAO dao = CodigoDAO.getInstance();
        String codigo = "";
        do {
            codigo = gerarCodigo();
        } while (dao.codigoExiste(codigo));
        return codigo;
    }

    private static String gerarCodigo() {
        int tamanhoCodigo = 10;
        char codigo[] = new char[tamanhoCodigo];
        Random random = new Random();
        int cont = 0;

        for (int i = 0; i < tamanhoCodigo / 2; i++) {
            codigo[cont] = (char) random.nextInt(9);
            cont++;
            codigo[cont] = (char) (random.nextInt(25) + 65);
            cont++;
        }
        return codigo.toString();
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
    public List<ItemCarrinho> getProdutos(){
        return produtos;
    }
    
    public void addProduto(ItemCarrinho livro) {
        produtos.add(livro);
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estadoPedido) {
        this.estado = estadoPedido;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataEmAtendimento() {
        return dataEmAtendimento;
    }

    public void setDataEmAtendimento(Date dataEmAtendimento) {
        this.dataEmAtendimento = dataEmAtendimento;
    }

    public Date getEntregue() {
        return entregue;
    }

    public void setEntregue(Date entregue) {
        this.entregue = entregue;
    }

    public String getCodigo() {
        return codigo;
    }

    private void setCodigo(String codigo) {
        CodigoDAO dao = CodigoDAO.getInstance();
        dao.add(codigo);
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
}
