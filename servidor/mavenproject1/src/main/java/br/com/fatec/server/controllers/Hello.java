package br.com.fatec.server.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

class Usuario {
    private String nome = "Robson";
    private String sobrenome = "aaa";

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}

@Path("hello")
public class Hello {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario getMensagem(@QueryParam("usuario") String usuario){
        return new Usuario();
    }
    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("usuario/{id}")
    public String getUser(@PathParam("id") long id){
        return "usuario ID: " + id;
    }
}
