package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookModel {
    private int id;
    private String bookId;
    private String bookName;
    private Topic topic;
    private int pageNumber;
    private LocalDate releaseDate;
    private int authorId;
    private boolean isBorrow;
}
