import java.util.Scanner;

public class InputOutput {

    static Scanner scan;

    InputOutput() {
        if(scan == null) {
            scan = new Scanner(System.in);
        }
    }

    public Choice inputUserChoice() {
        Choice userChoice = null;

        try {
            // 여기서 입력 받어잉
        }catch(Exception e) {
            userChoice = inputUserChoice();
        }

//        while(userChoice == null || !userChoice.isValid()) {
//            System.out.print("숫자를 입력해 주세요 : ");
//            String str = scan.nextLine();
//            userChoice = new Choice(str);
//        }

        return userChoice;
    }

    public int inputNextGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scan.nextInt();
    }

    public void printGameResult(GameResult result) {
        // result 객체에 메시지를 보내라!
        // 어떻게...? getter ??
//        if(result.getStrike() != 0 && result.getBall() == 0) {
//            System.out.println(result.getStrike() + "스트라이크");
//        }
//        if(result.getStrike() == 0 && result.getBall() != 0) {
//            System.out.println(result.getBall() + "볼");
//        }
//        if(result.getStrike() != 0 && result.getBall() != 0) {
//            System.out.println(result.getBall() + "볼 " + result.getStrike() + "스트라이크");
//        }
//        if(result.getStrike() == 0 && result.getBall() == 0) {
//            System.out.println("낫싱");
//        }

        // 상태 하나에 집중하는 것이 아닌 기능에 포커싱된 메세지를 보내자
        // message : 게임 결과가 뭐야?
        System.out.println(result.getScoreString());
    }

    public void printFinish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
