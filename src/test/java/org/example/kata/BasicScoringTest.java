package org.example.kata;

import org.example.TennisGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicScoringTest {
    static Stream<Arguments> basicScoringProvider() {
        return Stream.of (
                Arguments.of(0, 0, "Love-Love"),
                Arguments.of(1, 0, "Fifteen-Love"),
                Arguments.of(0, 1, "Love-Fifteen"),
                Arguments.of(1, 1, "Fifteen-All"),
                Arguments.of(2, 0, "Thirty-Love"),
                Arguments.of(0, 2, "Love-Thirty")
        );
    }

    @ParameterizedTest
    @MethodSource("basicScoringProvider")
    void should_return_number_in_string(int scoreP1, int scoreP2, String expected) {
        TennisGame game = new TennisGame();

        String result = game.scoreTranslator(scoreP1, scoreP2);

        assertEquals(expected, result);

    }
}
