package org.example.kata;

import org.example.TennisGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

        String result = game.tiebreaker2(scoreP1, scoreP2);

        assertEquals(expected, result);

    }
}
