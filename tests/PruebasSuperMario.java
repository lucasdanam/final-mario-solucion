package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import excepciones.NotieneMasVida;
import personajes.Bowser;
import personajes.Mario;
import personajes.Personaje;
import trajes.TrajeDeInmunidad;
import trajes.TrajeEspecial;
import trajes.TrajeVenenoso;

public class PruebasSuperMario {
	
	@Test
	public void testMarioIniciaCon70viday10poder() {
		Personaje mario = new Mario();
		
		assertEquals(70, mario.getVida());
		assertEquals(10, mario.getPoder());
	}
	
	@Test
	public void testBowserIniciaCon100viday20poder() {
		Personaje bowser = new Bowser();
		
		assertEquals(100, bowser.getVida());
		assertEquals(20, bowser.getPoder());
	}

	
	@Test
	public void testMarioAtacaABowserYLeQuita10Vida() {
		Personaje mario = new Mario();
		Personaje bowser = new Bowser();
		
		mario.atacar(bowser);
		
		assertEquals(90, bowser.getVida());
	}
	
	@Test
	public void testBowserAtacaAMarioYLeQuita20Vida() {
		Personaje mario = new Mario();
		Personaje bowser = new Bowser();
		
		bowser.atacar(mario);
		
		assertTrue(mario.getVida() == 50);
	}
	
	@Test
	public void testMarioConTrajeVenenosoAtacaYQuita10VidaAAdversarioY5vidaAElMismo() {
		Mario mario = new Mario();
		Bowser bowser = new Bowser();
		
		mario.ponerTraje(new TrajeVenenoso());
		
		mario.atacar(bowser);
		
		assertEquals(65, mario.getVida());
		assertEquals(90, bowser.getVida());
	}
	
	@Test
	public void testBowserAtacaAMarioConTrajeDeInmunidadYNoLeQuitaVida() {
		Mario mario = new Mario();
		Bowser bowser = new Bowser();
		
		mario.ponerTraje(new TrajeDeInmunidad());
		
		bowser.atacar(mario);
		
		assertEquals(70, mario.getVida());
	}
	
	@Test
	public void testMarioConTrajeEspecialDuplicaPoderDeAtaque() {
		Mario mario = new Mario();
		mario.ponerTraje(new TrajeEspecial());
		assertEquals(20, mario.getPoder());
	}
	
	@Test
	public void testMarioConTrajeEspecialDescuentaElDobleDeVida() {
		Mario mario = new Mario();
		Bowser bowser = new Bowser();
		
		mario.ponerTraje(new TrajeEspecial());
		mario.atacar(bowser);
		assertEquals(80, bowser.getVida());//en vez de 10 descuenta 20 de vida
	}
	
	@Test
	public void testMarioConTrajeEspecialEsAtacadoYProduceLaMitadDeDanio() {
		Mario mario = new Mario();
		Bowser bowser = new Bowser();
		
		mario.ponerTraje(new TrajeEspecial());
		bowser.atacar(mario);
		assertEquals(60, mario.getVida());//Bowser tiene ataque igual a 20 pero el danio a Mario es de 10
	}
	
	@Test
	public void testMarioAtaca10VecesABowserCon100VidaYBowserQuedaCon0Vida() {
		Mario mario = new Mario();
		Bowser bowser = new Bowser();
		
		for (int i=1; i<=10; i++) {
			mario.atacar(bowser);
		}
		assertEquals(0, bowser.getVida());
		
	}
	
	@Test
	public void testMarioAtaca11VecesABowserCon100VidaYBowserSigueCon0Vida() {
		Mario mario = new Mario();
		Bowser bowser = new Bowser();
		
		for (int i=1; i<=11; i++) {
			mario.atacar(bowser);
		}
		assertEquals(0, bowser.getVida());
		
	}
	
	@Test
	public void testDisminuir10VecesABowserCon100VidaMarioGana() {
		Bowser bowser = new Bowser();
		boolean atrapada=false;
		for (int i=1; i<=10; i++) {
			try {
				bowser.disminuirVida(10);
			} catch (NotieneMasVida e) {
				atrapada=true;
			}
		}
		assertEquals(0, bowser.getVida());
		assertEquals(true, atrapada);
		
	}
}
