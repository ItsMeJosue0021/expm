package com.salceda.ExpenseTracker.mappers;

import com.salceda.ExpenseTracker.DTOs.ExpenseCategoryDTO;
import com.salceda.ExpenseTracker.models.Expense;
import com.salceda.ExpenseTracker.models.ExpenseCategory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExpenseCategoryMapper {

    public ExpenseCategoryDTO toExpenseCategoryDTO(ExpenseCategory expenseCategory) {
        ExpenseCategoryDTO expenseCategoryDTO = new ExpenseCategoryDTO();
        expenseCategoryDTO.setId(expenseCategory.getId());
        expenseCategoryDTO.setName(expenseCategory.getName());
        expenseCategoryDTO.setDescription(expenseCategory.getDescription());
        return expenseCategoryDTO;
    }

    public ExpenseCategory toExpenseCategoryEntity(ExpenseCategoryDTO expenseCategoryDTO, List<Expense> expenses) {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setId(expenseCategoryDTO.getId());
        expenseCategory.setName(expenseCategoryDTO.getName());
        expenseCategory.setDescription(expenseCategoryDTO.getDescription());
        expenseCategory.setExpenses(expenses);
        return  expenseCategory;
    }
}
