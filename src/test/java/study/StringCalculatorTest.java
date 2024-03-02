package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class StringCalculatorTest {

    private Scanner scanner;
    private String[] values;

    @BeforeEach
    void beforeEach() {
        String value = scanner.nextLine();
        values = value.split(" ");
    }


    @Test
    void calculateTest() {
        // 테스트 호출 시에 입력값이 정해지는데 테스트를 어케하지?


    }


//    int calculate(String[] arr) {
//        int result = Integer.parseInt(arr[0]);
//        char operator = ' ';
//
//        for(int i = 1; i <= arr.length; i++) {
//            char ch = arr[i].charAt(0);
//
//            // 굳이 else를 안 쓰려고 이렇게 해야하나?
//            // else 쓴 게 훨씬 직관적이지 않은지?
//            if(isNumber(ch)) {
//                result = doCalc(result, ch - '0', operator);
//                continue;
//            }
//            operator = ch;
//
////            if(isNumber(ch)) {
////                result = calculate(result, ch - '0', operator);
////            }else {
////                operator = ch;
////            }
//        }
//    }

    boolean isNumber(char ch) {
        int num = ch - '0';
        return 0 <= num && num <= 9;
    }

    int doCalc(int num1, int num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                return 0;
        }
    }
}
