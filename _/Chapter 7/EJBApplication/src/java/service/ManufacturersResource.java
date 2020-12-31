/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.Manufacturer;
import java.util.Collection;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.persistence.EntityManager;
import converter.ManufacturersConverter;
import converter.ManufacturerConverter;
import javax.persistence.PersistenceContext;
import javax.ejb.Stateless;

/**
 *
 * @author dantas
 */

@Path("/manufacturers/")
@Stateless
public class ManufacturersResource {
    @javax.ejb.EJB
    private ManufacturerResource manufacturerResource;
    @Context
    protected UriInfo uriInfo;
    @PersistenceContext(unitName = "EJBApplicationPU")
    protected EntityManager em;
  
    /** Creates a new instance of ManufacturersResource */
    public ManufacturersResource() {
    }

    /**
     * Get method for retrieving a collection of Manufacturer instance in XML format.
     *
     * @return an instance of ManufacturersConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public ManufacturersConverter get(@QueryParam("start")
                                      @DefaultValue("0")
    int start, @QueryParam("max")
               @DefaultValue("10")
    int max, @QueryParam("expandLevel")
             @DefaultValue("1")
    int expandLevel, @QueryParam("query")
                     @DefaultValue("SELECT e FROM Manufacturer e")
    String query) {
        return new ManufacturersConverter(getEntities(start, max, query), uriInfo.getAbsolutePath(), expandLevel);
    }

    /**
     * Post method for creating an instance of Manufacturer using XML as the input format.
     *
     * @param data an ManufacturerConverter entity that is deserialized from an XML stream
     * @return an instance of ManufacturerConverter
     */
    @POST
    @Consumes({"application/xml", "application/json"})
    public Response post(ManufacturerConverter data) {
        Manufacturer entity = data.resolveEntity(em);
        createEntity(data.resolveEntity(em));
        return Response.created(uriInfo.getAbsolutePath().resolve(entity.getManufacturerId() + "/")).build();
    }

    /**
     * Returns a dynamic instance of ManufacturerResource used for entity navigation.
     *
     * @return an instance of ManufacturerResource
     */
    @Path("{manufacturerId}/")
    public ManufacturerResource getManufacturerResource(@PathParam("manufacturerId")
    Integer id) {
        manufacturerResource.setId(id);
        manufacturerResource.setEm(em);
        return manufacturerResource;
    }

    /**
     * Returns all the entities associated with this resource.
     *
     * @return a collection of Manufacturer instances
     */
    protected Collection<Manufacturer> getEntities(int start, int max, String query) {
        return em.createQuery(query).setFirstResult(start).setMaxResults(max).getResultList();
    }

    /**
     * Persist the given entity.
     *
     * @param entity the entity to persist
     */
    protected void createEntity(Manufacturer entity) {
        em.persist(entity);
    }
}
