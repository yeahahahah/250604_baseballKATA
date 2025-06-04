public class Game {

    public String question;

    public GuessResult guess(String guessNumber) {


        assertIllegalArgument(guessNumber);
        if (guessNumber.equals(question)) {
            return new GuessResult(true, 3, 0);
        } else {
            int strikeCount = getStrikeCount(guessNumber);
            int ballCount = getBallCount(guessNumber);
           return new GuessResult(false, strikeCount, ballCount);
        }


    }

    private int getBallCount(String guessNumber) {
        int ballCount=0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) continue;
                if (guessNumber.charAt(i) == question.charAt(j)) {
                    ballCount++;
                }
            }
        }
        return ballCount;
    }

    private int getStrikeCount(String guessNumber) {
        int strikeCount=0;
        for (int i = 0; i < 3; i++) {
            if (guessNumber.charAt(i) == question.charAt(i)) {
                strikeCount++;
                continue;
            }
        }
        return strikeCount;
    }

    private void assertIllegalArgument(String guessNumber) {
        if (guessNumber == null) {
            throw new IllegalArgumentException();
        }

        if (guessNumber.length() != 3) {
            throw new IllegalArgumentException();
        }

        for (char number : guessNumber.toCharArray()) {
            if (number < '0' || number > '9') {
                throw new IllegalArgumentException();
            }
        }

        if (isDuplicatedNumber(guessNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicatedNumber(String guessNumber) {
        return guessNumber.charAt(0) == guessNumber.charAt(1)
                || guessNumber.charAt(0) == guessNumber.charAt(2)
                || guessNumber.charAt(1) == guessNumber.charAt(2);
    }
}
