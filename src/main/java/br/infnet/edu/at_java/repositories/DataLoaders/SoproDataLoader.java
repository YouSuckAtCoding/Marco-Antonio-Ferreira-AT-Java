package br.infnet.edu.at_java.repositories.DataLoaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import br.infnet.edu.at_java.Classes.Filhas.Sopro;



public class SoproDataLoader {
	private String path = "Text\\SoproExemplos.txt";
	
	  public List<Sopro> ReadFile(){
		    try {
		      
		    	
		      FileReader reader = new FileReader(path);
		      BufferedReader bufferedReader = new BufferedReader(reader);
		      
		      String lines = bufferedReader.readLine();
		      String fields[] = null;

		      List<Sopro> instrumentos = new ArrayList<Sopro>();
		      int count = 1;

		      while(lines != null){

		        fields = lines.split(";");

				 Sopro sopro = new Sopro();
				 
				 double precoSopro = Double.parseDouble(fields[3]);
				 sopro.setId(count);
				 sopro.setNome(fields[1]);
				 sopro.setTipo(fields[2]);
				 sopro.setPreco(precoSopro);
				 sopro.setMaterial(fields[4]);
				 sopro.setClassificacao(fields[5]);
				 instrumentos.add(sopro); 
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
		      
		      return new ArrayList<Sopro>();

		    }
		    
		  }
}
