package com.salceda.ExpenseTracker.services.impl;

import com.salceda.ExpenseTracker.mappers.ExpenseCategoryMapper;
import com.salceda.ExpenseTracker.DTOs.ExpenseCategoryDTO;
import com.salceda.ExpenseTracker.exceptions.ExpenseCategoryNotFound;
import com.salceda.ExpenseTracker.models.ExpenseCategory;
import com.salceda.ExpenseTracker.repositories.ExpenseCategoryRepository;
import com.salceda.ExpenseTracker.services.ExpenseCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryService {

    private final ExpenseCategoryRepository expenseCategoryRepository;
    private final ExpenseCategoryMapper expenseCategoryMapper;

    public ExpenseCategoryServiceImpl(ExpenseCategoryRepository expenseCategoryRepository, ExpenseCategoryMapper expenseCategoryMapper) {
        this.expenseCategoryRepository = expenseCategoryRepository;
        this.expenseCategoryMapper = expenseCategoryMapper;
    }

    @Override
    public ExpenseCategoryDTO createExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO) {
        ExpenseCategory expenseCategory = new ExpenseCategory();
        expenseCategory.setName(expenseCategoryDTO.getName());
        expenseCategory.setDescription(expenseCategoryDTO.getDescription());
        expenseCategoryRepository.save(expenseCategory);
        return expenseCategoryMapper.toExpenseCategoryDTO(expenseCategory);
    }

    @Override
    public ExpenseCategoryDTO getExpenseCategoryById(Long id) {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(id)
                .orElseThrow(() -> new ExpenseCategoryNotFound("Expense category not found!"));
        return expenseCategoryMapper.toExpenseCategoryDTO(expenseCategory);
    }

    @Override
    public List<ExpenseCategoryDTO> getAllExpenseCategory() {
        List<ExpenseCategory> expenseCategories = expenseCategoryRepository.findAll();
        return expenseCategories.stream()
                .map(expenseCategoryMapper::toExpenseCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseCategoryDTO updateExpenseCategory(Long id, ExpenseCategoryDTO expenseCategoryDTO) {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense category not found!"));
        expenseCategory.setName(expenseCategoryDTO.getName());
        expenseCategory.setDescription(expenseCategoryDTO.getDescription());
        expenseCategoryRepository.save(expenseCategory);
        return expenseCategoryMapper.toExpenseCategoryDTO(expenseCategory);
    }

    @Override
    public void deleteExpenseCategory(Long id) {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(id)
                .orElseThrow(() -> new ExpenseCategoryNotFound("Expense category not found!"));
        expenseCategoryRepository.delete(expenseCategory);
    }

}
