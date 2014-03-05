package dominio;

import dominio.Veiculo;
import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Terrestre
 *
 */
@Entity
@Table(name="Veic_Terreste")
@DiscriminatorValue("T")

public class Terrestre extends Veiculo implements Serializable {

	
	private String placa;
	private static final long serialVersionUID = 1L;

	public Terrestre() {
		super();
	}   
	
	public Terrestre(String descricao, Integer capacidade, String placa){
		super();
		setDescricao(descricao);
		setCapacidade(capacidade);
		this.placa = placa;
	}
	
	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
   
}
