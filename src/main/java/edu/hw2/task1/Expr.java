package edu.hw2.task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double number) implements Expr {
        @Override
        public double evaluate() {
            return number;
        }
    }

    record Negate(Expr expr) implements Expr {
        @Override
        public double evaluate() {
            return -expr.evaluate();
        }
    }

    record Exponent(Expr expr, double number) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(expr.evaluate(), number);
        }
    }

    record Addition(Expr expr1, Expr expr2) implements Expr {
        @Override
        public double evaluate() {
            return expr1.evaluate() + expr2.evaluate();
        }
    }

    record Multiplication(Expr expr1, Expr expr2) implements Expr {
        @Override
        public double evaluate() {
            return expr1.evaluate() * expr2.evaluate();
        }
    }
}
