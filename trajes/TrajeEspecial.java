package trajes;

import excepciones.NotieneMasVida;
import personajes.Mario;

public class TrajeEspecial extends Traje {

	@Override
	public void proteger(Mario mario, int ataque) {
		try {
			mario.disminuirVida(mario.getPoder()/2);
		} catch (NotieneMasVida e) {
			System.out.println("Mario Gano");
		}

	}

	@Override
	public void potenciarAtaque(Mario mario) {
		mario.incrementarPoder(mario.getPoder()*2);

	}

}
