package org.example;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {
    public String scoreTranslator(int scoreP1, int scoreP2) {
        String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty", "", "All"};

        Boolean validScoreP1 = scoreP1 >= 0 && scoreP1 < 4;
        Boolean validScoreP2 = scoreP2 >= 0 && scoreP2 < 4;
        Boolean notBothForty = !(scoreP1 == 3 && scoreP2 == 3);

        if (validScoreP1 && validScoreP2 && notBothForty) {
            if(scoreP1 == scoreP2 && scoreP1 != 0){
                scoreP2 = 5;
            }
            return scoreNames[scoreP1] + "-" + scoreNames[scoreP2];
        }

        throw new IllegalArgumentException("La puntuación está fuera de rango");
    }

    public String winningWithoutAdvantage(int scoreP1, int scoreP2) {
        if (scoreP1 == 4){
            return "Player 1 wins";
        } else if (scoreP2 == 4) {
            return "Player 2 wins";
        }
        throw new IllegalArgumentException("La puntuación está fuera de rango");
    }

    public String tiebreaker(int scoreP1, int scoreP2) {
        Map<Integer, String> rules = new HashMap<>();
        rules.put(0,"Deuce");
        rules.put(1,"Advantage Player 1");
        rules.put(-1,"Advantage Player 2");
        rules.put(2,"Player 1 wins");
        rules.put(-2,"Player 2 wins");

        Integer diff = scoreP1 - scoreP2;

        if (rules.containsKey(diff)) {
            return rules.get(diff);
        }

        throw new IllegalArgumentException("La puntuación está fuera de rango");
    }
}
