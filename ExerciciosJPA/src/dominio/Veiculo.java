package dominio;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

/*
 * Entity implementation class for Entity: Veiculo
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="tpVeiculo", discriminatorType=DiscriminatorType.CHAR)

public abstract class Veiculo implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "Veic_gen")
	@SequenceGenerator(name = "Veic_gen", sequenceName="veic_seq")
	private Integer id;
	
	private String descricao;
	
	private Integer capacidade;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="Dept_Veic", joinColumns= 
									@JoinColumn(name="Veic_id", referencedColumnName="id"), 
								 inverseJoinColumns=
								    @JoinColumn(name="Dept_id", referencedColumnName="id"))
	private Collection<Departamento> departamentos;
	
	private static final long serialVersionUID = 1L;

	public Veiculo() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public Integer getCapacidade() {
		return this.capacidade;
	}

	public void setCapacidade(Integer capacidade) {
		this.capacidade = capacidade;
	}
	public Collection<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(Collection<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	
	public void addDepartamento(Departamento departamento){
		if (getDepartamentos() == null){
			setDepartamentos( new ArrayList<Departamento>());
		}
		getDepartamentos().add(departamento);
	}
   
}
