package org.example.kata;

import org.example.TennisGame;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinningTest {
    static Stream<Arguments> winningProvider() {
        return Stream.of (
                Arguments.of(4, 0, "Player 1 wins"),
                Arguments.of(0, 4, "Player 2 wins")
        );
    }

    @ParameterizedTest
    @MethodSource("winningProvider")
    void should_return_number_in_string(int scoreP1, int scoreP2, String expected) {
        TennisGame game = new TennisGame();

        String result = game.winningWithoutAdvantage(scoreP1, scoreP2);

        assertEquals(expected, result);

    }
}
