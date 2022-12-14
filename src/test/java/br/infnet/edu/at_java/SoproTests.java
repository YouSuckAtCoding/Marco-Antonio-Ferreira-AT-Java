package br.infnet.edu.at_java;

import br.infnet.edu.at_java.Classes.Filhas.Sopro;

public class SoproTests {

    public boolean CreateInstrumentoSopro(String nome, String tipo, double preco, String material, String classificacao){
        try
        {   
            Sopro teste = new Sopro(nome, tipo, preco, material, classificacao);   
            if(material.length() <= 0 || classificacao.length() <= 0){
                return false;
            }            
            System.out.println(teste);
            return true;         
        }
        catch(Exception ex){
            System.out.println(ex + " Exceção encontrada em SoproTest.java");
            return false;
            
        }   
    }

    public double TestCalcularParcelasSopro(int parcelas, double preco){
        Sopro teste;
        try {
            teste = new Sopro("Teste", "Teste", preco , "Teste", "Teste");
            return teste.CalcularValorParcelado(parcelas);
        } catch (Exception ex) {
            System.out.println(ex + " Exceção encontrada em SoproTest.java");
            return 0;
        }
        
    }

   
}
