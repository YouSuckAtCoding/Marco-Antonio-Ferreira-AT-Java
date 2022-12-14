package br.infnet.edu.at_java;

import br.infnet.edu.at_java.Classes.Responsavel;

public class ResponsavelTests {
    public boolean CreateResponsavel(String nome, String cpf, String email){
        try{
            Responsavel teste = new Responsavel(nome, cpf, email);
            System.out.println(teste);
            return true;
        }
        catch(Exception ex){
            System.out.println(ex + " Exceção encontrada em ResponsavelTests.");
            return false;
        }
    }
}
