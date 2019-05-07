package br.com.fatec.model.pagamento;

public class AVista extends Pagamento {

    @Override
    public float calcularDesconto() {
        return 0.05f;
    }
}
