package calculator.controller;

import calculator.domain.Calculator;
import calculator.domain.ExpressionParser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String expression = inputView.inputExpression();

        Calculator calculator = new Calculator(new ExpressionParser());
        int sum = calculator.add(expression);

        outputView.outputResult(sum);
    }

}
