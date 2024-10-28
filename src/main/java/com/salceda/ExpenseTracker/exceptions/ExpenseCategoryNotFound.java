package com.salceda.ExpenseTracker.exceptions;

public class ExpenseCategoryNotFound extends RuntimeException {
    public ExpenseCategoryNotFound(String message) {
        super(message);
    }
}
