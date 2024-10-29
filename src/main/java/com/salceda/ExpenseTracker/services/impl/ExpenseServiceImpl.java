package com.salceda.ExpenseTracker.services.impl;

import com.salceda.ExpenseTracker.mappers.ExpenseCategoryMapper;
import com.salceda.ExpenseTracker.mappers.ExpenseMapper;
import com.salceda.ExpenseTracker.DTOs.ExpenseDTO;
import com.salceda.ExpenseTracker.exceptions.ExpenseCategoryNotFound;
import com.salceda.ExpenseTracker.exceptions.ExpenseNotFound;
import com.salceda.ExpenseTracker.models.Expense;
import com.salceda.ExpenseTracker.models.ExpenseCategory;
import com.salceda.ExpenseTracker.repositories.ExpenseCategoryRepository;
import com.salceda.ExpenseTracker.repositories.ExpenseRepository;
import com.salceda.ExpenseTracker.services.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final ExpenseMapper expenseMapper;
    private final ExpenseCategoryMapper expenseCategoryMapper;
    private final ExpenseCategoryRepository expenseCategoryRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository, ExpenseMapper expenseMapper, ExpenseCategoryMapper expenseCategoryMapper, ExpenseCategoryRepository expenseCategoryRepository) {
        this.expenseRepository = expenseRepository;
        this.expenseMapper = expenseMapper;
        this.expenseCategoryMapper = expenseCategoryMapper;
        this.expenseCategoryRepository = expenseCategoryRepository;
    }

    @Override
    public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(expenseDTO.getExpenseCategoryId())
                .orElseThrow(() -> new ExpenseCategoryNotFound("Not found!"));
        Expense expense = expenseMapper.toExpenseEntity(expenseDTO, expenseCategory);
        expenseRepository.save(expense);
        return expenseMapper.toExpenseDTO(expense, expenseCategoryMapper.toExpenseCategoryDTO(expenseCategory));
    }

    @Override
    public ExpenseDTO getExpenseById(Long id)  {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFound("Expense not found!"));
        return expenseMapper.toExpenseDTO(expense, expenseCategoryMapper.toExpenseCategoryDTO(expense.getExpenseCategory()));
    }

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .sorted(Comparator.comparingLong(Expense::getId))
                .map(expense -> expenseMapper.toExpenseDTO(expense,expenseCategoryMapper.toExpenseCategoryDTO(expense.getExpenseCategory())))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDTO updateExpense(Long id, ExpenseDTO expenseDTO) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFound("Expense not found!"));
        expense.setAmount(expenseDTO.getAmount());
        expense.setDescription(expenseDTO.getDescription());
        expense.setDate(expenseDTO.getDate());
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(expenseDTO.getExpenseCategoryId())
                .orElseThrow(() -> new ExpenseCategoryNotFound("Expense category not found!"));
        expense.setExpenseCategory(expenseCategory);
        expenseRepository.save(expense);
        return expenseMapper.toExpenseDTO(expense, expenseCategoryMapper.toExpenseCategoryDTO(expenseCategory));
    }

    @Override
    public void deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id).orElseThrow(() -> new ExpenseNotFound("Expense not found"));
        expenseRepository.delete(expense);
    }

}
