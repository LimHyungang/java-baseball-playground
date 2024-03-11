import java.rmi.server.ExportException;
import java.util.*;

public class Choice {

    // 스트림 써보고 싶어서 까불어 봄...
    Set<Integer> used;
    List<Ball> balls;
    boolean valid;

    public boolean isValid() {
        return this.valid;
    }

    private Choice() {};
    Choice(String ballStr) {
        balls = new ArrayList<>();
        used = new HashSet<>();

        // valid 너무 짜치는 거 같은데.. 방법 없나?
        // 에러만 띄우고 끝이 아니라 예외처리를 하고 싶은데..
        // 이런 식으로 valid 쓰는 게 아니면 indent 1 안에서 처리를 못 하겠음

        try {
            checkValid(ballStr);
            valid = true;
        }catch(Exception e) {
            System.out.println(e.getMessage());
            valid = false;
        }

        for(int i = 0; i < 3; i++) {
            balls.add(new Ball(i, ballStr.charAt(i) - '0'));
        }
    }

    public void checkValid(String ballStr) throws Exception {

        // 1. 길이 체크
        checkValidLength(ballStr);

        // 2. 숫자 체크
        // -> Ball 에 있는 게 더 적절한 것 아닌지?
        for(char ch : ballStr.toCharArray()) {
            checkValidNumber(ch - '0');
        }

        // 3. 중복 체크
        checkDuplicated(ballStr);
    }

    public void checkValidLength(String ballStr) throws Exception {
        if(ballStr.length() != 3) {
            throw new Exception("3자리 숫자를 입력하세요.");
        }
    }

    public void checkValidNumber(int num) throws Exception {
        if(!(1 <= num && num <= 9)) {
            throw new Exception("1~9 사이의 숫자만 입력 가능합니다.");
        }
    }

    public void checkDuplicated(String ballStr) throws ExportException {
        for(int i = 0; i < ballStr.length(); i++) {
            int useNum = ballStr.charAt(i) - '0';
            used.add(useNum);
        }

        if(used.size() != 3) {
            throw new ExportException("중복된 숫자가 존재합니다.");
        }
    }

    public GameResult play(Choice userChoice) {
        GameResult result = new GameResult();

        for(Ball randomBall : balls) {  // random choice 기준으로 돈다
            BallStatus status = userChoice.calcBallStatus(randomBall);
            result.addBallStatus(status);
        }

        return result;
    }

    public BallStatus calcBallStatus(Ball randBall) {
//        for(Ball randBall : balls) {
//            BallStatus status = randBall.checkBallStatus(userBall);
//
//            // 이렇게 하면 여기서 status에 if를 먹일 수 밖에 없네..
//        }

        return balls.stream()
                .map(userBall -> userBall.checkBallStatus(randBall))
                .filter(BallStatus::isNotNothing)
                .findFirst()
                .orElse(BallStatus.NOTHING);
    }


}
