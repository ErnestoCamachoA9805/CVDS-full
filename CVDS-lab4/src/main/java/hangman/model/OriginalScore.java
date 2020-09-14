package hangman.model;

import hangman.exception.hangmanException;

public class OriginalScore implements GameScore {
	

	/**
	 * @pre inicia con 100 puntos
	 * @pos condicion actual del puntaje
	 * @param correctCount 
	 * @param incorrectCount 
	 * @return ans 
	 * @throws NEGATIVE_VALUE_EXCEPTION, cuando el valor es negativo
	 */
	@Override
	public int calculateScore(int correctCount, int incorrectCount) throws hangmanException {
		int i = 100;
		if(correctCount< 0 || incorrectCount< 0) {
			throw new hangmanException(hangmanException.NEGATIVE_VALUE_EXCEPTION);
		}
		i-= incorrectCount*10;
		if (i < 0) {
			i = 0;
		}
		return i;
	}

}
