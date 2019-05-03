package br.com.fatec.server.controllers;

public class ResultProcesso {
    private boolean success;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
    
    public static ResultProcesso getSucesso(){
        ResultProcesso sucesso = new ResultProcesso();
        sucesso.setSuccess(true);
        return sucesso;
    }
    
    public static ResultProcesso getFalha(){
        ResultProcesso sucesso = new ResultProcesso();
        sucesso.setSuccess(false);
        return sucesso;
    }
}
