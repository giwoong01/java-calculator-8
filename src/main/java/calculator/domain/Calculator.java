package calculator.domain;

public class Calculator {

    private final ExpressionParser expressionParser;

    public Calculator(ExpressionParser expressionParser) {
        this.expressionParser = expressionParser;
    }

    public int add(String expression) {
        if (expression == null || expression.isBlank()) {
            return 0;
        }

        String[] parts = expressionParser.split(expression);
        Numbers numbers = new Numbers(parts);
        return numbers.sum();
    }

}
