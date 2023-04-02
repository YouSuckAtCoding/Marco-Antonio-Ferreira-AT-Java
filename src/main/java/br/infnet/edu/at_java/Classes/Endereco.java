package br.infnet.edu.at_java.Classes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	private String Cep;
	private String Logradouro;
	private String Complemento;
	private String Bairro;
	private String Localidade;
	private String Uf;
	private String Ibge;
	private String Gia;
	private String Ddd;
	private String Siafi;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getCep() {
		return Cep;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public String getComplemento() {
		return Complemento;
	}

	public String getBairro() {
		return Bairro;
	}

	public String getLocalidade() {
		return Localidade;
	}

	public String getUf() {
		return Uf;
	}

	public String getIbge() {
		return Ibge;
	}

	public String getGia() {
		return Gia;
	}

	public String getDdd() {
		return Ddd;
	}

	public String getSiafi() {
		return Siafi;
	}

	// Setter Methods

	public void setCep(String Cep) {
		this.Cep = Cep;
	}

	public void setLogradouro(String Logradouro) {
		this.Logradouro = Logradouro;
	}

	public void setComplemento(String Complemento) {
		this.Complemento = Complemento;
	}

	public void setBairro(String Bairro) {
		this.Bairro = Bairro;
	}

	public void setLocalidade(String Localidade) {
		this.Localidade = Localidade;
	}

	public void setUf(String Uf) {
		this.Uf = Uf;
	}

	public void setIbge(String Ibge) {
		this.Ibge = Ibge;
	}

	public void setGia(String Gia) {
		this.Gia = Gia;
	}

	public void setDdd(String Ddd) {
		this.Ddd = Ddd;
	}

	public void setSiafi(String Siafi) {
		this.Siafi = Siafi;
	}
}
