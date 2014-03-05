package dominio;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AlocacaoId
 *
 */
@Embeddable

public class AlocacaoId implements Serializable {
	
	private Long emp_id;
	
	private Integer dept_id;
	
	private Integer proj_seq;
	
	private static final long serialVersionUID = 1L;

	public AlocacaoId() {
		super();
	}
	
	public AlocacaoId(Long emp_id, Integer dept_id, Integer proj_seq){
		this.emp_id = emp_id;
		this.dept_id = dept_id;
		this.proj_seq = proj_seq;
	}

	public Long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(Long emp_id) {
		this.emp_id = emp_id;
	}

	public Integer getDept_id() {
		return dept_id;
	}

	public void setDept_id(Integer dept_id) {
		this.dept_id = dept_id;
	}

	public Integer getProj_seq() {
		return proj_seq;
	}

	public void setProj_seq(Integer proj_seq) {
		this.proj_seq = proj_seq;
	}

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
   
}
