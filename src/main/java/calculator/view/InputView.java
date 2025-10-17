package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_EXPRESSION_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public String inputExpression() {
        System.out.println(INPUT_EXPRESSION_MESSAGE);
        String numbersExpression = Console.readLine().trim();
        Console.close();
        return numbersExpression;
    }

}
