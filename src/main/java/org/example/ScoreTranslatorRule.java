package org.example;

public class ScoreTranslatorRule implements TennisRule {
    @Override
    public String apply(int scoreP1, int scoreP2) {
        String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty", "", "All"};

        boolean validScoreP1 = scoreP1 >= 0 && scoreP1 < 4;
        boolean validScoreP2 = scoreP2 >= 0 && scoreP2 < 4;
        boolean notBothForty = !(scoreP1 == 3 && scoreP2 == 3);

        if (validScoreP1 && validScoreP2 && notBothForty) {
            if (scoreP1 == scoreP2 && scoreP1 != 0) {
                scoreP2 = 5;
            }
            return scoreNames[scoreP1] + "-" + scoreNames[scoreP2];
        }

        throw new IllegalArgumentException("La puntuación está fuera de rango");
    }
}
