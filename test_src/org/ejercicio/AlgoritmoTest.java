package org.ejercicio;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;

public class AlgoritmoTest {
		
	
	@Test
	public void testDevolver16Digitos(){
		assertEquals(16, Algoritmo.get16Digitos().valor("1234567891234565"));
	}
	
	@Test
	public void testIsNumero(){
		assertTrue(Algoritmo.getComprobacion().isNumero("34"));
	}
	
	@Test
	public void testResultadoFinal(){
		//4012888888881881  valida
		//4012888888881882  No valida
		assertTrue(Algoritmo.getResultado().validarTarjeta("4012888888881881"));		
	}
	
	@Test
	public void testProcesoTarjeta(){
		//4012888888881881  valida
		//4012888888881882  No valida
		String str = "4012888888881881";
		assertEquals("Credit Card "+str+" is valid", Algoritmo.procesarTarjeta(str));		
	}
}
