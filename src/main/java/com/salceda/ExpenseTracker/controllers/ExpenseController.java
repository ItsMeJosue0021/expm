package com.salceda.ExpenseTracker.controllers;

import com.salceda.ExpenseTracker.DTOs.ExpenseDTO;
import com.salceda.ExpenseTracker.exceptions.ExpenseNotFound;
import com.salceda.ExpenseTracker.services.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ExpenseController {


    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("expenses")
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {
        return new ResponseEntity<>(expenseService.getAllExpenses(), HttpStatus.OK);
    }

    @GetMapping("expenses/{id}")
    public ResponseEntity<ExpenseDTO> getExpenseById(@PathVariable Long id) {
        return new ResponseEntity<>(expenseService.getExpenseById(id), HttpStatus.OK);
    }

    @PostMapping("expenses")
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        return new ResponseEntity<>(expenseService.createExpense(expenseDTO), HttpStatus.CREATED);
    }

    @PutMapping("expenses/{id}")
    public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable Long id, @RequestBody ExpenseDTO expenseDTO) {
        return new ResponseEntity<>(expenseService.updateExpense(id, expenseDTO), HttpStatus.OK);
    }

    @DeleteMapping("expenses/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
