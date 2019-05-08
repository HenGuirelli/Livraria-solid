package livraria;

import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.livro.Livro;

public class Livraria {
    private static int cont = 0;
    public LivroDAO dao = new LivroDAO();
    
    public void addLivro(){
        Livro livro = new Livro();
        livro.setTitulo("livro " + cont);
        cont++;
        dao.add(livro);
    }    
    
    public static void main(String[] args) {
        Livraria livraria = new Livraria();
        for(int i = 0; i < 10; i++){
            livraria.addLivro();
        }
        livraria.dao.pretty("titulo");
        for(Livro livroFiltrado : livraria.dao.filter("titulo", "livro 0")){
            System.out.println(livroFiltrado.getTitulo());
        }
    }
}
