package org.example;

import org.example.model.AuthorModel;
import org.example.model.BookModel;
import org.example.model.SubscriberModel;
import org.example.model.Topic;
import org.example.repository.AuthorCrudOperations;
import org.example.repository.BookCrudOperations;
import org.example.repository.SubscriberCrudOperations;

import java.time.LocalDate;
import java.util.List;

import static java.sql.Types.NULL;
import static org.example.model.Topic.*;

public class Main {

    public static void main(String[] args) {
        AuthorCrudOperations authorCrud = new AuthorCrudOperations();
        BookCrudOperations bookCrud = new BookCrudOperations();
        SubscriberCrudOperations subscriberCrud = new SubscriberCrudOperations();

        // Testing AuthorCrudOperations
        AuthorModel author1 = new AuthorModel(4, "Maria", 'F');
        AuthorModel savedAuthor1 = authorCrud.save(author1);

        AuthorModel author2 = new AuthorModel(5, "Bella", 'F');
        AuthorModel savedAuthor2 = authorCrud.save(author2);

        // Retrieve all authors
        List<AuthorModel> authors = authorCrud.findAll();
        System.out.println("All Authors:");
        authors.forEach(author -> System.out.println(author.getAuthorName()));

        // Testing BookCrudOperations
        BookModel book1 = new BookModel(1, "Book1", "Elementary", ROMANCE, 200, LocalDate.parse("2023-01-01"),1, true);
        BookModel savedBook1 = bookCrud.save(book1);

        BookModel book2;
        book2 = new BookModel(1, "Book2", "Luck", COMEDY, 200, LocalDate.parse("2023-01-01"),1, true);
        BookModel savedBook2 = bookCrud.save(book1);

        // Retrieve all books
        List<BookModel> books = bookCrud.findAll();
        System.out.println("All Books:");
        books.forEach(book -> System.out.println(book.getBookName()));

        // Testing SubscriberCrudOperations
        SubscriberModel subscriber1 = new SubscriberModel(5, "Toavina", "REF001",1, true);
        SubscriberModel savedSubscriber1 = subscriberCrud.save(subscriber1);

        SubscriberModel subscriber2 = new SubscriberModel(5, "Layla", "REF002",NULL, false);
        SubscriberModel savedSubscriber2 = subscriberCrud.save(subscriber2);

        // Retrieve all subscribers
        List<SubscriberModel> subscribers = subscriberCrud.findAll();
        System.out.println("All Subscribers:");
        subscribers.forEach(subscriber -> System.out.println(subscriber.getSubscriberName()));
    }
}
