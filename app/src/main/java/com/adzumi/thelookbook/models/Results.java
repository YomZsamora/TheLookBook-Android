
package com.adzumi.thelookbook.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("work")
    @Expose
    private List<Work> work = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Results() {
    }

    /**
     * 
     * @param work
     */
    public Results(List<Work> work) {
        super();
        this.work = work;
    }

    public List<Work> getWork() {
        return work;
    }

    public void setWork(List<Work> work) {
        this.work = work;
    }

}
