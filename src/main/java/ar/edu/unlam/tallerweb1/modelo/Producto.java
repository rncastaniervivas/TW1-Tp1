package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Id;

public class Producto {
	@Id
	private Long id;
	private String descripcion;
	private String titulo;
	private Integer cantidad;
	

}
