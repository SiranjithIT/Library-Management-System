package com.rs.book_service.repo;

import com.rs.book_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepo extends JpaRepository<Book, UUID> {
    public Optional<List<Book>> findByAuthor(String author);
}
