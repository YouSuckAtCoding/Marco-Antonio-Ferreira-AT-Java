package br.infnet.edu.at_java.Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.infnet.edu.at_java.Exceptions.InvalidCodigoCompraException;
import br.infnet.edu.at_java.Exceptions.NoInstrumentoException;
import br.infnet.edu.at_java.Exceptions.NullResponsavelException;

public class Compra {

    private String CodCompra;
   
    private Responsavel Responsavel;
   
    private LocalDate DataCompra;
   
    private List<Instrumento> Produtos;

    public Compra(String codcompra, Responsavel responsavel, LocalDate datacompra, List<Instrumento> produtos) throws Exception {
        
          
            var check = ValidateData(codcompra, responsavel, datacompra, produtos);
            if(check != null)
            {
                throw check;
            }   
            
            this.CodCompra = codcompra;
            this.Responsavel = responsavel;
            this.DataCompra = datacompra;
            this.Produtos = produtos;
        
        
    }

    public String getCodCompra() {
        return CodCompra;
    }
    
    public Responsavel getResponsavel() {
        return Responsavel;
    }

    public String getDataCompra() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
        String dataFormatada = formatter.format(DataCompra);
        return dataFormatada;
    }

    public List<Instrumento> getProdutos() {
        return Produtos;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Código da Compra: ");
        str.append(CodCompra);
        str.append(" Data da Compra: ");
        str.append(DataCompra);
        str.append("\n");
        str.append("Responsavel: ");
        str.append(Responsavel.getNome());
        str.append(" Cpf: ");
        str.append(Responsavel.getCpf());
        str.append(" Email: ");
        str.append(Responsavel.getEmail());
        str.append("\n");
        str.append("Produtos: ");
        str.append("\n");
        for (Instrumento instrumento : Produtos) 
        {
            
            str.append(instrumento);
            str.append("\n");
        }

        return str.toString();
    }
    
    private Exception ValidateData(String codcompra, Responsavel responsavel, LocalDate datacompra, List<Instrumento> produtos){
        if(codcompra.length() <= 0 || codcompra == null){
            return new InvalidCodigoCompraException("O atributo Codígo da Compra não pode ser vazio.");
        }
        if(responsavel == null){
            return new NullResponsavelException("Não há nenhum responsável por esta compra.");
        }
        if(produtos == null){
            return new NoInstrumentoException("Não existem Produtos(Instrumentos) na compra.");
        }
        return null;

    }
}
