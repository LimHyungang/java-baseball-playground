import java.util.Scanner;

public class Main {
    static Scanner scan;
    static String randomStr;
    static boolean ANS;

    public static boolean isAnswer(String str) {
        return randomStr.equals(str);
    }

    public static int getStrikeScore(char ch1, char ch2) {
        if(ch1 == ch2) {
            return 1;
        }
        return 0;
    }

    public static int calcStrike(String userStr) {
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            char ch1 = randomStr.charAt(i);
            char ch2 = userStr.charAt(i);
            cnt += getStrikeScore(ch1, ch2);
        }
        return cnt;
    }

    public static int getBallScore(int idxOfRandStr, int idxOfUserStr, char randCh, char userCh) {
        if(idxOfRandStr == idxOfUserStr) {
            return 0;
        }
        if(randCh == userCh) {
            return 1;
        }
        return 0;
    }

    public static int getBallCnt(int idxOfUserStr, String userStr) {
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            char randCh = randomStr.charAt(i);
            char userCh = userStr.charAt(idxOfUserStr);
            cnt += getBallScore(i, idxOfUserStr, randCh, userCh);
        }
        return cnt;
    }

    public static int calcBall(String userStr) {
        int cnt = 0;
        for(int i = 0; i < 3; i++) {
            cnt += getBallCnt(i, userStr);
        }
        return cnt;
    }

    public static void printResult(int strike, int ball) {
        if(strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if(strike == 0 && ball != 0) {
            System.out.println(ball + "볼");
        }
        if(strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if(strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

        // 정답
        if(strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            ANS = !ANS;
        }
    }

    public static void checkAnswer(String userStr) {
        int strike = calcStrike(userStr);
        int ball = calcBall(userStr);
        printResult(strike, ball);
    }

    public static void startGame() {
        while(!ANS) {
            System.out.print("숫자를 입력해 주세요 : ");
            String userStr = scan.nextLine();
            checkAnswer(userStr);
        }
    }

    public static void init() {
        scan = new Scanner(System.in);
        int randNumber = Computer.choiceNumber();
        randomStr = String.valueOf(randNumber);
    }

    public static void process() {
        int again = 1;
        while(again == 1) {
            init();
            System.out.println("정답 : " + randomStr);
            startGame();

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            again = scan.nextInt();
            ANS = !ANS;
        }
    }

    public static void main(String[] args) {
        process();
    }
}
