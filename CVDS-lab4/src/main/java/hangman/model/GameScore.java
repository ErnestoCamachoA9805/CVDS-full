package hangman.model;

import hangman.exception.hangmanException;

public interface GameScore {
	public int calculateScore(int correctCount, int incorrectCount)throws hangmanException;
}
