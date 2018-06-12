
package com.adzumi.thelookbook.models;

import java.util.HashMap;
import java.util.Map;

public class Author {

    private Id__ id;
    private String name;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Author() {
    }

    /**
     * 
     * @param id
     * @param name
     */
    public Author(Id__ id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public Id__ getId() {
        return id;
    }

    public void setId(Id__ id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
