package edu.hw2;

import edu.hw2.task1.Expr;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("TestExpr")
public class Task1Test {

    @Test
    @DisplayName("Test - \"Constant 5.0\", expected - \"5.0\"")
    void ExprTest1() {
        var expr = new Expr.Constant(5.0);

        double result = expr.evaluate();

        assertThat(result).isEqualTo(5.0);
    }

    @Test
    @DisplayName("Test - \"Negate 5.0\", expected - \"-5.0\"")
    void ExprTest2() {
        var expr = new Expr.Negate(new Expr.Constant(5.0));

        double result = expr.evaluate();

        assertThat(result).isEqualTo(-5.0);
    }

    @Test
    @DisplayName("Test - \"Addition 5.0, 2.0\", expected - \"7.0\"")
    void ExprTest3() {
        var expr1 = new Expr.Constant(5.0);
        var expr2 = new Expr.Constant(2.0);
        var exprResult = new Expr.Addition(expr1, expr2);

        double result = exprResult.evaluate();

        assertThat(result).isEqualTo(7.0);
    }

    @Test
    @DisplayName("Test - \"Multiplication 5.0, 2.0\", expected - \"10.0\"")
    void ExprTest4() {
        var expr1 = new Expr.Constant(5.0);
        var expr2 = new Expr.Constant(2.0);
        var exprResult = new Expr.Multiplication(expr1, expr2);

        double result = exprResult.evaluate();

        assertThat(result).isEqualTo(10.0);
    }

    @Test
    @DisplayName("Test - \"Exponent 5.0, 3\", expected - \"125.0\"")
    void ExprTest5() {
        var expr = new Expr.Constant(5.0);
        var exprResult = new Expr.Exponent(expr, 3);

        double result = exprResult.evaluate();

        assertThat(result).isEqualTo(125.0);
    }

    @Test
    @DisplayName("Test - \"All\", expected - \"37.0\"")
    void ExprTest6() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var multi = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(multi, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        double result = res.evaluate();

        assertThat(result).isEqualTo(37.0);
    }
}
