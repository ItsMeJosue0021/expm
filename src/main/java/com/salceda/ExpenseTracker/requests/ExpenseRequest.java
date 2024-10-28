package com.salceda.ExpenseTracker.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseRequest {
    private Long id;
    private String description;
    private Double amount;
    private LocalDate date;
    private Long expenseCategory;
}
