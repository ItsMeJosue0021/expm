package com.salceda.ExpenseTracker.controllers;

import com.salceda.ExpenseTracker.DTOs.ExpenseCategoryDTO;
import com.salceda.ExpenseTracker.services.ExpenseCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
