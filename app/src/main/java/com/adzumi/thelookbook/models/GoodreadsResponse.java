
package com.adzumi.thelookbook.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoodreadsResponse {

    @SerializedName("Request")
    @Expose
    private Request request;
    @SerializedName("search")
    @Expose
    private Search search;

    /**
     * No args constructor for use in serialization
     * 
     */
    public GoodreadsResponse() {
    }

    /**
     * 
     * @param search
     * @param request
     */
    public GoodreadsResponse(Request request, Search search) {
        super();
        this.request = request;
        this.search = search;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Search getSearch() {
        return search;
    }

    public void setSearch(Search search) {
        this.search = search;
    }

}
