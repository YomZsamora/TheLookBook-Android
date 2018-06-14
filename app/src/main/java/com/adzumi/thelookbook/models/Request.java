
package com.adzumi.thelookbook.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    @SerializedName("authentication")
    @Expose
    private String authentication;
    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("method")
    @Expose
    private String method;

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

}
