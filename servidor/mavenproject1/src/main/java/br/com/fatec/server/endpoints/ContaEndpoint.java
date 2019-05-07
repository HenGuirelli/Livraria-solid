package br.com.fatec.server.endpoints;

import br.com.fatec.model.usuario.Funcionario;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("conta")
public class ContaEndpoint {
    private final br.com.fatec.controller.ContaController controller = new br.com.fatec.controller.ContaController();
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login")
    public ResponseLogin logar(br.com.fatec.model.usuario.Usuario usuario){
        ResponseLogin result = new ResponseLogin();
        result.setSuccess(controller.logar(usuario.getLogin(), usuario.getSenha()));
        result.setIsFuncionario(controller.getUsuario(usuario.getLogin(), usuario.getSenha()) instanceof Funcionario);
        return result;
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cadastro")
    public ResultEndpoint criarConta(br.com.fatec.model.usuario.Cliente usuario){
        System.out.println(usuario.getLogin() + " " + usuario.getSenha());
        
        controller.criarConta(usuario.getLogin(), usuario.getSenha(), usuario.getNome());
        
        ResultEndpoint result = new ResultEndpoint();
        result.setSuccess(true);
        return result;
    }
}

class ResponseLogin extends ResultEndpoint {
    private boolean isFuncionario = false;

    public boolean isIsFuncionario() {
        return isFuncionario;
    }

    public void setIsFuncionario(boolean isFuncionario) {
        this.isFuncionario = isFuncionario;
    }
}