package dominio;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Endereco
 *
 */
@Embeddable

public class Endereco implements Serializable {

	@Column(length=20, nullable=true)
	private String rua;
	
	@Column(length=20, nullable=true)
	private String cidade;
	
	@Column(length=2, nullable=true)
	private String sgEstado;
	
	@Column(length=10, nullable=true)
	private String cep;
	

	private static final long serialVersionUID = 1L;

	
	
	public Endereco() {
		super();
	}   
	public String getRua() {
		return this.rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}   
	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}   
	public String getSgEstado() {
		return this.sgEstado;
	}

	public void setSgEstado(String sgEstado) {
		this.sgEstado = sgEstado;
	}   
	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
   
}
