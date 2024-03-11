public class Process {

    InputOutput io;
    Game game;

    Process() {
        io = new InputOutput();
    }

    public void startProcess() {
        do {
            game = new Game();
            game.startGame();
        }while(game.hasNextGame());
    }
}
