package br.com.fatec.server.controllers;

import br.com.fatec.DAO.ClienteDAO;
import br.com.fatec.DAO.ContaDAO;
import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.usuario.Cliente;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("pedidos")
public class PedidosController {
    private final br.com.fatec.controller.PedidoController controller = new br.com.fatec.controller.PedidoController();
    private final br.com.fatec.controller.ClienteController clienteController = new br.com.fatec.controller.ClienteController();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> getPedidos(){
        return controller.listar();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/atendimento")
    public List<Pedido> filtrarPedidosEmAtendimento(){
        return controller.pegarPedidosEmAtendimento();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/entregue")
    public List<Pedido> filtrarPedidosEntregue(){
        return controller.pegarPedidosEntregue();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/enviado")
    public List<Pedido> filtrarPedidosEnviados(){
        return controller.pegarPedidosEnviados();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cliente/{cliente}")
    public List<Pedido> filtrarPedidosPorCliente(@PathParam("cliente") String cliente){
        Cliente c = clienteController.getCliente(cliente);
        return clienteController.pegarPedidos(c);
    }
}
