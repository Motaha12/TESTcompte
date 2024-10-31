package com.example.banquee.Configuration;

import com.example.banquee.entity.Compte;
import com.example.banquee.repository.CompteRepository;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banquee")
public class CompteRestJaxRSAPI {
    @Autowired
    private CompteRepository compteRepository;


    @Path("/compte")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Compte> getComptes(){
        return compteRepository.findAll();
    }
    @Path("/compte/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getCompteById(@PathParam("id") Long id) {
        return compteRepository.findById(id).orElse(null);

    }
    @Path("/compte")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Compte addCompte(Compte compte){
        return compteRepository.save(compte);
    }
    @Path("/compte/{id}")
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Compte updateCompte(Compte compte1, @PathParam("id") Long id) {
        Compte existingCompte = compteRepository.findById(id).orElse(null);
    if (existingCompte != null) {
        existingCompte.setSolde(compte1.getSolde());
        existingCompte.setDateCreation(compte1.getDateCreation());
        existingCompte.setType(compte1.getType());
        return compteRepository.save(existingCompte);

    }
    return null;
    }
    @Path("/compte/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteCompte(@PathParam("id") Long id){
        compteRepository.deleteById(id);
    }
}
