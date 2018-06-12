
package com.adzumi.thelookbook.models;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private String authentication;
    private String key;
    private String method;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Request() {
    }

    /**
     * 
     * @param authentication
     * @param method
     * @param key
     */
    public Request(String authentication, String key, String method) {
        super();
        this.authentication = authentication;
        this.key = key;
        this.method = method;
    }

    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
