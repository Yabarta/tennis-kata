package org.example.kata;

import org.example.TennisGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DeuceAndAdvantageTest {
    static Stream<Arguments> deuceAndAdvantageProvider() {
        return Stream.of (
                Arguments.of(3, 3, "Deuce"),
                Arguments.of(4, 3, "Advantage Player 1"),
                Arguments.of(3, 4, "Advantage Player 2"),
                Arguments.of(5, 3, "Player 1 wins"),
                Arguments.of(3, 5, "Player 2 wins")
        );
    }

    @ParameterizedTest
    @MethodSource("deuceAndAdvantageProvider")
    void should_return_number_in_string(int scoreP1, int scoreP2, String expected) {
        TennisGame game = new TennisGame();

        String result = game.tiebreaker(scoreP1, scoreP2);

        assertEquals(expected, result);

    }

    static Stream<Arguments> invalidProvider() {
        return Stream.of(
                Arguments.of(0, 3),
                Arguments.of(3, 0),
                Arguments.of(2, 5),
                Arguments.of(6, 3),
                Arguments.of(7, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("invalidProvider")
    void should_throw_IllegalArgumentException_for_invalid_scores(int scoreP1, int scoreP2) {
        TennisGame game = new TennisGame();

        assertThrows(IllegalArgumentException.class, () -> game.tiebreaker(scoreP1, scoreP2));
    }
}
