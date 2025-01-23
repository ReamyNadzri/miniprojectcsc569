/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author rahim
 */
package com.miniproject.model;

public class G17Parser {
    private String input; // Input string
    private int index;    // Current position in the input

    public G17Parser(String input) {
        this.input = input.replaceAll("\\s", ""); // Remove whitespace
        this.index = 0;
    }

    // Main parsing function
    public String parse() {
        try {
            Expr(); // Start with the top-level non-terminal
            if (index != input.length()) {
                throw new RuntimeException("Unexpected input at index " + index);
            }
            return "Input accepted! The string is valid.";
        } catch (RuntimeException e) {
            return "Input rejected! Error: " + e.getMessage();
        }
    }

    // Expr → Term Elist
    private void Expr() {
        Term();
        Elist();
    }

    // Elist → + Term Elist | - Term Elist | ε
    private void Elist() {
        if (match('+')) {
            Term();
            Elist();
        } else if (match('-')) {
            Term();
            Elist();
        }
        // Else, ε (do nothing)
    }

    // Term → Factor Tlist
    private void Term() {
        Factor();
        Tlist();
    }

    // Tlist → * Factor Tlist | / Factor Tlist | ε
    private void Tlist() {
        if (match('*')) {
            Factor();
            Tlist();
        } else if (match('/')) {
            Factor();
            Tlist();
        }
        // Else, ε (do nothing)
    }

    // Factor → ( Expr ) | var
    private void Factor() {
        if (match('(')) {
            Expr();
            if (!match(')')) {
                throw new RuntimeException("Expected ')'");
            }
        } else if (isVar()) {
            consumeVar();
        } else {
            throw new RuntimeException("Invalid character: " + currentChar());
        }
    }

    // Helper: Check if the current character matches the expected one
    private boolean match(char expected) {
        if (index < input.length() && input.charAt(index) == expected) {
            index++;
            return true;
        }
        return false;
    }

    // Helper: Check if the current character is a variable (var)
    private boolean isVar() {
        return index < input.length() && Character.isLetterOrDigit(input.charAt(index));
    }

    // Helper: Consume a variable (var)
    private void consumeVar() {
        while (index < input.length() && Character.isLetterOrDigit(input.charAt(index))) {
            index++;
        }
    }

    // Helper: Get the current character
    private char currentChar() {
        return index < input.length() ? input.charAt(index) : '\0';
    }
}
