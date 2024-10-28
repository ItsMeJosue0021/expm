package com.salceda.ExpenseTracker.repositories;

import com.salceda.ExpenseTracker.models.ExpenseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseCategoryRepository extends JpaRepository<ExpenseCategory, Long> {

}
