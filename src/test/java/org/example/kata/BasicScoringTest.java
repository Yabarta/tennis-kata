package org.example.kata;

import org.example.TennisGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BasicScoringTest {
    static Stream<Arguments> basicScoringProvider() {
        return Stream.of (
                Arguments.of(0, 0, "Love-Love"),
                Arguments.of(1, 0, "Fifteen-Love"),
                Arguments.of(0, 1, "Love-Fifteen"),
                Arguments.of(1, 1, "Fifteen-All"),
                Arguments.of(2, 0, "Thirty-Love"),
                Arguments.of(0, 2, "Love-Thirty"),
                Arguments.of(2, 1, "Thirty-Fifteen"),
                Arguments.of(3, 0, "Forty-Love"),
                Arguments.of(2, 2, "Thirty-All")
        );
    }

    @ParameterizedTest
    @MethodSource("basicScoringProvider")
    void should_return_number_in_string(int scoreP1, int scoreP2, String expected) {
        TennisGame game = new TennisGame();

        String result = game.scoreTranslator(scoreP1, scoreP2);

        assertEquals(expected, result);

    }

    static Stream<Arguments> invalidProvider() {
        return Stream.of(
                Arguments.of(0, 36),
                Arguments.of(3, 3),
                Arguments.of(2, 5),
                Arguments.of(2, 4),
                Arguments.of(8, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidProvider")
    void should_throw_IllegalArgumentException_for_invalid_scores(int scoreP1, int scoreP2) {
        TennisGame game = new TennisGame();

        assertThrows(IllegalArgumentException.class, () -> game.scoreTranslator(scoreP1, scoreP2));
    }
}
