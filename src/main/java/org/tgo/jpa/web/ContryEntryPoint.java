package org.tgo.jpa.web;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.tgo.jpa.services.CountryService;

@Path("/coutry")
public class ContryEntryPoint {
    
    @EJB
    private CountryService countryService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCoutries() {
        return Response.ok(countryService.getAllCountries(), MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/cities")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountriesFetchCities() {
        return Response.ok(countryService.getAllCountriesAndCities(), MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/{id}/cities")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountryFetchCities(@PathParam("id") int contryId) {
        return Response.ok(countryService.getCountryFetchCities(contryId), MediaType.APPLICATION_JSON).build();
    }
    
    @GET
    @Path("/named")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCountryWithCityNamed(@QueryParam("name") String cityName) {
        return Response.ok(countryService.getCountryWithCityNamed(cityName), MediaType.APPLICATION_JSON).build();
    }

}
