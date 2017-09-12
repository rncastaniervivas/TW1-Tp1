package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comuna {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private Long idComuna;
	private String nombre;
	
	public Long getIdComuna() {
		return idComuna;
	}
	public void setIdComuna(Long idComuna) {
		this.idComuna = idComuna;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
