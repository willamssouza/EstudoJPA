package dominio;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Estacionamento
 *
 */
@Entity

public class Estacionamento implements Serializable {
	
	@Id
	@OneToOne
	@PrimaryKeyJoinColumn
	private Empregado empregado;

	private Integer noVaga;
	
	@Column(length=20)
	private String localizacao;
	
	
	private static final long serialVersionUID = 1L;

	public Estacionamento() {
		super();
	}
	
	public Estacionamento(Empregado empregado){
		this.empregado = empregado;
	}
	
	public Integer getNoVaga() {
		return this.noVaga;
	}

	public void setNoVaga(Integer noVaga) {
		this.noVaga = noVaga;
	}   
	public String getLocalizacao() {
		return this.localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
   
}
