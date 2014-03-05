package dominio;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Departamento
 *
 */
@Entity

public class Departamento implements Serializable {

	   
	@Id
	private Integer id;
	
	@Column(length=20)
	private String nome;
	
	@Column(length=8)
	private String sigla;
	
	@OneToMany(mappedBy="departamento")
	private Collection<Empregado> empregados;
	
	@OneToMany(mappedBy="departamento")
	private Collection<Projeto> projetos;
	
	@ManyToOne
	@JoinColumn(name="dept_sup_id")
	private Departamento deptSuperior;
	
	@OneToMany(mappedBy="deptSuperior")
	private Collection<Departamento> subordinados;
	
	@ManyToMany(mappedBy="departamentos")
	private Collection<Veiculo> veiculos;
	
	
	private static final long serialVersionUID = 1L;

	public Departamento() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	public Collection<Empregado> getEmpregados() {
		return empregados;
	}
	public void setEmpregados(Collection<Empregado> empregados) {
		this.empregados = empregados;
	}
	
	public Collection<Projeto> getProjetos() {
		return projetos;
	}
	public void setProjetos(Collection<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	public Departamento getDeptSuperior() {
		return deptSuperior;
	}
	public void setDeptSuperior(Departamento deptSuperior) {
		this.deptSuperior = deptSuperior;
	}
	public Collection<Departamento> getSubordinados() {
		return subordinados;
	}
	public void setSubordinados(Collection<Departamento> subordinados) {
		this.subordinados = subordinados;
	}
	public Collection<Veiculo> getVeiculos() {
		return veiculos;
	}
	public void setVeiculos(Collection<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}
	public void addEmpregado(Empregado empregado){
		if (getEmpregados() == null){
			setEmpregados(new ArrayList<Empregado>());
		}
		getEmpregados().add(empregado);
	}
	public void addVeiculo(Veiculo veiculo){
		if (getVeiculos() == null){
			setVeiculos(new ArrayList<Veiculo>());
		}
		getVeiculos().add(veiculo);
	}
   
}
