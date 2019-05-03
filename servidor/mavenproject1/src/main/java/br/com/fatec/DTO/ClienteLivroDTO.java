package br.com.fatec.DTO;

import br.com.fatec.model.livro.Livro;
import br.com.fatec.model.usuario.Cliente;

public class ClienteLivroDTO {
    private Cliente cliente;
    private Livro livro;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
