package main.java.ar.edu.utn.frba.ia.tp;

import java.util.logging.Logger;

import main.java.ar.edu.utn.frba.ia.ag.AlgoritmoGenetico;
import main.java.ar.edu.utn.frba.ia.ag.Configuracion;
import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class AlgoritmoGeneticoTP extends AlgoritmoGenetico {

	public AlgoritmoGeneticoTP(Configuracion configuracion, Class<? extends Individuo> individuoClass) {
		super(configuracion,individuoClass);
	}
	
	@Override
	protected void generarPoblacionInicial(Class<? extends Individuo> individuoClass) {
		
		for (int i = 0; i < this.configuracion.getPoblacionInicial(); i++) {
			try {
				this.agregarIndividuo(individuoClass.newInstance().generarRandom());
			} catch (Exception e) {
				Logger.getLogger(
					Logger.GLOBAL_LOGGER_NAME).severe(
						"No se puede crear una instancia de "
						+ individuoClass.getName()
						+ ". Probablemente no tenga un constructor vacio."
						+ " // CAUSA: " + e);
			}
		}
	}
}
