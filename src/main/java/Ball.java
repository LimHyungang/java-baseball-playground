public class Ball {
    int pos, num;
    public Ball(int pos, int num) {
        this.pos = pos;
        this.num = num;
    }

    public boolean matchBallNum(int num) {
        return this.num == num;
    }
    public boolean matchBallPos(int pos) {
        return this.pos == pos;
    }

    public boolean isStrike(Ball ball) {
//        if(this.pos == ball.pos && this.num == ball.num) {
//            return true;
//        }
//        return false;


        // this의 상태는 바로 가져오면 되니까 매개변수를 this.pos로 잡으면 해결되는 것?
        if(ball == null) {
            return false;
        }
        if(!ball.matchBallPos(this.pos)) {
            return false;
        }
        if(!ball.matchBallNum(this.num)) {
            return false;
        }
        return true;
    }

    public boolean isBall(Ball ball) {
        if(ball == null) {
            return false;
        }
        if(ball.matchBallPos(this.pos)) {
            return false;  // 포지션 같으면 ball 될 수 없음
        }
        if(!ball.matchBallNum(this.num)) {
            return false;
        }
        return true;
    }

    public BallStatus checkBallStatus(Ball ball) {
        if(this.isStrike(ball)) {
            return BallStatus.STRIKE;
        }
        if(this.isBall(ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
}
