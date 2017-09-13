package ar.edu.unlam.tallerweb1;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.modelo.Barrio;
import ar.edu.unlam.tallerweb1.modelo.Direccion;
import ar.edu.unlam.tallerweb1.modelo.Farmacia;

public class FarmaciaTest extends SpringTest {
	@Test
	@Transactional
	@Rollback (true)
	public void testQueBuscaLasFarmaciasDeTurnoDiaMartes () {
		Farmacia farmacity = new Farmacia ("Farmacity", "Martes");
		getSession().save(farmacity);
		Farmacia farmaciaDelOeste = new Farmacia ("Farmacia del Oeste", "Jueves");
		getSession().save(farmaciaDelOeste);
		Farmacia farmaciaArieta = new Farmacia ("Farmacia Arieta", "Martes");
		getSession().save(farmaciaArieta);
		Farmacia farmaciaAzul = new Farmacia ("Farmacia Azul", "Viernes");
		getSession().save(farmaciaAzul);
		
		List<Farmacia> resultado = getSession().createCriteria(Farmacia.class)
				.add(Restrictions.eq("diaDeTurno", "Martes"))
				.list();
		
		assertThat(resultado).hasSize(2);
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaLasFarmaciasDeUnaCalle(){
		Direccion calleSuipacha = new Direccion();
		calleSuipacha.setCalle("Suipacha");
		getSession().save(calleSuipacha);
		
		Direccion calleArieta = new Direccion();
		calleArieta.setCalle("Arieta");
		getSession().save(calleArieta);
		
		Farmacia farmacity = new Farmacia ("Farmacity", "Martes");
		farmacity.setDireccion(calleSuipacha);
		getSession().save(farmacity);
		
		Farmacia farmaciaDelOeste = new Farmacia ("Farmacia del Oeste", "Jueves");
		farmaciaDelOeste.setDireccion(calleSuipacha);
		getSession().save(farmaciaDelOeste);
		
		Farmacia farmaciaArieta = new Farmacia ("Farmacia Arieta", "Martes");
		farmaciaArieta.setDireccion(calleArieta);
		getSession().save(farmaciaArieta);
		
		Farmacia farmaciaAzul = new Farmacia ("Farmacia Azul", "Viernes");
		farmaciaAzul.setDireccion(calleSuipacha);
		getSession().save(farmaciaAzul);
		
		List<Farmacia> resultado = getSession().createCriteria(Farmacia.class)
				.add(Restrictions.eq("direccion", calleSuipacha))
				.list();
		
		assertThat(resultado).hasSize(3);
		
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testQueBuscaLasFarmaciasDeUnBarrio(){
		Barrio villaLuro = new Barrio();
		villaLuro.setNombre("Villa Luro");
		getSession().save(villaLuro);
		
		Barrio villaLuzuriaga = new Barrio();
		villaLuzuriaga.setNombre("Villa Luzuriaga");
		getSession().save(villaLuzuriaga);
		
		Barrio caballito = new Barrio();
		caballito.setNombre("Caballito");
		getSession().save(caballito);
		
		Direccion calleSuipacha = new Direccion();
		calleSuipacha.setCalle("Suipacha");
		calleSuipacha.setBarrio(villaLuro);
		getSession().save(calleSuipacha);
		
		Direccion calleArieta = new Direccion();
		calleArieta.setCalle("Arieta");
		calleArieta.setBarrio(villaLuzuriaga);
		getSession().save(calleArieta);
		
		Direccion donBosco = new Direccion();
		donBosco.setCalle("Don Bosco");
		donBosco.setBarrio(caballito);
		getSession().save(donBosco);
		
		Farmacia farmacity = new Farmacia ("Farmacity", "Martes");
		farmacity.setDireccion(calleSuipacha);
		getSession().save(farmacity);
		
		Farmacia farmaciaDelOeste = new Farmacia ("Farmacia del Oeste", "Jueves");
		farmaciaDelOeste.setDireccion(calleSuipacha);
		getSession().save(farmaciaDelOeste);
		
		Farmacia farmaciaArieta = new Farmacia ("Farmacia Arieta", "Martes");
		farmaciaArieta.setDireccion(calleArieta);
		getSession().save(farmaciaArieta);
		
		Farmacia farmaciaAzul = new Farmacia ("Farmacia Azul", "Viernes");
		farmaciaAzul.setDireccion(calleSuipacha);
		getSession().save(farmaciaAzul);
		
		List<Farmacia> resultado = getSession().createCriteria(Farmacia.class)
				.createAlias("direccion", "farmaDir")
				.add(Restrictions.eq("farmaDir.barrio", villaLuzuriaga))
				.list();
		
		assertThat(resultado).hasSize(1);
		
	}
}
