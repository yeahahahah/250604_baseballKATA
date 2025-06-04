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


    @Test
    void returnSolvedResultIfMachedNumber() {
        game.question="123";
        GuessResult result=game.guess("123");
        assertThat(result).isNotNull();
        assertThat(result.solved).isEqualTo(true);
        assertThat(result.strikes).isEqualTo(3);
        assertThat(result.balls).isEqualTo(0);
    }
}