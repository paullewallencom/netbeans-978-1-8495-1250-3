/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package service;

import entities.Manufacturer;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.WebApplicationException;
import javax.persistence.NoResultException;
import javax.persistence.EntityManager;
import converter.ManufacturerConverter;
import javax.ejb.Stateless;

/**
 *
 * @author dantas
 */

@Stateless
public class ManufacturerResource {
    @Context
    protected UriInfo uriInfo;
    protected EntityManager em;
    protected Integer id;
  
    /** Creates a new instance of ManufacturerResource */
    public ManufacturerResource() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    /**
     * Get method for retrieving an instance of Manufacturer identified by id in XML format.
     *
     * @param id identifier for the entity
     * @return an instance of ManufacturerConverter
     */
    @GET
    @Produces({"application/xml", "application/json"})
    public ManufacturerConverter get(@QueryParam("expandLevel")
                                     @DefaultValue("1")
    int expandLevel) {
        return new ManufacturerConverter(getEntity(), uriInfo.getAbsolutePath(), expandLevel);
    }

    /**
     * Put method for updating an instance of Manufacturer identified by id using XML as the input format.
     *
     * @param id identifier for the entity
     * @param data an ManufacturerConverter entity that is deserialized from a XML stream
     */
    @PUT
    @Consumes({"application/xml", "application/json"})
    public void put(ManufacturerConverter data) {
        updateEntity(getEntity(), data.resolveEntity(em));
    }

    /**
     * Delete method for deleting an instance of Manufacturer identified by id.
     *
     * @param id identifier for the entity
     */
    @DELETE
    public void delete() {
        deleteEntity(getEntity());
    }

    /**
     * Returns an instance of Manufacturer identified by id.
     *
     * @param id identifier for the entity
     * @return an instance of Manufacturer
     */
    protected Manufacturer getEntity() {
        try {
            return (Manufacturer) em.createQuery("SELECT e FROM Manufacturer e where e.manufacturerId = :manufacturerId").setParameter("manufacturerId", id).getSingleResult();
        } catch (NoResultException ex) {
            throw new WebApplicationException(new Throwable("Resource for " + uriInfo.getAbsolutePath() + " does not exist."), 404);
        }
    }

    /**
     * Updates entity using data from newEntity.
     *
     * @param entity the entity to update
     * @param newEntity the entity containing the new data
     * @return the updated entity
     */
    private Manufacturer updateEntity(Manufacturer entity, Manufacturer newEntity) {
        entity = em.merge(newEntity);
        return entity;
    }

    /**
     * Deletes the entity.
     *
     * @param entity the entity to deletle
     */
    private void deleteEntity(Manufacturer entity) {
        em.remove(entity);
    }
}
