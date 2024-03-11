public class GameResult {

    private int strike, ball;
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String NOTHING = "낫싱";

    public String getScoreString() {
        String scoreStr = "";

        if(this.ball != 0) {
            scoreStr += this.ball + BALL + " ";
        }
        if(this.strike != 0) {
            scoreStr += this.strike + STRIKE;
        }
        if(this.ball == 0 && this.strike == 0) {
            scoreStr += NOTHING;
        }

        return scoreStr;
    }

    public boolean isNotCorrect() {
        return strike != 3;
    }

    public void addBallStatus(BallStatus status) {
        if(status.isStrike()) {
            this.strike += 1;
        }
        if(status.isBall()) {
            this.ball += 1;
        }
    }
}
