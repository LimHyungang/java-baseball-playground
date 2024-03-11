import org.junit.jupiter.api.BeforeEach;

import java.util.Scanner;

public class InputOutputTest {

    Scanner scan;
    InputOutput inputOutput;

    @BeforeEach
    void init() {
        scan = new Scanner(System.in);
        inputOutput = new InputOutput();
    }


}
