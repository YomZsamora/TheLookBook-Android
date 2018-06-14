
package com.adzumi.thelookbook.models;

import com.adzumi.thelookbook.models.BestBook;
import com.adzumi.thelookbook.models.BooksCount;
import com.adzumi.thelookbook.models.Id;
import com.adzumi.thelookbook.models.OriginalPublicationDay;
import com.adzumi.thelookbook.models.OriginalPublicationMonth;
import com.adzumi.thelookbook.models.OriginalPublicationYear;
import com.adzumi.thelookbook.models.RatingsCount;
import com.adzumi.thelookbook.models.TextReviewsCount;

import java.util.HashMap;
import java.util.Map;

public class Work {

    private Id id;
    private BooksCount booksCount;
    private RatingsCount ratingsCount;
    private TextReviewsCount textReviewsCount;
    private OriginalPublicationYear originalPublicationYear;
    private OriginalPublicationMonth originalPublicationMonth;
    private OriginalPublicationDay originalPublicationDay;
    private String average_rating;
    private BestBook bestBook;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Work() {
    }

    /**
     * 
     * @param originalPublicationMonth
     * @param textReviewsCount
     * @param id
     * @param average_rating
     * @param ratingsCount
     * @param bestBook
     * @param originalPublicationDay
     * @param originalPublicationYear
     * @param booksCount
     */
    public Work(Id id, BooksCount booksCount, RatingsCount ratingsCount, TextReviewsCount textReviewsCount, OriginalPublicationYear originalPublicationYear, OriginalPublicationMonth originalPublicationMonth, OriginalPublicationDay originalPublicationDay, String average_rating, BestBook bestBook) {
        super();
        this.id = id;
        this.booksCount = booksCount;
        this.ratingsCount = ratingsCount;
        this.textReviewsCount = textReviewsCount;
        this.originalPublicationYear = originalPublicationYear;
        this.originalPublicationMonth = originalPublicationMonth;
        this.originalPublicationDay = originalPublicationDay;
        this.average_rating = average_rating;
        this.bestBook = bestBook;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public BooksCount getBooksCount() {
        return booksCount;
    }

    public void setBooksCount(BooksCount booksCount) {
        this.booksCount = booksCount;
    }

    public RatingsCount getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(RatingsCount ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public TextReviewsCount getTextReviewsCount() {
        return textReviewsCount;
    }

    public void setTextReviewsCount(TextReviewsCount textReviewsCount) {
        this.textReviewsCount = textReviewsCount;
    }

    public OriginalPublicationYear getOriginalPublicationYear() {
        return originalPublicationYear;
    }

    public void setOriginalPublicationYear(OriginalPublicationYear originalPublicationYear) {
        this.originalPublicationYear = originalPublicationYear;
    }

    public OriginalPublicationMonth getOriginalPublicationMonth() {
        return originalPublicationMonth;
    }

    public void setOriginalPublicationMonth(OriginalPublicationMonth originalPublicationMonth) {
        this.originalPublicationMonth = originalPublicationMonth;
    }

    public OriginalPublicationDay getOriginalPublicationDay() {
        return originalPublicationDay;
    }

    public void setOriginalPublicationDay(OriginalPublicationDay originalPublicationDay) {
        this.originalPublicationDay = originalPublicationDay;
    }

    public String getAverageRating() {
        return average_rating;
    }

    public void setAverageRating(String averageRating) {
        this.average_rating = averageRating;
    }

    public BestBook getBestBook() {
        return bestBook;
    }

    public void setBestBook(BestBook bestBook) {
        this.bestBook = bestBook;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
