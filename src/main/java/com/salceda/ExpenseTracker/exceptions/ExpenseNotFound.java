package com.salceda.ExpenseTracker.exceptions;

public class ExpenseNotFound extends RuntimeException {
    public ExpenseNotFound(String message) {
        super(message);
    }

}
