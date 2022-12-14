package br.infnet.edu.at_java.FileOperations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


import br.infnet.edu.at_java.Classes.Compra;
import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.Classes.Responsavel;
import br.infnet.edu.at_java.Classes.Filhas.Corda;
import br.infnet.edu.at_java.Classes.Filhas.Percurssao;
import br.infnet.edu.at_java.Classes.Filhas.Sopro;

public class FileHandler {
  
  private String path = "Text\\atjava.txt";

  public boolean CreateFile(){

    try {
      File textfile = new File(path);
      if (textfile.createNewFile()) {
        System.out.println("Arquivo criado: " + textfile.getName());
      } else {
        System.out.println("Arquivo já existe.");
      }
      return true;
    }
    catch (IOException e) {
      System.out.println("Erro ao criar o arquivo.");
      return false;
    }

  }

  public boolean CreateFile(String newPath){

    try {
      File textfile = new File("Text\\" + newPath);
      if (textfile.createNewFile()) {
        System.out.println("Arquivo criado: " + textfile.getName());
      } else {
        System.out.println("Arquivo já existe.");
      }
      return true;
    }
    catch (IOException e) {
      System.out.println("Erro ao criar o arquivo.");
      return false;
    }

  }

  public boolean WriteInFile(String content){
    try {
      File textfile = new File(path);

      if(checkIfFileHasContent(textfile)){
        FileWriter myWriter = new FileWriter(path, true);
        myWriter.append("\n"+content);
        myWriter.close();
      }
      else{
        FileWriter myWriter = new FileWriter(path);
        myWriter.append(content);
        myWriter.close();
      }

      
 
      System.out.println("Dados escritos no arquivo.");
      return true;
    } catch (IOException e) {
      System.out.println("Erro ao escerver no arquivo especificado.");
      e.printStackTrace();
      return false;
    }
  }

  public boolean WriteInFile(String content, String newPath){
    try {
      String newFilePath = "Text\\" + newPath;
      File textfile = new File(newFilePath);
      
      if(checkIfFileHasContent(textfile)){
        FileWriter myWriter = new FileWriter(newFilePath, true);
        myWriter.append("\n"+content);
        myWriter.close();
      }
      else{
        FileWriter myWriter = new FileWriter(newFilePath);
        myWriter.append(content);
        myWriter.close();
      }

      
 
      System.out.println("Dados escritos no arquivo.");
      return true;
    } catch (IOException e) {
      System.out.println("Erro ao escerver no arquivo especificado.");
      e.printStackTrace();
      return false;
    }
  }

  private boolean checkIfFileHasContent(File file) {
    if(file.length() > 0){
      return true;
    }
    else{
      return false;
    }
  }

  public String ReadFile(){
    try {
      
      FileReader reader = new FileReader(path);
      BufferedReader bufferedReader = new BufferedReader(reader);
      
      String lines = bufferedReader.readLine();
      String fields[] = null;

      List<Instrumento> instrumentos = new ArrayList<Instrumento>();
      Compra compra = null;

      while(lines != null){

        fields = lines.split(";");

        switch(fields[0]){
          case "Compra":
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

          String date = fields[5];
  
          LocalDate localDate = LocalDate.parse(date, formatter);

          compra = new Compra(fields[1], new Responsavel(fields[2], fields[3], fields[4]), localDate, instrumentos);
          break;

          case "P":
          double precoPercurssao = Double.parseDouble(fields[3]);
          boolean capacidade = Boolean.parseBoolean(fields[4]);
          Percurssao percurssao = new Percurssao(fields[1], fields[2], precoPercurssao, capacidade, fields[5]);
          instrumentos.add(percurssao);
          break;

          case "S":
          double precoSopro = Double.parseDouble(fields[3]);
          Sopro sopro = new Sopro(fields[1], fields[2], precoSopro, fields[4], fields[5]);
          instrumentos.add(sopro);
          break;

          case "C":
          double precoCorda = Double.parseDouble(fields[3]);
          int numcordas = Integer.parseInt(fields[4]);
          Corda corda = new Corda(fields[1], fields[2], precoCorda, numcordas);
          instrumentos.add(corda);
          break;
          
          default:
          System.out.println("Registro inválido!!!");
						break;


        }
        lines = bufferedReader.readLine();

      }
      bufferedReader.close();
      WriteInFile(compra.toString(), "outatjava.txt");



      return "Arquivo lido com sucesso!";
      
    } 
    catch (Exception e) 
    {
      System.out.println("Erro ao ler o arquivo especificado.");
      e.printStackTrace();
      
      return "Arquivo não foi lido corretamente.";

    }
    
  }

  
}
