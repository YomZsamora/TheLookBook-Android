
package com.adzumi.thelookbook.models.Work;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Work {

    @SerializedName("id")
    @Expose
    private Id id;
    @SerializedName("books_count")
    @Expose
    private BooksCount booksCount;
    @SerializedName("ratings_count")
    @Expose
    private RatingsCount ratingsCount;
    @SerializedName("text_reviews_count")
    @Expose
    private TextReviewsCount textReviewsCount;
    @SerializedName("original_publication_year")
    @Expose
    private OriginalPublicationYear originalPublicationYear;
    @SerializedName("original_publication_month")
    @Expose
    private OriginalPublicationMonth originalPublicationMonth;
    @SerializedName("original_publication_day")
    @Expose
    private OriginalPublicationDay originalPublicationDay;
    @SerializedName("average_rating")
    @Expose
    private String averageRating;
    @SerializedName("best_book")
    @Expose
    private BestBook bestBook;

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
     * @param averageRating
     * @param ratingsCount
     * @param bestBook
     * @param originalPublicationDay
     * @param originalPublicationYear
     * @param booksCount
     */
    public Work(Id id, BooksCount booksCount, RatingsCount ratingsCount, TextReviewsCount textReviewsCount, OriginalPublicationYear originalPublicationYear, OriginalPublicationMonth originalPublicationMonth, OriginalPublicationDay originalPublicationDay, String averageRating, BestBook bestBook) {
        super();
        this.id = id;
        this.booksCount = booksCount;
        this.ratingsCount = ratingsCount;
        this.textReviewsCount = textReviewsCount;
        this.originalPublicationYear = originalPublicationYear;
        this.originalPublicationMonth = originalPublicationMonth;
        this.originalPublicationDay = originalPublicationDay;
        this.averageRating = averageRating;
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
        return averageRating;
    }

    public void setAverageRating(String averageRating) {
        this.averageRating = averageRating;
    }

    public BestBook getBestBook() {
        return bestBook;
    }

    public void setBestBook(BestBook bestBook) {
        this.bestBook = bestBook;
    }

}
