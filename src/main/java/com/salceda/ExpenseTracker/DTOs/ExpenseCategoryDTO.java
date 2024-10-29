package com.salceda.ExpenseTracker.DTOs;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseCategoryDTO {
    private Long id;

    @NotNull(message = "Name cannot be null.")
    @Size(max = 20, message = "Name must not exceed 20 characters.")
    private String name;
    private String description;
}
