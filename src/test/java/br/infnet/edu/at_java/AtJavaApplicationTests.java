package br.infnet.edu.at_java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.infnet.edu.at_java.Classes.Compra;
import br.infnet.edu.at_java.Classes.Instrumento;
import br.infnet.edu.at_java.Classes.Responsavel;
import br.infnet.edu.at_java.Classes.Filhas.Corda;
import br.infnet.edu.at_java.Classes.Filhas.Percurssao;
import br.infnet.edu.at_java.Classes.Filhas.Sopro;
import br.infnet.edu.at_java.Utility.UtilityClass;


@SpringBootTest
class AtJavaApplicationTests {

	@Test
	public void InsertResponsavelInCompra_ExpectedTrue(){
		System.out.println("Testando");
		UtilityClass utility = new UtilityClass();
		CompraTests teste = new CompraTests();
		try {
			Responsavel responsavel = new Responsavel("Marco Antonio", "123456789", "marco@marco.com");
			assertTrue(teste.CreateCompraWithResponsavel(utility.getAlphaNumericString(5), responsavel, LocalDate.now(), utility.CreateExampleProductsList() ));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

	@Test
	public void InsertResponsavelInCompra_ExpectedFalse(){
		System.out.println("Testando");
		UtilityClass utility = new UtilityClass();
		CompraTests teste = new CompraTests();
		assertFalse(teste.CreateCompraWithResponsavel(utility.getAlphaNumericString(5), null, LocalDate.now(), utility.CreateExampleProductsList() ));

	}

	@Test
	public void CreateResponsavel_ExpectedTrue(){
		System.out.println("Testando");
		ResponsavelTests teste = new ResponsavelTests();
		assertTrue(teste.CreateResponsavel("Marco Antonio", "123456789", "marco@marco.com"));

	}

	@Test
	public void CreateResponsavel_ExpectedFalse(){
		System.out.println("Testando");
		ResponsavelTests teste = new ResponsavelTests();
		assertFalse(teste.CreateResponsavel("Marco Antonio", "", "marco@marco.com"));

	}

	@Test
	public void CreateInstrumentoCorda_ExpectedTrue(){
		System.out.println("Testando");
		CordaTests teste = new CordaTests();
		assertTrue(teste.CreateInstrumentoCorda("Strinberg Clg 45", "Guitarra", 900, 6));

	}
	
	@Test
	public void CreateInstrumentoCorda_ExpectedFalse(){
		System.out.println("Testando");
		CordaTests teste = new CordaTests();
		assertFalse(teste.CreateInstrumentoCorda("Strinberg Clg 45", "Guitarra", 0, 6));

	}

	@Test
	public void CreateInstrumentoSopro_ExpectedTrue(){
		System.out.println("Testando");
		SoproTests teste = new SoproTests();
		assertTrue(teste.CreateInstrumentoSopro("Flauta Doce", "Flauta", 600, "Madeira", "Tenor"));

	}

	@Test
	public void CreateInstrumentoSopro_ExpectedFalse(){
		System.out.println("Testando");
		SoproTests teste = new SoproTests();
		assertFalse(teste.CreateInstrumentoSopro("Flauta Doce", "", 600, "", "Tenor"));

	}
	@Test
	public void CreateInstrumentoPercussao_ExpectedTrue(){
		System.out.println("Testando");
		PercussaoTests teste = new PercussaoTests();
		assertTrue(teste.CreateInstrumentoPercussao("TAMA ImperialStar", "Bateria", 8000, false, "Idiofone"));
	}

	@Test
	public void CreateInstrumentoPercussao_ExpectedFalse(){
		System.out.println("Testando");
		PercussaoTests teste = new PercussaoTests();
		assertFalse(teste.CreateInstrumentoPercussao("", "Bateria", 8000, false, "Idiofone"));
	}

	@Test
	public void CheckCalcularParcelasCordas_ShouldWork(){
		System.out.println("Testando");
		CordaTests teste = new CordaTests();
		assertEquals(1562.5, teste.TestCalcularParcelasCordas(8, 12500));
		
	}

	@Test
	public void CheckCalcularParcelasCordas_ShouldNotWork(){
		System.out.println("Testando");
		CordaTests teste = new CordaTests();
		assertNotEquals(1562.5, teste.TestCalcularParcelasCordas(8, 15500));
		
	}

	@Test
	public void CheckCalcularParcelasSopro_ShouldWork(){
		System.out.println("Testando");
		SoproTests teste = new SoproTests();
		assertEquals(170.625, teste.TestCalcularParcelasSopro(4, 650));
		
	}

	@Test
	public void CheckCalcularParcelasSopro_ShouldNotWork(){
		System.out.println("Testando");
		SoproTests teste = new SoproTests();
		assertNotEquals(170.625, teste.TestCalcularParcelasSopro(4, 850));
		
	}

	@Test
	public void CheckCalcularParcelasPercussao_ShouldWork(){
		System.out.println("Testando");
		PercussaoTests teste = new PercussaoTests();
		assertEquals(1925, teste.TestCalcularParcelasPercussao(20, 35000));
		
	}

	@Test
	public void CheckCalcularParcelasPercussao_ShouldNotWork(){
		System.out.println("Testando");
		PercussaoTests teste = new PercussaoTests();
		assertNotEquals(1925, teste.TestCalcularParcelasPercussao(20, 45000));
		
	}

	@Test
	public void CreateCompraWith3Produtos_ExpectedTrue(){
		System.out.println("Testando");
		CompraTests teste = new CompraTests();
		List<Instrumento> prods = new ArrayList<Instrumento>();
		UtilityClass utility = new UtilityClass();
		prods = utility.CreateExampleProductsList();
		Responsavel responsavel;
		try {
			responsavel = new Responsavel("Marco Antonio", "123456789", "marco@marco.com");
			assertTrue(teste.CreateCompraWithProdutos(utility.getAlphaNumericString(4), responsavel, LocalDate.now(), prods));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Test
	public void CreateCompraWith3Produtos_ExpectedFalse(){
		System.out.println("Testando");
		CompraTests teste = new CompraTests();
		List<Instrumento> prods = new ArrayList<Instrumento>();
		UtilityClass utility = new UtilityClass();
		prods = utility.CreateExampleProductsList();
		assertFalse(teste.CreateCompraWithProdutos(utility.getAlphaNumericString(4), null, LocalDate.now(), prods));
	}

	@Test
	public void CreateFile_ExpectedTrue(){
		FileTests teste = new FileTests();
		assertTrue(teste.CreateFile());
	}

	@Test
	public void CreateFileWithNewPath_ExpectedTrue(){
		FileTests teste = new FileTests();
		assertTrue(teste.CreateFile("outatjava.txt"));
	}

	@Test
	public void WriteInFile_ExpectedTrue(){
		FileTests teste = new FileTests();
		assertTrue(teste.WriteInFile("Testando 1,2,3"));
		
	}

	@Test
	public void ReadFile_ExpectedToWork(){
		FileTests teste = new FileTests();
		assertSame("Arquivo lido com sucesso!", teste.ReadFile());
	}

	@Test
	public void WriteCompraAndInstrumentoInFile_ExpectedTrue(){
		
		FileTests teste = new FileTests();
		UtilityClass utility = new UtilityClass();
		List<Instrumento> prods = new ArrayList<Instrumento>();
		prods = utility.CreateExampleProductsList();

		try {
			Responsavel responsavel = new Responsavel("Marco Antonio", "123456789", "marco@marco.com");
			
			Compra compra = new Compra(UtilityClass.getAlphaNumericString(4), responsavel, LocalDate.now(), prods);
			
			assertTrue(teste.WriteInFile("Compra" + ";" + compra.getCodCompra() + ";" + responsavel.getNome() + ";" + 
			responsavel.getCpf() + ";" + responsavel.getEmail() + ";" + compra.getDataCompra()));

			for (Instrumento instrumento : prods) {

				char Tipo = utility.checkInstrumento(instrumento);

				if(Tipo == 'P')
				{
					Percurssao perc = (Percurssao) instrumento;
					assertTrue(teste.WriteInFile(Tipo + ";" + perc.getNome() + ";" + perc.getTipo()
				+ ";" + perc.getPreco() + ";" + perc.isCapacidadeAfinacao() + ";" + perc.getProducaoSom()));

				}

				if(Tipo == 'S')
				{
					Sopro sopro = (Sopro) instrumento;
					assertTrue(teste.WriteInFile(Tipo + ";" + sopro.getNome() + ";" + sopro.getTipo()
				+ ";" + sopro.getPreco() + ";" + sopro.getMaterial() + ";" + sopro.getClassificacao()));

				}

				if(Tipo == 'C')
				{
					Corda corda = (Corda) instrumento;
					assertTrue(teste.WriteInFile(Tipo + ";" + corda.getNome() + ";" + corda.getTipo()
				+ ";" + corda.getPreco() + ";" + corda.getNumCordas()));

				}
			}
		} 
		catch(Exception ex){
            System.out.println(ex + " Exceção encontrada em AtJavaApplicationTests.java");
			fail();
        }
		
		
	}

	//Teste suposto a dar errado por falta de informações ao criar a Compra.
	@Test
	public void WriteCompraAndInstrumentoInFile_ExpectedFail(){
		FileTests teste = new FileTests();
		UtilityClass utility = new UtilityClass();
		List<Instrumento> prods = new ArrayList<Instrumento>();
		prods = utility.CreateExampleProductsList();
		try {

			Compra compra = new Compra(UtilityClass.getAlphaNumericString(4), null, LocalDate.now(), prods);
			
			assertTrue(teste.WriteInFile("Compra" + ";" + compra.getCodCompra() + ";" + compra.getResponsavel() + ";"
			+ compra.getDataCompra()));

			for (Instrumento instrumento : prods) {

				char Tipo = utility.checkInstrumento(instrumento);

				if(Tipo == 'P')
				{
					Percurssao perc = (Percurssao) instrumento;
					assertTrue(teste.WriteInFile(Tipo + ";" + perc.getNome() + ";" + perc.getTipo()
				+ ";" + perc.getPreco() + ";" + perc.isCapacidadeAfinacao() + ";" + perc.getProducaoSom()));
				}

				if(Tipo == 'S')
				{
					Sopro sopro = (Sopro) instrumento;
					assertTrue(teste.WriteInFile(Tipo + ";" + sopro.getNome() + ";" + sopro.getTipo()
				+ ";" + sopro.getPreco() + ";" + sopro.getMaterial() + ";" + sopro.getClassificacao()));
				}

				if(Tipo == 'C')
				{
					Corda corda = (Corda) instrumento;
					assertTrue(teste.WriteInFile(Tipo + ";" + corda.getNome() + ";" + corda.getTipo()
				+ ";" + corda.getPreco() + ";" + corda.getNumCordas()));
				}
			
			}
			
		} 
		catch(Exception ex){
            System.out.println(ex + " Exceção encontrada em AtJavaApplicationTests.java");
			fail();
        }
		
		
	}

}
