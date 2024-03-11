import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Game {

    // (역할)
    // random/user 숫자 결정
    // strike/ball 검사 (게임 진행)
    // 다음 게임 진행 여부

    // (상태)
    // random/user 숫자
    // 다음 게임 진행 여부
    //

    // 전역이 너무 많은가..?
    Random random;
    Set<Integer> used;
    InputOutput io;
    Choice randomChoice, userChoice;
    GameResult result;

    boolean nextGame;

    Game() {
        random = new Random();
        used = new HashSet<>();
        io = new InputOutput();
    }

    public boolean hasNextGame() {
        return this.nextGame;
    }

    public void startGame() {
        // 컴퓨터 랜덤 숫자 결정
        makeRandomChoice();

        for(int i = 0; i < 3; i++) {
            System.out.println(randomChoice.balls.get(i).num);
        }


        do {
            // 유저 숫자 선택
            this.userChoice = io.inputUserChoice();

            // strike, ball 게산해서 GameResult 생성
            // 전역변수를 파라미터로 주는 건 좀 이상한가?
            this.result = randomChoice.play(this.userChoice);

            // 결과 메시지 출력
            io.printGameResult(result);

        }while(result.isNotCorrect());

        // 종료 메시지 출력
        io.printFinish();

        // 다음 게임 여부 결정
        this.nextGame = io.inputNextGame() == 1;
    }

    // 컴퓨터 랜덤 숫자 결정
    public void makeRandomChoice() {
        used.add(0);

        String ballStr = String.valueOf(
                getRandInt() * 100
                + getRandInt() * 10
                + getRandInt()
        );

        randomChoice = new Choice(ballStr);
    }
    public int getRandInt() {
        int randInt = 0;
        do {
            randInt = random.nextInt(9);
        }while(used.contains(randInt));

        used.add(randInt);
        return randInt;
    }

}
