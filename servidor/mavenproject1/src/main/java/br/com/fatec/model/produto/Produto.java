package br.com.fatec.model.produto;

public abstract class Produto {

    private String titulo;
    private String capa;
    private String categoria;
    private float preco;
    private String resumo;
    private int quantidade = 20;
    private boolean esgotado;
    private boolean promocao;
    private float percentDesconto;

    static final String PATH_IMAGEM = "resources/images/";

    public Produto(){
        this.esgotado = false;
    }
    
    public abstract void vender(int quantidade);

    public boolean isPromocao() {
        return promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public float getPercentDesconto() {
        return percentDesconto;
    }

    public void setPercentDesconto(float percentDesconto) {
        this.percentDesconto = percentDesconto;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        if (capa.startsWith(PATH_IMAGEM)) {
            this.capa = capa;
        } else {
            this.capa = PATH_IMAGEM + capa;
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco < 0) {
            throw new RuntimeException("Preço não pode ser negativo");
        }
        this.preco = preco;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new RuntimeException("Quantidade não pode ser menor que 0");
        }
        if (quantidade == 0) {
            this.setEsgotado(true);
        } else {
            this.setEsgotado(false);
        }
        this.quantidade = quantidade;
    }

    public boolean isEsgotado() {
        return esgotado;
    }

    public void setEsgotado(boolean esgotado) {
        this.esgotado = esgotado;
    }
}
