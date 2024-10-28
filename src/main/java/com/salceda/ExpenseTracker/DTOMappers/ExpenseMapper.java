package com.salceda.ExpenseTracker.DTOMappers;

import com.salceda.ExpenseTracker.DTOs.ExpenseCategoryDTO;
import com.salceda.ExpenseTracker.DTOs.ExpenseDTO;
import com.salceda.ExpenseTracker.models.Expense;
import com.salceda.ExpenseTracker.models.ExpenseCategory;
import com.salceda.ExpenseTracker.requests.ExpenseRequest;
import com.salceda.ExpenseTracker.services.ExpenseCategoryService;
import com.salceda.ExpenseTracker.services.ExpenseService;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {
    public ExpenseDTO toExpenseDTO(Expense expense, ExpenseCategoryDTO expenseCategoryDTO) {
        ExpenseDTO expenseDTO = new ExpenseDTO();
        expenseDTO.setId(expense.getId());
        expenseDTO.setDescription(expense.getDescription());
        expenseDTO.setAmount(expense.getAmount());
        expenseDTO.setDate(expense.getDate());
        expenseDTO.setExpenseCategoryId(expense.getExpenseCategory().getId());
        expenseDTO.setExpenseCategory(expenseCategoryDTO);
        return expenseDTO;
    }

    public Expense toExpenseEntity(ExpenseDTO expenseDTO, ExpenseCategory expenseCategory) {
        Expense expense = new Expense();
        expense.setId(expenseDTO.getId());
        expense.setDescription(expenseDTO.getDescription());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setExpenseCategory(expenseCategory);
        return expense;
    }

}
