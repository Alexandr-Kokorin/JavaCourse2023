package edu.hw2.task1;

public final class Main {

    private Main() {}

    @SuppressWarnings({"MagicNumber", "RegexpSinglelineJava"})
    public static void main(String[] args) {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var multi = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(multi, 2);
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        System.out.println(res + " = " + res.evaluate());
    }
}
