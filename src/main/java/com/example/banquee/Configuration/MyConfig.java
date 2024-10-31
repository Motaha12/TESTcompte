package com.example.banquee.Configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;

public class MyConfig {
    @Bean
    public ResourceConfig resourceConfig(ResourceConfig jerseyServlet){
         ResourceConfig jerseyConfig = new ResourceConfig();
         jerseyServlet.register(CompteRestJaxRSAPI.class);
         return jerseyServlet;
    }
}
