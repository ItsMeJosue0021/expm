package com.salceda.ExpenseTracker.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.DoubleSummaryStatistics;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryExpenseDTO {
    private String category;
    private Double amount;
    public CategoryExpenseDTO(String key, DoubleSummaryStatistics value) {
    }
}
