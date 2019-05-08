package br.com.fatec.DAO;

import br.com.fatec.model.carrinho.Carrinho;
import br.com.fatec.model.carrinho.ItemCarrinho;
import br.com.fatec.model.usuario.Cliente;
import java.util.HashMap;

public class CarrinhoDAO {
    private HashMap<Cliente, Carrinho> data = new HashMap();
    
    public void addItem(Cliente cliente, ItemCarrinho item){
        boolean clienteExiste = data.containsKey(cliente);
        
        if (clienteExiste)
            data.get(cliente).addItem(item);
        else{
            data.put(cliente, cliente.getCarrinho());
            cliente.getCarrinho().addItem(item);
        }
    }
    
    public void removerItem(Cliente cliente, ItemCarrinho item){
        boolean clienteExiste = data.containsKey(cliente);
        
        if (clienteExiste){
            data.get(cliente).removeItem(item);
        }
    }
}
