/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import entities.Manufacturer;
import java.net.URI;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import javax.ws.rs.core.UriBuilder;
import javax.persistence.EntityManager;

/**
 *
 * @author dantas
 */

@XmlRootElement(name = "manufacturer")
public class ManufacturerConverter {
    private Manufacturer entity;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of ManufacturerConverter */
    public ManufacturerConverter() {
        entity = new Manufacturer();
    }

    /**
     * Creates a new instance of ManufacturerConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded@param isUriExtendable indicates whether the uri can be extended
     */
    public ManufacturerConverter(Manufacturer entity, URI uri, int expandLevel, boolean isUriExtendable) {
        this.entity = entity;
        this.uri = (isUriExtendable) ? UriBuilder.fromUri(uri).path(entity.getManufacturerId() + "/").build() : uri;
        this.expandLevel = expandLevel;
    }

    /**
     * Creates a new instance of ManufacturerConverter.
     *
     * @param entity associated entity
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public ManufacturerConverter(Manufacturer entity, URI uri, int expandLevel) {
        this(entity, uri, expandLevel, false);
    }

    /**
     * Getter for manufacturerId.
     *
     * @return value for manufacturerId
     */
    @XmlElement
    public Integer getManufacturerId() {
        return (expandLevel > 0) ? entity.getManufacturerId() : null;
    }

    /**
     * Setter for manufacturerId.
     *
     * @param value the value to set
     */
    public void setManufacturerId(Integer value) {
        entity.setManufacturerId(value);
    }

    /**
     * Getter for name.
     *
     * @return value for name
     */
    @XmlElement
    public String getName() {
        return (expandLevel > 0) ? entity.getName() : null;
    }

    /**
     * Setter for name.
     *
     * @param value the value to set
     */
    public void setName(String value) {
        entity.setName(value);
    }

    /**
     * Getter for addressline1.
     *
     * @return value for addressline1
     */
    @XmlElement
    public String getAddressline1() {
        return (expandLevel > 0) ? entity.getAddressline1() : null;
    }

    /**
     * Setter for addressline1.
     *
     * @param value the value to set
     */
    public void setAddressline1(String value) {
        entity.setAddressline1(value);
    }

    /**
     * Getter for addressline2.
     *
     * @return value for addressline2
     */
    @XmlElement
    public String getAddressline2() {
        return (expandLevel > 0) ? entity.getAddressline2() : null;
    }

    /**
     * Setter for addressline2.
     *
     * @param value the value to set
     */
    public void setAddressline2(String value) {
        entity.setAddressline2(value);
    }

    /**
     * Getter for city.
     *
     * @return value for city
     */
    @XmlElement
    public String getCity() {
        return (expandLevel > 0) ? entity.getCity() : null;
    }

    /**
     * Setter for city.
     *
     * @param value the value to set
     */
    public void setCity(String value) {
        entity.setCity(value);
    }

    /**
     * Getter for state.
     *
     * @return value for state
     */
    @XmlElement
    public String getState() {
        return (expandLevel > 0) ? entity.getState() : null;
    }

    /**
     * Setter for state.
     *
     * @param value the value to set
     */
    public void setState(String value) {
        entity.setState(value);
    }

    /**
     * Getter for zip.
     *
     * @return value for zip
     */
    @XmlElement
    public String getZip() {
        return (expandLevel > 0) ? entity.getZip() : null;
    }

    /**
     * Setter for zip.
     *
     * @param value the value to set
     */
    public void setZip(String value) {
        entity.setZip(value);
    }

    /**
     * Getter for phone.
     *
     * @return value for phone
     */
    @XmlElement
    public String getPhone() {
        return (expandLevel > 0) ? entity.getPhone() : null;
    }

    /**
     * Setter for phone.
     *
     * @param value the value to set
     */
    public void setPhone(String value) {
        entity.setPhone(value);
    }

    /**
     * Getter for fax.
     *
     * @return value for fax
     */
    @XmlElement
    public String getFax() {
        return (expandLevel > 0) ? entity.getFax() : null;
    }

    /**
     * Setter for fax.
     *
     * @param value the value to set
     */
    public void setFax(String value) {
        entity.setFax(value);
    }

    /**
     * Getter for email.
     *
     * @return value for email
     */
    @XmlElement
    public String getEmail() {
        return (expandLevel > 0) ? entity.getEmail() : null;
    }

    /**
     * Setter for email.
     *
     * @param value the value to set
     */
    public void setEmail(String value) {
        entity.setEmail(value);
    }

    /**
     * Getter for rep.
     *
     * @return value for rep
     */
    @XmlElement
    public String getRep() {
        return (expandLevel > 0) ? entity.getRep() : null;
    }

    /**
     * Setter for rep.
     *
     * @param value the value to set
     */
    public void setRep(String value) {
        entity.setRep(value);
    }

    /**
     * Returns the URI associated with this converter.
     *
     * @return the uri
     */
    @XmlAttribute
    public URI getUri() {
        return uri;
    }

    /**
     * Sets the URI for this reference converter.
     *
     */
    public void setUri(URI uri) {
        this.uri = uri;
    }

    /**
     * Returns the Manufacturer entity.
     *
     * @return an entity
     */
    @XmlTransient
    public Manufacturer getEntity() {
        if (entity.getManufacturerId() == null) {
            ManufacturerConverter converter = UriResolver.getInstance().resolve(ManufacturerConverter.class, uri);
            if (converter != null) {
                entity = converter.getEntity();
            }
        }
        return entity;
    }

    /**
     * Returns the resolved Manufacturer entity.
     *
     * @return an resolved entity
     */
    public Manufacturer resolveEntity(EntityManager em) {
        return entity;
    }
}
