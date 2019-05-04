package br.com.fatec.model.pedido;

import br.com.fatec.DAO.CodigoDAO;
import br.com.fatec.enums.EstadoPedido;
import br.com.fatec.model.livro.Livro;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Pedido {

    private EstadoPedido estado;
    private Date dataCriacao;
    private Date dataEmAtendimento;
    private Date entregue;
    private String codigo;
    private List<Livro> livros;

    public Pedido() {
        setCodigo(Pedido.gerarNovoCodigo());
        dataCriacao = new Date(System.currentTimeMillis());
        livros = new ArrayList<>();
        estado = EstadoPedido.emAtendimento;
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

    public void addLivro(Livro livro){
        livros.add(livro);
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
}
