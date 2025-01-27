/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import entities.Manufacturer;
import java.net.URI;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAttribute;
import java.util.ArrayList;

/**
 *
 * @author dantas
 */

@XmlRootElement(name = "manufacturers")
public class ManufacturersConverter {
    private Collection<Manufacturer> entities;
    private Collection<ManufacturerConverter> items;
    private URI uri;
    private int expandLevel;
  
    /** Creates a new instance of ManufacturersConverter */
    public ManufacturersConverter() {
    }

    /**
     * Creates a new instance of ManufacturersConverter.
     *
     * @param entities associated entities
     * @param uri associated uri
     * @param expandLevel indicates the number of levels the entity graph should be expanded
     */
    public ManufacturersConverter(Collection<Manufacturer> entities, URI uri, int expandLevel) {
        this.entities = entities;
        this.uri = uri;
        this.expandLevel = expandLevel;
        getManufacturer();
    }

    /**
     * Returns a collection of ManufacturerConverter.
     *
     * @return a collection of ManufacturerConverter
     */
    @XmlElement
    public Collection<ManufacturerConverter> getManufacturer() {
        if (items == null) {
            items = new ArrayList<ManufacturerConverter>();
        }
        if (entities != null) {
            items.clear();
            for (Manufacturer entity : entities) {
                items.add(new ManufacturerConverter(entity, uri, expandLevel, true));
            }
        }
        return items;
    }

    /**
     * Sets a collection of ManufacturerConverter.
     *
     * @param a collection of ManufacturerConverter to set
     */
    public void setManufacturer(Collection<ManufacturerConverter> items) {
        this.items = items;
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
     * Returns a collection Manufacturer entities.
     *
     * @return a collection of Manufacturer entities
     */
    @XmlTransient
    public Collection<Manufacturer> getEntities() {
        entities = new ArrayList<Manufacturer>();
        if (items != null) {
            for (ManufacturerConverter item : items) {
                entities.add(item.getEntity());
            }
        }
        return entities;
    }
}
