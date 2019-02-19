package personajes;

import excepciones.NotieneMasVida;

public abstract class Personaje {
	
	protected int vida;
	protected int poder;

	public void atacar(Personaje adversario) {
		adversario.recibirAtaque(this.poder);
	}

	protected void recibirAtaque(int ataque) {
		try {
			this.disminuirVida(ataque);
		} catch (NotieneMasVida e) {
			System.out.println("Mario Gano");
		}
	}

	public int getVida() {
		return this.vida;
	}
	
	public void incrementarPoder(int incrementoDePoder) {
		this.poder=incrementoDePoder;
	}

	public void disminuirVida(int vida) throws NotieneMasVida{
		this.vida-=vida;
		if (this.vida<=0) {
			this.vida=0;
			throw new NotieneMasVida();
		}
	}
	
	public int getPoder() {
		return poder;
	}
}
