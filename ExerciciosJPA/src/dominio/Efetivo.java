package dominio;

import dominio.Empregado;
import java.io.Serializable;
import java.lang.Double;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Efetivo
 *
 */
@Entity
@DiscriminatorValue("E")

public class Efetivo extends Empregado implements Serializable {

	
	private Double salario;
	private static final long serialVersionUID = 1L;

	public Efetivo() {
		super();
	}  
	
	public Efetivo(String nome, Sexo sexo, Double salario){
		super();
		setNome(nome);
		setSexo(sexo);
		this.salario = salario;
	}
	
	public Double getSalario() {
		return this.salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
   
}
