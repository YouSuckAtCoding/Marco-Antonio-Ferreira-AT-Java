package br.infnet.edu.at_java.repositories.DataLoaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.infnet.edu.at_java.Classes.Compra;
import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.Classes.Responsavel;
import br.infnet.edu.at_java.Classes.Filhas.Percurssao;

public class PercussaoDataLoader {
	
	
	private String path = "Text\\PercussaoExemplos.txt";
	
	  public List<Percurssao> ReadFile(){
		    try {
		      
		    	
		      FileReader reader = new FileReader(path);
		      BufferedReader bufferedReader = new BufferedReader(reader);
		      
		      String lines = bufferedReader.readLine();
		      String fields[] = null;

		      List<Percurssao> instrumentos = new ArrayList<Percurssao>();
		      

		      while(lines != null){

		        fields = lines.split(";");
		       
		        
				 double precoPercurssao = Double.parseDouble(fields[3]); boolean
				 capacidade = Boolean.parseBoolean(fields[4]);
				 Percurssao percurssao = new Percurssao();
				 
				
				 percurssao.setId(1);
				 percurssao.setNome(fields[1]);
				 percurssao.setPreco(precoPercurssao);
				 percurssao.setTipo(fields[2]);
				 percurssao.setProducaoSom(fields[5]);
				 percurssao.setCapacidadeAfinacao(capacidade);
				 instrumentos.add(percurssao); 
				  
		      }
		        lines = bufferedReader.readLine();

		      
		      bufferedReader.close();

		      return instrumentos;
		      
		    } 
		    catch (Exception e) 
		    {
		      System.out.println("Erro ao ler o arquivo especificado.");
		      e.printStackTrace();
		      
		      return new ArrayList<Percurssao>();

		    }
		    
		  }
}
