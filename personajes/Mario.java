package personajes;

import trajes.Traje;
import trajes.TrajeEstandar;

public class Mario extends Personaje {
	
	private Traje traje;
	
	public Mario() {
		this.traje=new TrajeEstandar();
		traje.potenciarAtaque(this);
		this.vida=70;
	}
	
	public void recibirAtaque(int ataque) {
		traje.proteger(this,ataque);
	}
	
	public void ponerTraje(Traje traje){
		this.traje=traje;
		this.traje.potenciarAtaque(this);
	}
}
