package com.rs.book_service.controller;

import com.rs.book_service.model.Book;
import com.rs.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getBooks(){
        try {
            List<Book> books= bookService.getBooks();
            return ResponseEntity.ok(books);
        }catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable  UUID id){
        Optional<Book> bookOpt = bookService.getBookById(id);
        if(bookOpt.isPresent()){
            Book book = bookOpt.get();
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book){
        String response = bookService.addBook(book);
        if(response.contains("Unable")){
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/quantity-update/{quantity}")
    public ResponseEntity<Book> updateBook(@PathVariable UUID id, @PathVariable Long quantity){
        try{
            Book book = bookService.updateQuantity(id, quantity);
            return ResponseEntity.ok(book);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }
}
