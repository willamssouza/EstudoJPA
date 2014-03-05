package dominio;

import dominio.Empregado;
import java.io.Serializable;
import java.lang.Double;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Contratado
 *
 */
@Entity
@DiscriminatorValue("C")

public class Contratado extends Empregado implements Serializable {

	
	private Double custoHora;
	private static final long serialVersionUID = 1L;

	public Contratado() {
		super();
	}   
	
	public Contratado(String nome, Sexo sexo, Double custoHora){
		super();
		setNome(nome);
		setSexo(sexo);
		this.custoHora = custoHora;
	}
	
	public Double getCustoHora() {
		return this.custoHora;
	}

	public void setCustoHora(Double custoHora) {
		this.custoHora = custoHora;
	}
   
}
