package dominio;

import dominio.Veiculo;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Aereo
 *
 */
@Entity
@Table(name="Veic_Aereo")
@DiscriminatorValue("A")

public class Aereo extends Veiculo implements Serializable {

	
	private String registro;
	private static final long serialVersionUID = 1L;

	public Aereo() {
		super();
	}  
	
	public Aereo(String descricao, Integer capacidade, String registro){
		super();
		setDescricao(descricao);
		setCapacidade(capacidade);
		this.registro = registro;
	}
	
	public String getRegistro() {
		return this.registro;
	}

	public void setRegistro(String registro) {
		this.registro = registro;
	}
   
}
