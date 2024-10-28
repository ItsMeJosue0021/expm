package com.salceda.ExpenseTracker.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseCategoryDTO {
    private Long id;
    private String name;
    private String description;
}