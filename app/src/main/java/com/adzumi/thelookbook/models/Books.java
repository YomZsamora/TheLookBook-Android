
package com.adzumi.thelookbook.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Books {

    @SerializedName("GoodreadsResponse")
    @Expose
    private GoodreadsResponse goodreadsResponse;

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

}
