package com.salceda.ExpenseTracker.services.impl;

import com.salceda.ExpenseTracker.DTOMappers.ExpenseCategoryMapper;
import com.salceda.ExpenseTracker.DTOs.ExpenseCategoryDTO;
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
    public List<ExpenseCategoryDTO> getAllExpenseCategory() {
        List<ExpenseCategory> expenseCategories = expenseCategoryRepository.findAll();
        return expenseCategories.stream()
                .map(expenseCategoryMapper::toExpenseCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseCategoryDTO findById(Long id) throws Exception {
        ExpenseCategory expenseCategory = expenseCategoryRepository.findById(id)
                .orElseThrow(() -> new Exception("Expense category not found."));
        return expenseCategoryMapper.toExpenseCategoryDTO(expenseCategory);
    }
}
