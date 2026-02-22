package org.example;

public class WinningWithoutAdvantageRule implements TennisRule {
    @Override
    public String apply(int scoreP1, int scoreP2) {
        if (scoreP1 == 4) {
            return "Player 1 wins";
        } else if (scoreP2 == 4) {
            return "Player 2 wins";
        }
        throw new IllegalArgumentException("La puntuación está fuera de rango");
    }
}
