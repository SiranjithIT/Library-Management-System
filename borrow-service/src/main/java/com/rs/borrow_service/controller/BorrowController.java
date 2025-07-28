package com.rs.borrow_service.controller;

import com.rs.borrow_service.model.Borrow;
import com.rs.borrow_service.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrows")
public class BorrowController {
    @Autowired
    private BorrowService borrowService;

    @GetMapping
    public ResponseEntity<List<Borrow>> getBorrows(){
        try{
            List<Borrow> borrows = borrowService.getBorrows();
            return ResponseEntity.ok(borrows);

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> addBorrow(@RequestBody Borrow borrow){
        String response = borrowService.addBorrow(borrow);
        if(response.contains("Unable")){
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }
}
