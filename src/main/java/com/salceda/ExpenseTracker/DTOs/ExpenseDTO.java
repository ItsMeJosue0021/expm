package com.salceda.ExpenseTracker.DTOs;

import com.salceda.ExpenseTracker.models.ExpenseCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {
    private Long id;
    private String description;
    private Double amount;
    private LocalDate date;
    private Long expenseCategoryId;
    private ExpenseCategoryDTO expenseCategory;
}

