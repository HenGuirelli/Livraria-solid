package br.com.fatec.enums;

public enum FormaPagamento {
    A_VISTA,
    PARCELADO;

    public static FormaPagamento convert(String text) {
        return text.toLowerCase().equals("parcelado") ? FormaPagamento.PARCELADO : FormaPagamento.A_VISTA;
    }
}
