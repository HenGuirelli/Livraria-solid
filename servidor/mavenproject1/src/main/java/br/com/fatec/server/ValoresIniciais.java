package br.com.fatec.server;

import br.com.fatec.model.fornecedor.Fornecedor;
import br.com.fatec.model.livro.*;
import br.com.fatec.model.usuario.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Descricao {

    static final String CINCO_PASSOS = "Stella Grant gosta de estar no controle. Ela parece ser uma adolescente típica, mas em sua rotina há listas de tarefas e inúmeros remédios que ela deve tomar para controlar a fibrose cística, uma doença crônica que impede que seus pulmões funcionem como deveriam. Suas prioridades são manter seus pais felizes e conseguir um transplante – e uma coisa não existe sem a outra. Mas para ganhar pulmões novos, Stella precisa seguir seu tratamento à risca e eliminar qualquer chance de infecção, o que significa que ela não pode ficar a menos que dois metros de distância – ou seis passos – de outros pacientes com a doença. O primeiro item é fácil para ela, mas o segundo pode se provar mais difícil do que ela esperava. O único controle que Will Newman deseja é o de sua própria vida. Ele não dá a mínima para o novo tratamento experimental para o qual foi selecionado e não aguenta mais a pressão de sua mãe para que melhore. Prestes a completar dezoito anos, ele mal pode esperar para finalmente se livrar das máquinas e hospitais, usando o pouco de vida que ainda lhe resta para conhecer o mundo. Stella e Will são muito diferentes. Ao mesmo tempo, a doença que os une não é a única coisa que têm em comum. Eles têm que ficar a seis passos um do outro, mas, conforme a conexão entre os dois aumenta, a vontade de burlar a distância física parece insuportável. Um grande amor vale um passo roubado?";
    static final String STARS = "Da mesma autora da série Para todos os garotos que já amei A vida de Isabel Conklin é marcada pelas férias de verão. As outras estações do ano são como um intervalo, dias que passam lentamente enquanto ela espera que o sol lhe traga de volta o que mais ama: o mar, descanso, diversão e, principalmente, Conrad e Jeremiah Fisher. Os garotos da família Fisher sempre estiveram ao lado de Belly em suas aventuras. Conrad é ousado, sombrio, inteligente. Já Jeremiah, é confiável, engraçado, espontâneo. Mesmo sendo tão diferentes, os três constroem uma amizade que parece inabalável. Apenas parece... Tudo muda quando, em uma dessas férias, Conrad demonstra sentir algo por ela. O problema é que Jeremiah faz o mesmo. À medida que os anos passam, Belly sabe que precisará escolher entre os dois e encarar o inevitável: ela vai partir o coração de um deles. Na trilogia Verão, acompanhamos Belly dos 15 aos 24 anos. Em meio a descobertas e mudanças, ela se apaixona, se envolve em um triângulo amo";
    static final String CODIGO_LIMPO = "Mesmo um código ruim pode funcionar. Mas se ele não for limpo, pode acabar com uma empresa de desenvolvimento. Perdem-se a cada ano horas incontáveis e recursos importantes devido a um código mal escrito. O especialista em software, Robert C. Martin, apresenta um paradigma com 'Código limpo - Habilidades Práticas do Agile Software.' Aprenda a ler códigos e descubra o que está correto e errado neles. Reavalie seus valores profissionais e seu comprometimento com o seu ofício. 'Código limpo' está divido em três partes. Na primeira há diversos capítulos que descrevem os princípios, padrões e práticas para criar um código limpo. A segunda parte consiste em diversos casos de estudo de complexidade cada vez maior. Cada um é um exercício para limpar um código - transformar o código base que possui alguns problemas em melhores e mais eficientes. A terceira parte é a compensação - um único capítulo com uma lista de heurísticas e 'odores' reunidos durante a criação dos estudos de caso. O resultado será um conhecimento base que descreve a forma como pensamos quando criamos, lemos e limpamos um código.";
    static final String PADROES_DE_PROJETO1 = "Catálogo de soluções simples e sucintas para os problemas mais freqüentes na área de projeto, assinado por quatro profissionais com grande experiência em software orientado a objetos. Um best-seller mundial.";
}

class ValoresIniciais {

    static List<Usuario> getUsuarios() {
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

    static List<Livro> getLivros() {
        List<Livro> livros = new ArrayList<>();

        // ------------------ A CINCO PASSOS DE VOCÊ ----------------
        Livro livro = new Livro();
        livro.setPreco(32.90f);
        livro.setCategoria("romance");
        livro.setTitulo("A cinco passos de você");
        livro.setResumo(Descricao.CINCO_PASSOS);
        livro.setCapa("acincopassosdevoce.jpg");
        Autor autor = new Autor();
        autor.setNome("Globo Alt");
        livro.addAutor(autor);
        livro.setEditora("saraiva");

        livros.add(livro);

        // --------------- STARS AS ESTRELAS ENTRE NÓS ---------------
        livro = new Livro();
        livro.setTitulo("Stars As Estrelas Entre Nós");
        livro.setCapa("stars.jpg");
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

        // ----------------- CODIGO LIMPO ----------------------
        livro = new Livro();
        livro.setTitulo("Código Limpo");
        livro.setCapa("codigolimpo.jpg");
        livro.setPreco(108.99f);
        livro.setCategoria("educativo");
        autor = new Autor();
        autor.setNome("Robert C. Martin");
        livro.addAutor(autor);
        livro.setResumo(Descricao.CODIGO_LIMPO);

        livros.add(livro);

        // ---------------- PADRÃO DE PROJETO ------------------
        livro = new Livro();
        livro.setTitulo("Padrões de Projetos: Soluções Reutilizáveis de Software Orientados a Objetos ");
        livro.setCapa("padroesdeprojeto1.jpg");
        livro.setPreco(103.90f);
        livro.setCategoria("educativo");
        livro.setResumo(Descricao.PADROES_DE_PROJETO1);

        autor = new Autor();
        autor.setNome("Erich Gamma");
        livro.addAutor(autor);

        autor = new Autor();
        autor.setNome("Richard Helm");
        livro.addAutor(autor);

        autor = new Autor();
        autor.setNome("Ralph Johnson");
        livro.addAutor(autor);

        livros.add(livro);

        return livros;
    }

    static List<Fornecedor> getFornecedores() {
        List<Fornecedor> fornecedores = new ArrayList<>();
        Fornecedor fornecedor = new Fornecedor();
        List<Livro> estoque = new ArrayList<>();

        List<Livro> livros = getLivros();
        for (Livro livro : livros) {
            livro.setQuantidade(1000);
            livro.setPreco(20);
            estoque.add(livro);
        }

        fornecedor.setEstoque(estoque);
        fornecedor.setNome("Fornecedor 1");

        fornecedores.add(fornecedor);

        return fornecedores;
    }
}
