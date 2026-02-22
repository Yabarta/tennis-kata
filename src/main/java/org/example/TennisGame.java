package org.example;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {
    public String scoreTranslator(int scoreP1, int scoreP2) {
        String[] scoreNames = {"Love", "Fifteen", "Thirty", "Forty", "", "All"};

        if (scoreP1 < 4 && scoreP2 < 4 && (scoreP1 != 3 && scoreP2 != 3)) {
            if(scoreP1 == scoreP2 && scoreP1 != 0){
                scoreP2 = 5;
            }
            return scoreNames[scoreP1] + "-" + scoreNames[scoreP2];
        }

        return "Puntuación fuera del rango básico";
    }

    public String winningWithoutAdvantage(int scoreP1, int scoreP2) {
        if (scoreP1 == 4){
            return "Player 1 wins";
        } else if (scoreP2 == 4) {
            return "Player 2 wins";
        }
        return "Puntuación fuera del rango de victoria";
    }

    public String tiebreaker(int scoreP1, int scoreP2) {
        String result = "Puntuación fuera del rango de empate";
        Map<String, String> rules = new HashMap<>();
        rules.put("3-3","Deuce");
        rules.put("4-3","Advantage Player 1");
        rules.put("3-4","Advantage Player 2");
        rules.put("5-3","Player 1 wins");
        rules.put("3-5","Player 2 wins");

        String keySearch = scoreP1 + "-" + scoreP2;

        for (String clave:  rules.keySet()) {
            if (clave.equals(keySearch)) {
                result = rules.get(clave);
            }
        }

        return result;
    }

    public String tiebreaker2(int scoreP1, int scoreP2) {
        String result = "Puntuación fuera del rango de empate";
        Map<Integer, String> rules = new HashMap<>();
        rules.put(0,"Deuce");
        rules.put(1,"Advantage Player 1");
        rules.put(-1,"Advantage Player 2");
        rules.put(2,"Player 1 wins");
        rules.put(-2,"Player 2 wins");

        Integer diff = scoreP1 - scoreP2;

        for (Integer clave:  rules.keySet()) {
            if (clave.equals(diff)) {
                result = rules.get(clave);
            }
        }

        return result;
    }
}
