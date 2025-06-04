public class GuessResult {
    public GuessResult(boolean solved, int strikes, int balls) {
        this.solved = solved;
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean solved;
    public int strikes;
    public int balls;
}
