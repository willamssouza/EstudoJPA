package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Alocacao
 *
 */
@Entity

public class Alocacao implements Serializable {
	
	@EmbeddedId
	private AlocacaoId id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_inicio")
	private Date dtAlocacao;
	
	@ManyToOne
	@JoinColumn(name="emp_id", referencedColumnName="id", insertable=false, updatable=false)
	private Empregado empregado;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="dept_id", referencedColumnName="dept_id", insertable=false, updatable=false),
		@JoinColumn(name="proj_seq", referencedColumnName="seq", insertable=false, updatable=false)
	})
	private Projeto projeto;
	
	
	private static final long serialVersionUID = 1L;

	public Alocacao() {
		super();
	}   
	public Date getDtAlocacao() {
		return this.dtAlocacao;
	}

	public void setDtAlocacao(Date dtAlocacao) {
		this.dtAlocacao = dtAlocacao;
	}
	public AlocacaoId getId() {
		return id;
	}
	public void setId(AlocacaoId id) {
		this.id = id;
	}
	public Empregado getEmpregado() {
		return empregado;
	}
	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
	public Projeto getProjeto() {
		return projeto;
	}
	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
   
}
