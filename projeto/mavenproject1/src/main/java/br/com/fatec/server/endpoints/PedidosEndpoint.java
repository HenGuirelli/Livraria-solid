package br.com.fatec.server.endpoints;

import br.com.fatec.model.pedido.Pedido;
import br.com.fatec.model.usuario.Cliente;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("pedidos")
public class PedidosEndpoint {

    private final br.com.fatec.controller.PedidoController controller = new br.com.fatec.controller.PedidoController();
    private final br.com.fatec.controller.ClienteController clienteController = new br.com.fatec.controller.ClienteController();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pedido> getPedidos() {
        List<Pedido> pedidos = controller.listar();
        return pedidos;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/atendimento")
    public List<Pedido> filtrarPedidosEmAtendimento() {
        return controller.pegarPedidosEmAtendimento();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/entregue")
    public List<Pedido> filtrarPedidosEntregue() {
        return controller.pegarPedidosEntregue();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/enviado")
    public List<Pedido> filtrarPedidosEnviados() {
        return controller.pegarPedidosEnviados();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cliente/{cliente}")
    public List<Pedido> filtrarPedidosPorCliente(@PathParam("cliente") String cliente) {
        Cliente c = clienteController.getCliente(cliente);
        try {
            return c.getPedidos();
        } catch (Exception ex) {
            return null;
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/alterar/enviado")
    public ResultEndpoint alterarEstadoPedidoEnviado(AlteracaoPedidoRequest body) {
        try {
            controller.alterarEstadoPedidoEnviado(body.getCodigo());
            return ResultEndpoint.getSucesso();
        } catch (Exception ex) {
            return ResultEndpoint.getFalha();
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/alterar/entregue")
    public ResultEndpoint alterarEstadoPedidoEntregue(AlteracaoPedidoRequest body) {
        try {
            controller.alterarEstadoPedidoEntregue(body.getCodigo());
            return ResultEndpoint.getSucesso();
        } catch (Exception ex) {
            return ResultEndpoint.getFalha();
        }
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/alterar/atendimento")
    public ResultEndpoint alterarEstadoPedidoEmAtendimento(AlteracaoPedidoRequest body) {
        try {
            controller.alterarEstadoPedidoEmAtendimento(body.getCodigo());
            return ResultEndpoint.getSucesso();
        } catch (Exception ex) {
            return ResultEndpoint.getFalha();
        }
    }
    
}

class AlteracaoPedidoRequest {
    private String codigo;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
