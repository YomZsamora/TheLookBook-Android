
package com.adzumi.thelookbook.models;

import com.adzumi.thelookbook.models.Author;

import java.util.HashMap;
import java.util.Map;

public class BestBook {

    private String type;
    private Id_ id;
    private String title;
    private Author author;
    private String imageUrl;
    private String smallImageUrl;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public BestBook() {
    }

    /**
     * 
     * @param id
     * @param author
     * @param title
     * @param imageUrl
     * @param smallImageUrl
     * @param type
     */
    public BestBook(String type, Id_ id, String title, Author author, String imageUrl, String smallImageUrl) {
        super();
        this.type = type;
        this.id = id;
        this.title = title;
        this.author = author;
        this.imageUrl = imageUrl;
        this.smallImageUrl = smallImageUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Id_ getId() {
        return id;
    }

    public void setId(Id_ id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSmallImageUrl() {
        return smallImageUrl;
    }

    public void setSmallImageUrl(String smallImageUrl) {
        this.smallImageUrl = smallImageUrl;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
