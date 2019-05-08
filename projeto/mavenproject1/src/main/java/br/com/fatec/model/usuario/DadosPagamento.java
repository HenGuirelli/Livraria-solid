package br.com.fatec.model.usuario;

import br.com.fatec.enums.FormaPagamento;
import java.util.Date;

public class DadosPagamento {
    private String rua;
    private int numeroCasa;
    private String numeroCartao;
    private String digitoCartao;
    private Date vencimento;
    private FormaPagamento formaPagamento;

    public FormaPagamento getFormaPagameno() {
        return formaPagamento;
    }

    public void setFormaPagameno(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getDigitoCartao() {
        return digitoCartao;
    }

    public void setDigitoCartao(String digitoCartao) {
        this.digitoCartao = digitoCartao;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
}
