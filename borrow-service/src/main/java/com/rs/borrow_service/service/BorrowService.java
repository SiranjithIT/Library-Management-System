package com.rs.borrow_service.service;

import com.rs.borrow_service.model.Borrow;
import com.rs.borrow_service.repo.BorrowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class BorrowService {
    @Autowired
    private BorrowRepo borrowRepo;

    public List<Borrow> getBorrows(){
        return borrowRepo.findAll();
    }

    public Optional<Borrow> getBorrowById(UUID id){
        return borrowRepo.findById(id);
    }

    public String addBorrow(Borrow borrow){
        try{
            borrowRepo.save(borrow);
            return "Successfully added the book with id "+borrow.getBookId()+" to user with id "+borrow.getUserId();
        }catch (Exception e){
            return "Unable to add the record";
        }
    }


}
