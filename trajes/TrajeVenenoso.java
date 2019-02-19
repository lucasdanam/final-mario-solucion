package trajes;

import excepciones.NotieneMasVida;
import personajes.Mario;

public class TrajeVenenoso extends Traje{

	public TrajeVenenoso() {
		this.poder=10;
	}
	
	public void potenciarAtaque(Mario mario) {
		mario.incrementarPoder(poder);
		try {
			mario.disminuirVida(poder/2);
		} catch (NotieneMasVida e) {
			System.out.println("Mario Gano");
		}
	}
}
