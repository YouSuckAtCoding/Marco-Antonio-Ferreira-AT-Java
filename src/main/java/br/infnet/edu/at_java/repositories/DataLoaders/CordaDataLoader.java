package br.infnet.edu.at_java.repositories.DataLoaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import br.infnet.edu.at_java.Classes.Filhas.Corda;



public class CordaDataLoader {
	private String path = "Text\\CordaExemplos.txt";
	
	  public List<Corda> ReadFile(){
		    try {
		      
		    	
		      FileReader reader = new FileReader(path);
		      BufferedReader bufferedReader = new BufferedReader(reader);
		      
		      String lines = bufferedReader.readLine();
		      String fields[] = null;

		      List<Corda> instrumentos = new ArrayList<Corda>();
		      int count = 1;

		      while(lines != null){

		        fields = lines.split(";");

		        Corda corda = new Corda();
				 
		      	double precoCorda = Double.parseDouble(fields[3]); 
		      	int numcordas = Integer.parseInt(fields[4]);
		      	corda.setId(count);
		      	corda.setNome(fields[1]);
		      	corda.setTipo(fields[2]);
		      	corda.setPreco(precoCorda);
		      	corda.setNumCordas(numcordas);
		      	instrumentos.add(corda);
				count++;

		      }
		        lines = bufferedReader.readLine();

		      
		      bufferedReader.close();

		      return instrumentos;
		      
		    } 
		    catch (Exception e) 
		    {
		      System.out.println("Erro ao ler o arquivo especificado.");
		      e.printStackTrace();
		      
		      return new ArrayList<Corda>();

		    }
		    
		  }
}
