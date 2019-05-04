package br.com.fatec.DAO;

import java.util.ArrayList;
import java.util.List;

public class CodigoDAO {

    private List<String> codigos = new ArrayList<>();
    private static CodigoDAO instance;

    private CodigoDAO() {
    }

    public static CodigoDAO getInstance() {
        if (instance == null) {
            instance = new CodigoDAO();
        }
        return instance;
    }

    public void add(String codigo) {
        codigos.add(codigo);
    }

    public boolean codigoExiste(String codigo) {
        return codigos.contains(codigo);
    }
}
