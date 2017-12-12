package org.ejercicio;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JOptionPane;

public class Algoritmo {
	
	public static Constante get16Digitos(){
		return (str) -> str.length();
	}
	
	public static CompruebaNumero getComprobacion(){
		return (str) -> {
			try{				
				Double.parseDouble(str);
				return true;
			}catch(NumberFormatException e){
				return false;
			}
		};	
	}
	
	public static Resultado getResultado(){
		return (tarjeta) -> {
			int nCheck = 0, nDigit = 0;
			boolean bEven = false;
			
			for (int n = tarjeta.length() - 1; n >= 0; n--) {
		        String cDigit = String.valueOf(tarjeta.charAt(n));
		            nDigit = Integer.parseInt(cDigit, 10);
		        if (bEven) {
		          if ((nDigit *= 2) > 9) nDigit -= 9;
		        }
		        nCheck += nDigit;
		        bEven = !bEven;
		      }
		      return (nCheck % 10) == 0;
		};
	}
	
	public static String procesarTarjeta(String numeroTarjeta){
		if(numeroTarjeta == null || numeroTarjeta==""){
			return "No a ingresado ningun valor de entrada"; 
		}
		
		if(!getComprobacion().isNumero(numeroTarjeta)){
			return "La tarjeta solo debe contener numeros";
		}
		
		if(get16Digitos().valor(numeroTarjeta) != 16){
			return "La tarjeta no tiene 16 digitos";			
		}
		
		if(getResultado().validarTarjeta(numeroTarjeta)){
			return "Credit Card "+numeroTarjeta+" is valid";
		}
		return  "Credit Card "+numeroTarjeta+" is not valid";		
	}
	
	public static void main (String[] args) {
		String numeroTarjeta = JOptionPane.showInputDialog("Ingrese tarjeta de credito (Solo 16 dígitos)");			
		System.out.println(procesarTarjeta(numeroTarjeta));
		
	}	

}
 
interface Constante{
	int valor(String str);
}

interface CompruebaNumero{
	boolean isNumero(String str);
}

interface Resultado{
	boolean validarTarjeta(String str);
}
