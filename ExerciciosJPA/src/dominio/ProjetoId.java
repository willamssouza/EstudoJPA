package dominio;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProjetoId
 *
 */
@Embeddable

public class ProjetoId implements Serializable {
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Column(name="dept_id")
	private Integer idDepartamento;
	
	private Integer seq;
	
	
	
	private static final long serialVersionUID = 1L;

	public ProjetoId() {
		super();
	}
	
	public ProjetoId(Integer dep, Integer seq){
		this.idDepartamento = dep;
		this.seq = seq;
	}

	public Integer getDepartamento() {
		return idDepartamento;
	}

	public void setDepartamento(Integer departamento) {
		this.idDepartamento = departamento;
	}

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

   
}
