package trajes;

import excepciones.NotieneMasVida;
import personajes.Mario;

public abstract class Traje {
	
	protected int poder;
	
	public void proteger(Mario mario, int ataqueEnemigo) {
		try {
			mario.disminuirVida(ataqueEnemigo);
		} catch (NotieneMasVida e) {
			System.out.println("Mario Gano");
		}
	}

	public void potenciarAtaque(Mario mario) {
		mario.incrementarPoder(this.poder);
	}

}
