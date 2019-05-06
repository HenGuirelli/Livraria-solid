package br.com.fatec.DAO;

import br.com.fatec.model.fornecedor.Fornecedor;
import java.util.List;

public class FornecedorDAO extends DAO<Fornecedor>{
    
    private static FornecedorDAO instance;
    
    private FornecedorDAO() {}
    
    public static FornecedorDAO getInstance(){
        if (instance == null){
            instance = new FornecedorDAO();
        }
        return instance;
    }
    
    public void add(Fornecedor fornecedor){
        super.add(fornecedor);
    }
    
    public void remover(Fornecedor fornecedor) {
        super.remove(fornecedor);
    }
    
    public List<Fornecedor> getTodosFornecedores() {
        return super.getAll();
    }
}
