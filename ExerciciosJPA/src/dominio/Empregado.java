package dominio;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

/**
 * Entity implementation class for Entity: Empregado
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="tpEmprepgado", discriminatorType=DiscriminatorType.CHAR)

public abstract class Empregado implements Serializable {
   
	@Id
	@GeneratedValue(strategy = SEQUENCE, generator="Emp_gen")
	@SequenceGenerator(name = "Emp_gen", sequenceName = "emp_seq")
	private Long id;
	
	@Column(length=20, nullable=false)
	private String nome;
	
	@Enumerated(EnumType.STRING)
	@Column(length=10)
	private Sexo sexo;
	
	@Embedded
	private Endereco endereco;
	
	@OneToOne(mappedBy="empregado")
	private Estacionamento estacionamento;
	
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Departamento departamento;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="EMP_PROJ", 
				joinColumns = @JoinColumn(name="Emp_id", referencedColumnName="id"),
				inverseJoinColumns = { 
						@JoinColumn(name="Proj_seq", referencedColumnName="seq"),
						@JoinColumn(name="Dept_id", referencedColumnName="dept_id")
	})
	private Collection<Projeto> projetos;
	
	@OneToMany(mappedBy="empregado")
	private Collection<Alocacao> alocacoes;
	
	private static final long serialVersionUID = 1L;

	//Construtores
	public Empregado() {
		super();
	}
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Estacionamento getEstacionamento() {
		return estacionamento;
	}

	public void setEstacionamento(Estacionamento estacionamento) {
		this.estacionamento = estacionamento;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Collection<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(Collection<Projeto> projetos) {
		this.projetos = projetos;
	}

	public Collection<Alocacao> getAlocacoes() {
		return alocacoes;
	}

	public void setAlocacoes(Collection<Alocacao> alocacoes) {
		this.alocacoes = alocacoes;
	}
   
}
