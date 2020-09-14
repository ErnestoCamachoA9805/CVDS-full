package hangman.test;

import hangman.exception.hangmanException;
import hangman.model.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class GameScoreTest {

	/**
	 * Debe probar que el juego inicia con 100 puntos  y que no se bonifican las letras correctas.
	 */
	@Test
	public void OriginalScoreTestOk() {
		GameScore calcu= new OriginalScore();
		int valorEsperado= 100;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(5,0);
			assertTrue(valorRespuesta==valorEsperado);
		} catch (hangmanException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Debe probar que el juego no tenga valores negativos en las letras correctas e incorrectas.
	 */
	@Test
	public void OriginalScoreTestNoOk() {
		GameScore calcu= new OriginalScore();
		int valorEsperado= 100;
		try {
			int valorRespuesta;
			valorRespuesta = calcu.calculateScore(-5,0);
			fail("opero con el valor negativo");
		} catch (hangmanException e) {
			
		}
	}
	
	/**
	 * Debe probar que el juego penaliza las letras incorrectas retirando 10 puntos.
	 */
	@Test
	public void OriginalScoreTestPenalizacionOk() {
		GameScore calcu= new OriginalScore();
		int valorEsperado= 90;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(5,1);
			assertTrue(valorRespuesta==valorEsperado);
		} catch (hangmanException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Debe probar que el juego tiene un puntaje minimo 0, se prueba exactamente en la frontera con 0 porque matematicamente y en el 
	 * programa el resultado debe ser 0.
	 */
	@Test
	public void OriginalScoreTestPenalizacionZero() {
		GameScore calcu= new OriginalScore();
		int valorEsperado= 0;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(5,10);
			assertTrue(valorRespuesta==valorEsperado);
		} catch (hangmanException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Debe probar que el juego tiene un puntaje minimo 0 que nunca es negativo, se prueba exactamente en la frontera con un valor negativo
	 * en este caso es de -10 matematicamente pero en el programa el resultado debe ser 0.
	 */
	@Test
	public void OriginalScoreTestPenalizacionNegativa() {
		GameScore calcu= new OriginalScore();
		int valorEsperado= 0;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(0,11);
			assertTrue(valorRespuesta==valorEsperado);
		} catch (hangmanException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Debe probar que el juego inicia con 0 puntos, que se penalizan las letras incorrectas con 5 puntos y se bonifican las letras 
	 * correctas con 10 puntos.
	 */
	@Test
	public void BonusScoreTestOk() {
		GameScore calcu= new BonusScore();
		int valorEsperado= 45;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(5,1);
			assertTrue(valorRespuesta==valorEsperado);
		} catch (hangmanException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Debe probar que el juego tiene un puntaje minimo 0, se prueba exactamente en la frontera con 0 porque matematicamente y en el 
	 * programa el resultado debe ser 0.
	 */
	@Test
	public void BonusScoreTestPenalizacionZero() {
		GameScore calcu= new BonusScore();
		int valorEsperado= 0;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(5,10);
			assertTrue(valorRespuesta==valorEsperado);
		} catch (hangmanException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Debe probar que el juego tiene un puntaje minimo 0 que nunca es negativo, se prueba exactamente en la frontera con un valor negativo
	 * en este caso es de -55 matematicamente pero en el programa el resultado debe ser 0.
	 */
	@Test
	public void BonusScoreTestPenalizacionNegativa() {
		GameScore calcu= new BonusScore();
		int valorEsperado= 0;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(0,11);
			assertTrue(valorRespuesta==valorEsperado);
		} catch (hangmanException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Debe probar que el juego no tenga valores negativos en las letras correctas e incorrectas.
	 */
	@Test
	public void BonusScoreTestNoOk() {
		GameScore calcu= new BonusScore();
		int valorEsperado= 50;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(-5,0);
			fail("opero con un valor negativo");
		} catch (hangmanException e) {
		}
	}
	
	/**
	 * Debe probar que el juego inicia con 0 puntos, que se bonifica el numero de letras de la palabra elevado al numero de aciertos y que
	 * si se sobrepasan los 500 puntos, el puntaje maximo es 500.
	 */
	@Test
	public void PowerScoreTestOk() {
		GameScore calcu= new PowerScore();
		int valorEsperado= 500;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(5,0);
			assertTrue(valorRespuesta==valorEsperado);
		} catch (hangmanException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Debe probar que el juego penaliza con 8 puntos las letras incorrectas.
	 */
	@Test
	public void PowerScoreTestPenalizacionOk() {
		GameScore calcu= new PowerScore();
		int valorEsperado= 17;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(2,1);
			assertTrue(valorRespuesta==valorEsperado);
		} catch (hangmanException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Debe probar que el juego tiene un puntaje minimo 0 que nunca es negativo, se prueba exactamente en la frontera con un valor negativo
	 * en este caso es de -3 matematicamente pero en el programa el resultado debe ser 0. No se prueba con un valor que de exactamente cero
	 * porque no existe tal valor entonces se prueba directamente la frontera con el que más se acerca y nos ayuda a cubrir los negatvios.
	 */
	@Test
	public void PowerScoreTestPenalizacionNegativa() {
		GameScore calcu= new PowerScore();
		int valorEsperado= 0;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(1,1);
			assertTrue(valorRespuesta==valorEsperado);
		} catch (hangmanException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Debe probar que el juego no tenga valores negativos en las letras correctas e incorrectas.
	 */
	@Test
	public void PowerScoreTestNoOk() {
		GameScore calcu= new PowerScore();
		int valorEsperado= 500;
		int valorRespuesta;
		try {
			valorRespuesta = calcu.calculateScore(5,-1);
			fail("opero con un valor negativo");
		} catch (hangmanException e) {
			
		}
	}

}
