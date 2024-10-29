package com.salceda.ExpenseTracker.DTOs;

import com.salceda.ExpenseTracker.models.ExpenseCategory;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "Please provide a description.")
    @Size(min = 10, max = 5000, message = "Description must not be below 10 characters and must not exceed 5000 characters.")
    private String description;

    @NotNull(message = "Amount cannot be null.")
    @Positive(message = "Amount must be positive")
    private Double amount;

    @NotNull(message = "Please provide a the date.")
    private LocalDate date;

    @NotNull(message = "The expense category cannot be null.")
    private Long expenseCategoryId;
    private ExpenseCategoryDTO expenseCategory;
}

