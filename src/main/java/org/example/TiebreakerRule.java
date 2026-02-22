package org.example;

import java.util.HashMap;
import java.util.Map;

public class TiebreakerRule implements TennisRule {
    @Override
    public String apply(int scoreP1, int scoreP2) {
        Map<Integer, String> rules = new HashMap<>();
        rules.put(0, "Deuce");
        rules.put(1, "Advantage Player 1");
        rules.put(-1, "Advantage Player 2");
        rules.put(2, "Player 1 wins");
        rules.put(-2, "Player 2 wins");

        Integer diff = scoreP1 - scoreP2;

        if (rules.containsKey(diff)) {
            return rules.get(diff);
        }

        throw new IllegalArgumentException("La puntuación está fuera de rango");
    }
}
