package br.com.fatec.model.livro;

import java.util.ArrayList;
import java.util.List;

public class Sumario {
    private String nome;
    private String numeracao;
    private List<Sumario> subItens;
    
    private int profundidade;
    
    public Sumario(){
        this.subItens = new ArrayList<>();
        this.profundidade = 0;
    }
    
    public void addProfundidade(){        
        this.profundidade++;
        for (Sumario subitem : subItens){
            subitem.addProfundidade();
        }
    }
    
    public void zerarProfundidade(){
        this.profundidade = 0;
        for (Sumario subitem : subItens){
            subitem.zerarProfundidade();
        }
    }
    
    public void addSubItem(Sumario sumario){
        this.subItens.add(sumario);
    }
    
    public void removeSubItem(Sumario sumario){
        this.subItens.remove(sumario);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeracao() {
        return numeracao;
    }

    public void setNumeracao(String numeracao) {
        this.numeracao = numeracao;
    }

    public List<Sumario> getSubItens() {
        return subItens;
    }

    public void setSubItens(List<Sumario> subItens) {
        this.subItens = subItens;
    }
    
    private String transformarPrfundidadeEmTabs(){
        String resp = "";
        for (int i = 0; i<this.profundidade; i++){
            resp += "\t";
        }
        return resp;
    }
    
    public String getTextoFormatado(){
        String resp = this.transformarPrfundidadeEmTabs() + this.nome + (this.numeracao != null ? " ... " + this.numeracao + "\n" : "\n");
        this.addProfundidade();    
        for (Sumario subitem : subItens){   
            resp += subitem.getTextoFormatado();
        }
        this.zerarProfundidade();
        return resp;
    }
}
