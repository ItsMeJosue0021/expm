package com.salceda.ExpenseTracker.services;

import com.salceda.ExpenseTracker.DTOs.ExpenseCategoryDTO;
import com.salceda.ExpenseTracker.models.ExpenseCategory;

import java.util.List;

public interface ExpenseCategoryService {
     List<ExpenseCategoryDTO> getAllExpenseCategory();
     ExpenseCategoryDTO findById(Long id) throws Exception;
}
