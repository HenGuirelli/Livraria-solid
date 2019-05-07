package br.com.fatec.model.produto;

import java.util.Date;

public class Autor {
    private String nome;
    private Date nascimento;
    private Date falecimento;

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

    public Date getFalecimento() {
        return falecimento;
    }

    public void setFalecimento(Date falecimento) {
        this.falecimento = falecimento;
    }    
}
