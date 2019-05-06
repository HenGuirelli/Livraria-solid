package br.com.fatec.server.controllers;

public class ResultProcesso {
    private boolean success;
    private String mensagem;
    
    
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public static ResultProcesso getSucesso(){
        ResultProcesso sucesso = new ResultProcesso();
        sucesso.setSuccess(true);
        return sucesso;
    }
    
    public static ResultProcesso getSucesso(String mensagem){
        ResultProcesso sucesso = new ResultProcesso();
        sucesso.setSuccess(true);
        sucesso.setMensagem(mensagem);
        return sucesso;
    }
    
    public static ResultProcesso getFalha(){
        ResultProcesso processo = new ResultProcesso();
        processo.setSuccess(false);
        return processo;
    }
    
    public static ResultProcesso getFalha(String mensagem){
        ResultProcesso processo = new ResultProcesso();
        processo.setSuccess(false);
        processo.setMensagem(mensagem);
        return processo;
    }
}
