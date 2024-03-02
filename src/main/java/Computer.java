import java.util.Random;

public class Computer {
    private static final Random random = new Random();
    private static boolean[] used;

    public static int getRandInt() {
        int randInt = 0;
        do {
            randInt = random.nextInt(9);
        }while(used[randInt]);

        used[randInt] = true;
        return randInt;
    }

    public static int choiceNumber() {
        used = new boolean[10];
        used[0] = true;  // 1~9 사이의 숫자로만 구성

        return getRandInt() * 100
                + getRandInt() * 10
                + getRandInt();
    }
}
