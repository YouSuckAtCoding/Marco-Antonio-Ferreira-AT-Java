package br.infnet.edu.at_java.Classes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;



import br.infnet.edu.at_java.Exceptions.InvalidCodigoCompraException;
import br.infnet.edu.at_java.Exceptions.NoInstrumentoException;
import br.infnet.edu.at_java.Exceptions.NullResponsavelException;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
	
	@OneToOne(cascade = CascadeType.DETACH) 
	@JoinColumn(name = "UsuarioId")
    private Usuario Responsavel;
   
    private LocalDate DataCompra;
    @ManyToMany(cascade = CascadeType.DETACH)
    private List<Instrumento> Produtos;
    
    public void setCodCompra(int id) {
		Id = id;
	}

	public void setResponsavel(Usuario responsavel) {
		Responsavel = responsavel;
	}

	public void setDataCompra(LocalDate dataCompra) {
		DataCompra = dataCompra;
	}

	public void setProdutos(List<Instrumento> produtos) {
		Produtos = produtos;
	}

	public int getId() {
        return Id;
    }
    
    public Usuario getResponsavel() {
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
