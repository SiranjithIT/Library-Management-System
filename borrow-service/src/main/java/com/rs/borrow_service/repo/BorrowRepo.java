package com.rs.borrow_service.repo;

import com.rs.borrow_service.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, UUID> {
    public Optional<List<Borrow>> findByUserId(UUID userId);
    public Optional<List<Borrow>> findByBookId(UUID bookId);
}
