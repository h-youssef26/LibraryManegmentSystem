package model;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@Entity
@Table(name = "Library")
public @Data class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int capacity;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id")
    private Set<Book> books = new HashSet<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
