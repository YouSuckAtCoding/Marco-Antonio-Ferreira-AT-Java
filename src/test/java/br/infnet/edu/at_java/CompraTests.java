package br.infnet.edu.at_java;


import java.time.LocalDate;
import java.util.List;

import br.infnet.edu.at_java.Classes.Compra;
import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.Classes.Responsavel;

public class CompraTests {
    
    public boolean CreateCompraWithResponsavel(String codcompra, Responsavel responsavel, LocalDate date, List<Instrumento> produtos){
        try{
            Compra teste = new Compra(codcompra, responsavel, date, produtos);
            System.out.println(teste);
            
            return true;
            
    
            
        }
        catch(Exception ex){
            System.out.println(ex + " Exceção encontrada em CompraTest.java");
            return false;
        }
        
        
    }

    public boolean CreateCompraWithProdutos(String codcompra, Responsavel responsavel, LocalDate date, List<Instrumento> produtos){
        
        try{
            Compra teste = new Compra(codcompra, responsavel, LocalDate.now(), produtos);
            System.out.println(teste);
            if(teste.getProdutos().size() > 0){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception ex){
            return false;
        }
        
        
    }
}