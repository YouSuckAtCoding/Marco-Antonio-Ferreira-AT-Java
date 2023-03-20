package br.infnet.edu.at_java.Utility;

import java.util.ArrayList;
import java.util.List;

import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.Classes.Filhas.Corda;
import br.infnet.edu.at_java.Classes.Filhas.Percussao;
import br.infnet.edu.at_java.Classes.Filhas.Sopro;

public class UtilityClass {
    //https://www.geeksforgeeks.org/generate-random-string-of-given-size-in-java/
    public static String getAlphaNumericString(int n){
    
    String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
            + "0123456789"
            + "abcdefghijklmnopqrstuvxyz";
    
    StringBuilder sb = new StringBuilder(n);
    
    for (int i = 0; i < n; i++) {
    
    int index = (int)(AlphaNumericString.length() * Math.random());
    
    sb.append(AlphaNumericString.charAt(index));
    }
    
    return sb.toString();
    }
       

	/*
	 * public List<Instrumento> CreateExampleProductsList(){
	 * 
	 * try{ Corda prod1 = new Corda("Strinberg Clg 45", "Guitarra", 900, 6); Sopro
	 * prod2 = new Sopro("Flauta Doce", "Flauta", 600, "Madeira", "Tenor");
	 * Percurssao prod3 = new Percurssao("TAMA ImperialStar", "Bateria", 8000,
	 * false, "Idiofone"); List<Instrumento> exampList = new
	 * ArrayList<Instrumento>(); exampList.add(prod1); exampList.add(prod2);
	 * exampList.add(prod3); return exampList; } catch(Exception ex){
	 * System.out.println(ex + "Exceção encontrada em UtilityClass.java"); }
	 * 
	 * return new ArrayList<Instrumento>(); }
	 */
    
    public char checkInstrumento(Instrumento inst) 
	{
		
		if(inst instanceof Percussao){
			return 'P';
		}
		if(inst instanceof Sopro){
			return 'S';
		}
		if(inst instanceof Corda){
			return 'C';
		}
		
		return 'X';
	}


    

    


}


