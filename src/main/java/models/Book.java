package models;

import jakarta.persistence.*;
import java.sql.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "Books")
public  @Data class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  id;

    @Column(nullable = false)
    private String name;

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    private String categories;


    @Column(nullable = false)
    private boolean borrowedStatus = false;

    private Integer borrowingPeriod;

    private Date borrowingDate;

    private double price;

    public Book(int id, String name, String author, double price) {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String author;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;

    @ManyToOne
    @JoinColumn(name = "borrowed_by_user_id")
    private User borrowedBy;

    public String getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    private String yearPublished;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBorrowedStatus() {
        return borrowedStatus;
    }

    public void setBorrowedStatus(boolean borrowedStatus) {
        this.borrowedStatus = borrowedStatus;
    }

    public Integer getBorrowingPeriod() {
        return borrowingPeriod;
    }

    public void setBorrowingPeriod(Integer borrowingPeriod) {
        this.borrowingPeriod = borrowingPeriod;
    }

    public Date getBorrowingDate() {
        return borrowingDate;
    }

    public void setBorrowingDate(Date borrowingDate) {
        this.borrowingDate = borrowingDate;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

}

