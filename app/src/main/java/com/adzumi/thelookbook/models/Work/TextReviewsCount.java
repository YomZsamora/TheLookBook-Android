
package com.adzumi.thelookbook.models.Work;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class TextReviewsCount {

    @SerializedName("-type")
    @Expose
    private String type;
    @SerializedName("#text")
    @Expose
    private String text;

    /**
     * No args constructor for use in serialization
     * 
     */
    public TextReviewsCount() {
    }

    /**
     * 
     * @param text
     * @param type
     */
    public TextReviewsCount(String type, String text) {
        super();
        this.type = type;
        this.text = text;
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

}
