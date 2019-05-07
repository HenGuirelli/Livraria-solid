package br.com.fatec.model.pagamento;

public abstract class Decorator extends Pagamento {
    
    protected Pagamento pagamento;    
    
    public Decorator(Pagamento pagamento){
        this.pagamento = pagamento;
    }
}
