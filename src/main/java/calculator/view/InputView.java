package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputExpression() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String numbersExpression = Console.readLine().trim();
        Console.close();
        return numbersExpression;
    }

}
