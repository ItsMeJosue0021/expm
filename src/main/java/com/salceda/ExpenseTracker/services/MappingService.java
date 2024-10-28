package com.salceda.ExpenseTracker.services;

import com.salceda.ExpenseTracker.DTOMappers.ExpenseCategoryMapper;
import com.salceda.ExpenseTracker.DTOMappers.ExpenseMapper;
import com.salceda.ExpenseTracker.DTOs.ExpenseCategoryDTO;
import com.salceda.ExpenseTracker.DTOs.ExpenseDTO;
import com.salceda.ExpenseTracker.models.Expense;
import com.salceda.ExpenseTracker.models.ExpenseCategory;
import com.salceda.ExpenseTracker.requests.ExpenseRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class MappingService {
     private final ExpenseMapper expenseMapper;
     private final ExpenseCategoryMapper expenseCategoryMapper;
     private final ExpenseCategoryService expenseCategoryService;

    public MappingService(ExpenseMapper expenseMapper, ExpenseCategoryMapper expenseCategoryMapper, ExpenseCategoryService expenseCategoryService) {
        this.expenseMapper = expenseMapper;
        this.expenseCategoryMapper = expenseCategoryMapper;
        this.expenseCategoryService = expenseCategoryService;
    }

//    public ExpenseDTO toExpenseDTO(Expense expense) {
//        ExpenseDTO expenseDTO = expenseMapper.toDTO(expense);
//        expenseDTO.setExpenseCategory(expenseCategoryMapper.toDTO(expense.getExpenseCategory()));
//        return expenseDTO;
//    }

//    public Expense toExpense(ExpenseDTO expenseDTO) {
//        Expense expense = expenseMapper.toExpense(expenseDTO);
//        expense.setExpenseCategory(expenseCategoryMapper.toExpenseCategory(expenseDTO.getExpenseCategoryId()));
//        return expense;
//    }

//    public ExpenseCategoryDTO toExpenseCategoryDTO(ExpenseCategory expenseCategory) {
//        ExpenseCategoryDTO expenseCategoryDTO = expenseCategoryMapper.toDTO(expenseCategory);
//        expenseCategoryDTO.setExpenseDTOS((expenseCategory.getExpenses().stream()
//                .map(expenseMapper::toDTO)
//                .collect(Collectors.toList())));
//        return expenseCategoryDTO;
//    }
//
//    public ExpenseCategory toExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO) {
//        ExpenseCategory expenseCategory = expenseCategoryMapper.toExpenseCategory(expenseCategoryDTO);
//        expenseCategory.setExpenses(expenseCategoryDTO.getExpenseDTOS().stream()
//                .map(expenseMapper::toExpense)
//                .collect(Collectors.toList()));
//        return expenseCategory;
//    }

}
