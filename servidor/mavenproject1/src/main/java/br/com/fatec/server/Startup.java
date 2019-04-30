package br.com.fatec.server;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class Startup extends ResourceConfig {
    public Startup(){
        packages("br.com.fatec.server.controllers");
    }
}
