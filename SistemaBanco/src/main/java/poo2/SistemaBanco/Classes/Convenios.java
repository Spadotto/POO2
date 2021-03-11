package poo2.SistemaBanco.Classes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Convenios {
	
	@Id
	private String convenio;
	
	public Convenios(String convenio) {
		super();
		this.convenio = convenio;
	}
	
	public Convenios() {
		
	}

	public String getConvenio() {
		return convenio;
	}

	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((convenio == null) ? 0 : convenio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Convenios other = (Convenios) obj;
		if (convenio == null) {
			if (other.convenio != null)
				return false;
		} else if (!convenio.equals(other.convenio))
			return false;
		return true;
	}

}
