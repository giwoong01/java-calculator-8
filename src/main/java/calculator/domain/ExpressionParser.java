package calculator.domain;

public class ExpressionParser {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_START = "//";
    private static final String CUSTOM_DELIMITER_END = "\\n";
    private static final String DELIMITER_SWAP_STRING = " ";

    public String[] split(String expression) {
        expression = replaceAllWithDefaultDelimiter(expression);
        expression = replaceAllWithCustomDelimiter(expression);

        return expression.split(DELIMITER_SWAP_STRING);
    }

    private String replaceAllWithDefaultDelimiter(String expression) {
        return expression.replaceAll(DEFAULT_DELIMITER, DELIMITER_SWAP_STRING);
    }

    private String replaceAllWithCustomDelimiter(String expression) {
        if (expression.startsWith(CUSTOM_DELIMITER_START)) {
            int delimiterEndIndex = expression.indexOf(CUSTOM_DELIMITER_END);
            String customDelimiter = expression.substring(CUSTOM_DELIMITER_START.length(), delimiterEndIndex);

            expression = expression
                    .substring(delimiterEndIndex + 2)
                    .replaceAll(customDelimiter, DELIMITER_SWAP_STRING);
        }

        return expression;
    }

}
