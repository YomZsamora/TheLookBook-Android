
package com.adzumi.thelookbook.models;

import java.util.HashMap;
import java.util.Map;

public class OriginalPublicationDay {

    private String type;
    private String text;
    private String nil;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public OriginalPublicationDay() {
    }

    /**
     * 
     * @param text
     * @param type
     * @param nil
     */
    public OriginalPublicationDay(String type, String text, String nil) {
        super();
        this.type = type;
        this.text = text;
        this.nil = nil;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNil() {
        return nil;
    }

    public void setNil(String nil) {
        this.nil = nil;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
