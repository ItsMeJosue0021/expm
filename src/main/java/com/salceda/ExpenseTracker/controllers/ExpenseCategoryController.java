package com.salceda.ExpenseTracker.controllers;

import com.salceda.ExpenseTracker.DTOs.ExpenseCategoryDTO;
import com.salceda.ExpenseTracker.services.ExpenseCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ExpenseCategoryController {
    private final ExpenseCategoryService expenseCategoryService;

    public ExpenseCategoryController(ExpenseCategoryService expenseCategoryService) {
        this.expenseCategoryService = expenseCategoryService;
    }

    @GetMapping("categories")
    public ResponseEntity<List<ExpenseCategoryDTO>> getAllExpenseCategory() {
        List<ExpenseCategoryDTO> expenseCategoryDTOS = expenseCategoryService.getAllExpenseCategory();
        return new ResponseEntity<>(expenseCategoryDTOS, HttpStatus.OK);
    }

    @GetMapping("categories/{id}")
    public ResponseEntity<ExpenseCategoryDTO> getExpenseCategoryById(@PathVariable Long id) {
        return new ResponseEntity<>(expenseCategoryService.getExpenseCategoryById(id), HttpStatus.OK);
    }

    @PostMapping("categories")
    public ResponseEntity<ExpenseCategoryDTO> createExpenseCategory(@RequestBody ExpenseCategoryDTO expenseCategoryDTO) {
        ExpenseCategoryDTO createdExpenseCategory = expenseCategoryService.createExpenseCategory(expenseCategoryDTO);
        return new ResponseEntity<>(createdExpenseCategory, HttpStatus.CREATED);
    }

    @PutMapping("categories/{id}")
    public ResponseEntity<ExpenseCategoryDTO> updateExpenseCategory(@PathVariable Long id, @RequestBody ExpenseCategoryDTO expenseCategoryDTO) {
        return new ResponseEntity<>(expenseCategoryService.updateExpenseCategory(id, expenseCategoryDTO), HttpStatus.OK);
    }

    @DeleteMapping("categories/{id}")
    public ResponseEntity<Void> deleteExpenseCategory(@PathVariable Long id) {
        expenseCategoryService.deleteExpenseCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
