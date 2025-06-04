import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void createGame() {

        assertNotNull(game);
    }

    private void assertIllegalArgument(String guessNumber) {
        try {
            game.guess(guessNumber);
            fail();
        } catch (IllegalArgumentException e) {

        }
    }

    @Test
    public void throwIllegalArgumentExceptionInvalidInput() {
        assertIllegalArgument(null);
        assertIllegalArgument("12");
        assertIllegalArgument("1234");
        assertIllegalArgument("12s");
        assertIllegalArgument("121");
    }


    private void assertMachtedNumber(GuessResult result, boolean solved, int strikes, int balls) {
        assertThat(result).isNotNull();
        assertThat(result.isSolved()).isEqualTo(solved);
        assertThat(result.getStrikes()).isEqualTo(strikes);
        assertThat(result.getBalls()).isEqualTo(balls);
    }

    private void generateQuestion(String questionNumber){
        game.question=questionNumber;
    }
    @Test
    void returnSolvedResultIfMachedNumber() {
        generateQuestion("123");

        assertMachtedNumber(game.guess("123"), true, 3, 0);
    }

    @Test
    void returnSolvedResultIf2Strikes0Balls() {
        generateQuestion("123");

        assertMachtedNumber(game.guess("129"), false, 2, 0);
    }



    @Test
    void returnSolvedResultIfUnMachedNumber() {
        generateQuestion("123");
        assertMachtedNumber(game.guess("456"), false, 0, 0);

    }

}