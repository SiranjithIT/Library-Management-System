package com.rs.book_service.service;

import com.rs.book_service.model.Book;
import com.rs.book_service.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    public Optional<Book> getBookById(UUID id){
        return bookRepo.findById(id);
    }

    public Optional<List<Book>> getBookByAuthor(String author){
        return bookRepo.findByAuthor(author);
    }

    public String addBook(Book book){
        try{
            bookRepo.save(book);
            return "Book " + book.getTitle() + " added successfully";
        } catch (Exception e) {
            return "Unable to add book due to" + e.getMessage();
        }
    }

    public String deleteBook(UUID id){
        try{
            bookRepo.deleteById(id);
            return "Book removed successfully";
        }catch (Exception e){
            return "Unable to delete the book or book not present " + e.getMessage();
        }
    }

    public Book updateQuantity(UUID id, Long quantity){
        Optional<Book> bookOpt = getBookById(id);
        if(bookOpt.isPresent()){
            Book book = bookOpt.get();
            book.setQuantity(quantity);
            bookRepo.save(book);
            return book;
        }
        throw new RuntimeException();
    }

}
