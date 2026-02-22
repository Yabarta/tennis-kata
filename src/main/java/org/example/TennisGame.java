package org.example;

public class TennisGame {
    private final TennisRule scoreTranslatorRule = new ScoreTranslatorRule();
    private final TennisRule winningWithoutAdvantageRule = new WinningWithoutAdvantageRule();
    private final TennisRule tiebreakerRule = new TiebreakerRule();

    public String scoreTranslator(int scoreP1, int scoreP2) {
        return scoreTranslatorRule.apply(scoreP1, scoreP2);
    }

    public String winningWithoutAdvantage(int scoreP1, int scoreP2) {
        return winningWithoutAdvantageRule.apply(scoreP1, scoreP2);
    }

    public String tiebreaker(int scoreP1, int scoreP2) {
        return tiebreakerRule.apply(scoreP1, scoreP2);
    }
}
