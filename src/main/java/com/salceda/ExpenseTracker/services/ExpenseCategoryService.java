package com.salceda.ExpenseTracker.services;

import com.salceda.ExpenseTracker.DTOs.ExpenseCategoryDTO;
import com.salceda.ExpenseTracker.models.ExpenseCategory;

import java.util.List;

public interface ExpenseCategoryService {
     ExpenseCategoryDTO createExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO);
     ExpenseCategoryDTO getExpenseCategoryById(Long id);
     List<ExpenseCategoryDTO> getAllExpenseCategory();
     ExpenseCategoryDTO updateExpenseCategory(Long id, ExpenseCategoryDTO expenseCategoryDTO);
     void deleteExpenseCategory(Long id);

}
