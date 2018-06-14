
package com.adzumi.thelookbook.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Search {

    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("results-start")
    @Expose
    private String resultsStart;
    @SerializedName("results-end")
    @Expose
    private String resultsEnd;
    @SerializedName("total-results")
    @Expose
    private String totalResults;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("query-time-seconds")
    @Expose
    private String queryTimeSeconds;
    @SerializedName("results")
    @Expose
    private Results results;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Search() {
    }

    /**
     * 
     * @param results
     * @param source
     * @param totalResults
     * @param query
     * @param queryTimeSeconds
     * @param resultsStart
     * @param resultsEnd
     */
    public Search(String query, String resultsStart, String resultsEnd, String totalResults, String source, String queryTimeSeconds, Results results) {
        super();
        this.query = query;
        this.resultsStart = resultsStart;
        this.resultsEnd = resultsEnd;
        this.totalResults = totalResults;
        this.source = source;
        this.queryTimeSeconds = queryTimeSeconds;
        this.results = results;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getResultsStart() {
        return resultsStart;
    }

    public void setResultsStart(String resultsStart) {
        this.resultsStart = resultsStart;
    }

    public String getResultsEnd() {
        return resultsEnd;
    }

    public void setResultsEnd(String resultsEnd) {
        this.resultsEnd = resultsEnd;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getQueryTimeSeconds() {
        return queryTimeSeconds;
    }

    public void setQueryTimeSeconds(String queryTimeSeconds) {
        this.queryTimeSeconds = queryTimeSeconds;
    }

    public Results getResults() {
        return results;
    }

    public void setResults(Results results) {
        this.results = results;
    }

}
