package br.com.fatec.server.endpoints;

public class ResultEndpoint {
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
    
    public static ResultEndpoint getSucesso(){
        ResultEndpoint sucesso = new ResultEndpoint();
        sucesso.setSuccess(true);
        return sucesso;
    }
    
    public static ResultEndpoint getSucesso(String mensagem){
        ResultEndpoint sucesso = new ResultEndpoint();
        sucesso.setSuccess(true);
        sucesso.setMensagem(mensagem);
        return sucesso;
    }
    
    public static ResultEndpoint getFalha(){
        ResultEndpoint processo = new ResultEndpoint();
        processo.setSuccess(false);
        return processo;
    }
    
    public static ResultEndpoint getFalha(String mensagem){
        ResultEndpoint processo = new ResultEndpoint();
        processo.setSuccess(false);
        processo.setMensagem(mensagem);
        return processo;
    }
}
