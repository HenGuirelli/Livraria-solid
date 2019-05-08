package br.com.fatec.model.usuario;

import java.util.Date;

public class DadosPagamento {
    private String rua;
    private int numeroCasa;
    private int numeroCartao;
    private int digitoCartao;
    private Date vencimento;

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

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getDigitoCartao() {
        return digitoCartao;
    }

    public void setDigitoCartao(int digitoCartao) {
        this.digitoCartao = digitoCartao;
    }

    public Date getVencimento() {
        return vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }
}
