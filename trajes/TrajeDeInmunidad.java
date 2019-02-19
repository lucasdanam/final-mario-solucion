package trajes;

import personajes.Mario;

public class TrajeDeInmunidad extends Traje {

	@Override
	public void proteger(Mario mario, int ataque) {
	  //No Hay Disminucion de vida porque el traje da proteccion total
	}

	@Override
	public void potenciarAtaque(Mario mario) {
		//No potencia el ataque, es el mismo que ya tenia
	}
}
