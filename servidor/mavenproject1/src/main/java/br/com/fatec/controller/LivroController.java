package br.com.fatec.controller;

import br.com.fatec.DAO.LivroDAO;
import br.com.fatec.model.produto.Autor;
import br.com.fatec.model.produto.Livro;
import java.util.ArrayList;
import java.util.List;

public class LivroController {

    public List<Livro> getLivros() {
        LivroDAO dao = LivroDAO.getInstance();
        return dao.getLivros();
    }

    public List<Livro> getLivrosPorCategoria(String categoria) {
        LivroDAO dao = LivroDAO.getInstance();
        return dao.getLivroPorCategoria(categoria);
    }

    public List<Livro> getLivrosPorEditora(String editora) {
        LivroDAO dao = LivroDAO.getInstance();
        return dao.getLivroPorEditora(editora);
    }

    public List<Livro> getLivrosPorNome(String nome) {
        LivroDAO dao = LivroDAO.getInstance();
        return dao.getLivroPorNome(nome);
    }

    public List<Livro> buscarLivro(String pesquisa) {
        List<Livro> livros = getLivros();
        List<Livro> resp = new ArrayList<>();

        for (Livro livro : livros) {
            float proximidadeTitulo = calcularGrauDeProximidade(livro.getTitulo(), pesquisa);
            float proximidadeEditora = calcularGrauDeProximidade(livro.getEditora(), pesquisa);
            float[] proximidadeAutores = new float[livro.getAutores().size()];
            int i = 0;
            for (Autor autor : livro.getAutores()) {
                proximidadeAutores[i] = calcularGrauDeProximidade(autor.getNome(), pesquisa);
                i++;
            }
            float maiorProximidadeAutor = max(proximidadeAutores);

            if (Math.max(Math.max(proximidadeTitulo, proximidadeEditora), maiorProximidadeAutor) > 0.5) {
                resp.add(livro);
            }
        }
        return resp;
    }

    private float max(float[] numeros) {
        try {
            float primeiro = numeros[0];
            float maior = primeiro;
            for (int i = 0; i < numeros.length; i++) {
                if (numeros[i] > primeiro) {
                    maior = numeros[i];
                }
            }
            return maior;
        } catch (ArithmeticException ex) {
            return 0;
        }
    }

    private float calcularGrauDeProximidade(String str1, String str2) {
        if (str1 == null || str2 == null){
            return 0;
        }
        
        if (str1.contains(str2)){
            return 1;
        }
        
        char[] _str1 = str1.toCharArray();
        char[] _str2 = str2.toCharArray();

        float grau = 0;
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (_str1[i] == _str2[i]) {
                grau++;
            }else{
                try {
                    if (str1.charAt(_str2[i]) != -1){
                        grau += 0.4;
                    }
                } catch (Exception ex) {}
            }
        }
        return grau / Math.min(str1.length(), str2.length());
    }
}
