package br.com.fatec.server;

import br.com.fatec.model.livro.*;
import br.com.fatec.model.usuario.*;
import java.util.ArrayList;
import java.util.List;

class Descricao {
    static final String CINCO_PASSOS = "Stella Grant gosta de estar no controle. Ela parece ser uma adolescente típica, mas em sua rotina há listas de tarefas e inúmeros remédios que ela deve tomar para controlar a fibrose cística, uma doença crônica que impede que seus pulmões funcionem como deveriam. Suas prioridades são manter seus pais felizes e conseguir um transplante – e uma coisa não existe sem a outra. Mas para ganhar pulmões novos, Stella precisa seguir seu tratamento à risca e eliminar qualquer chance de infecção, o que significa que ela não pode ficar a menos que dois metros de distância – ou seis passos – de outros pacientes com a doença. O primeiro item é fácil para ela, mas o segundo pode se provar mais difícil do que ela esperava. O único controle que Will Newman deseja é o de sua própria vida. Ele não dá a mínima para o novo tratamento experimental para o qual foi selecionado e não aguenta mais a pressão de sua mãe para que melhore. Prestes a completar dezoito anos, ele mal pode esperar para finalmente se livrar das máquinas e hospitais, usando o pouco de vida que ainda lhe resta para conhecer o mundo. Stella e Will são muito diferentes. Ao mesmo tempo, a doença que os une não é a única coisa que têm em comum. Eles têm que ficar a seis passos um do outro, mas, conforme a conexão entre os dois aumenta, a vontade de burlar a distância física parece insuportável. Um grande amor vale um passo roubado?";
    static final String STARS = "Da mesma autora da série Para todos os garotos que já amei A vida de Isabel Conklin é marcada pelas férias de verão. As outras estações do ano são como um intervalo, dias que passam lentamente enquanto ela espera que o sol lhe traga de volta o que mais ama: o mar, descanso, diversão e, principalmente, Conrad e Jeremiah Fisher. Os garotos da família Fisher sempre estiveram ao lado de Belly em suas aventuras. Conrad é ousado, sombrio, inteligente. Já Jeremiah, é confiável, engraçado, espontâneo. Mesmo sendo tão diferentes, os três constroem uma amizade que parece inabalável. Apenas parece... Tudo muda quando, em uma dessas férias, Conrad demonstra sentir algo por ela. O problema é que Jeremiah faz o mesmo. À medida que os anos passam, Belly sabe que precisará escolher entre os dois e encarar o inevitável: ela vai partir o coração de um deles. Na trilogia Verão, acompanhamos Belly dos 15 aos 24 anos. Em meio a descobertas e mudanças, ela se apaixona, se envolve em um triângulo amo";
}

class ValoresIniciais {
    static List<Usuario> getUsuarios(){
        List<Usuario> users = new ArrayList<>();
        
        Funcionario funcionario = new Funcionario();
        funcionario.setLogin("admin");
        funcionario.setSenha("admin");
        
        Cliente cliente = new Cliente();
        cliente.setLogin("user");
        cliente.setSenha("user");
        
        users.add(funcionario);
        users.add(cliente);
        
        return users;
    }
    
    static List<Livro> getLivros(){
        List<Livro> livros = new ArrayList<>();
        
        Livro livro = new Livro();
        livro.setPreco(32.90f);
        livro.setCategoria("romance");
        livro.setTitulo("A cinco passos de você");
        livro.setResumo(Descricao.CINCO_PASSOS);
        Autor autor = new Autor();
        autor.setNome("Globo Alt");
        livro.addAutor(autor);
        livro.setEditora("saraiva");
        
        livros.add(livro);
        
        livro = new Livro();
        livro.setTitulo("Stars As Estrelas Entre Nós");
        livro.setPreco(19.90f);
        livro.setCategoria("romance");
        autor = new Autor();
        autor.setNome("Hann");
        livro.addAutor(autor);
        autor = new Autor();
        autor.setNome("Jenn");
        livro.addAutor(autor);
        livro.setResumo(Descricao.STARS);
        livro.setEditora("abril");
        
        livros.add(livro);
        
        return livros;
    }
}