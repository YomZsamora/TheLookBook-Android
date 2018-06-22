
package com.adzumi.thelookbook.models.Work;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Author {

    @SerializedName("id")
    @Expose
    private Id__ id;
    @SerializedName("name")
    @Expose
    private String name;

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

}
