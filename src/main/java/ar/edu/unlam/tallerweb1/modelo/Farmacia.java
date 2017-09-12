package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

public class Farmacia {
	private Long id;
	private String nombre;
	private String telefono;
	private String diaDeTurno;
	@ManyToOne(fetch = FetchType.LAZY)
	private Direccion direccion;
	@ManyToOne(fetch = FetchType.LAZY)
	private Punto geoLocalizacion;
	
//	A que se refieren los dos String que se pasan por parametro?
//	Cual de los tres String usamos??
//	public Farmacia(String, String){	
//	}
	
	public Farmacia(){
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public Punto getGeoLocalizacion() {
		return geoLocalizacion;
	}
	public void setGeoLocalizacion(Punto geoLocalizacion) {
		this.geoLocalizacion = geoLocalizacion;
	}
	public String getDiaDeTurno() {
		return diaDeTurno;
	}
	public void setDiaDeTurno(String diaDeTurno) {
		this.diaDeTurno = diaDeTurno;
	}
	
}