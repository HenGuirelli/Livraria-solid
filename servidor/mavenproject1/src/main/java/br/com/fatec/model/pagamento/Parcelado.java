package br.com.fatec.model.pagamento;

public class Parcelado extends Pagamento {

    @Override
    public float calcularDesconto() {
        return 0;
    }
}
