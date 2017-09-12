package ar.edu.unlam.tallerweb1.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Barrio {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idBarrio;
	private String nombre;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "comuna-barrio", joinColumns = { @JoinColumn(name = "idBarrio") }, inverseJoinColumns = { @JoinColumn(name = "idComuna") })
	private Set<Comuna> comuna = new HashSet<Comuna>(0);
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Long getIdBarrio() {
		return idBarrio;
	}
	public void setIdBarrio(Long idBarrio) {
		this.idBarrio = idBarrio;
	}
	public Set<Comuna> getComuna() {
		return comuna;
	}
	public void setComuna(Set<Comuna> comuna) {
		this.comuna = comuna;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comuna == null) ? 0 : comuna.hashCode());
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
		Barrio other = (Barrio) obj;
		if (comuna == null) {
			if (other.comuna != null)
				return false;
		} else if (!comuna.equals(other.comuna))
			return false;
		return true;
	}
}
