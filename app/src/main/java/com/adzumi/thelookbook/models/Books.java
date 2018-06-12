
package com.adzumi.thelookbook.models;

import java.util.HashMap;
import java.util.Map;

public class Books {

    private GoodreadsResponse goodreadsResponse;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Books() {
    }

    /**
     * 
     * @param goodreadsResponse
     */
    public Books(GoodreadsResponse goodreadsResponse) {
        super();
        this.goodreadsResponse = goodreadsResponse;
    }

    public GoodreadsResponse getGoodreadsResponse() {
        return goodreadsResponse;
    }

    public void setGoodreadsResponse(GoodreadsResponse goodreadsResponse) {
        this.goodreadsResponse = goodreadsResponse;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
