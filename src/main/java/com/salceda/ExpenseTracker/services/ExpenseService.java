package com.salceda.ExpenseTracker.services;

import com.salceda.ExpenseTracker.DTOs.ExpenseDTO;
import com.salceda.ExpenseTracker.exceptions.ExpenseNotFound;

import java.util.List;

public interface ExpenseService {
    ExpenseDTO createExpense(ExpenseDTO expense);
    ExpenseDTO getExpenseById(Long id);
    List<ExpenseDTO> getAllExpenses();
    ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO);
    void deleteExpense(Long id);


}
