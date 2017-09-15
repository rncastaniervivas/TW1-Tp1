package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Barrio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idBarrio;
	private String nombre;
	
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

	
}
