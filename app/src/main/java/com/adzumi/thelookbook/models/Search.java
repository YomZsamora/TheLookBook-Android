
package com.adzumi.thelookbook.models;

import com.adzumi.thelookbook.Results;

import java.util.HashMap;
import java.util.Map;

public class Search {

    private String query;
    private String resultsStart;
    private String resultsEnd;
    private String totalResults;
    private String source;
    private String queryTimeSeconds;
    private Results results;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
