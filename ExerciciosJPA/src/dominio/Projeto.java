package dominio;

import java.io.Serializable;
import java.lang.String;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Projeto
 *
 */
@Entity

public class Projeto implements Serializable {

	
	@EmbeddedId
	private ProjetoId id;

	@Column(length=20)
	private String titulo;
	
	@Column(length=20)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="dept_id", insertable = false, updatable = false)
	private Departamento departamento;
	
	@ManyToMany(mappedBy="projetos")
	private Collection<Empregado> equipe;
	
	@OneToMany(mappedBy="projeto")
	private Collection<Alocacao> alocacoes;
	
	
	@ManyToOne
	@JoinColumns( {
			@JoinColumn(name="proj_global_id", referencedColumnName="dept_id"), 
			@JoinColumn(name="proj_global_seq", referencedColumnName="seq")})
	private Projeto projetoGlobal;
	
	@OneToMany(mappedBy="projetoGlobal")
	private Collection<Projeto> subProjetos;
	
	
	private static final long serialVersionUID = 1L;
	

	public Projeto() {
		super();
	}   

	public ProjetoId getId() {
		return id;
	}

	public void setId(ProjetoId id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public Collection<Empregado> getEquipe() {
		return equipe;
	}

	public void setEquipe(Collection<Empregado> equipe) {
		this.equipe = equipe;
	}

	public Collection<Alocacao> getAlocacoes() {
		return alocacoes;
	}

	public void setAlocacoes(Collection<Alocacao> alocacoes) {
		this.alocacoes = alocacoes;
	}

	public Projeto getProjetoGlobal() {
		return projetoGlobal;
	}

	public void setProjetoGlobal(Projeto projetoGlobal) {
		this.projetoGlobal = projetoGlobal;
	}

	public Collection<Projeto> getSubProjetos() {
		return subProjetos;
	}

	public void setSubProjetos(Collection<Projeto> subProjetos) {
		this.subProjetos = subProjetos;
	}

   
}
