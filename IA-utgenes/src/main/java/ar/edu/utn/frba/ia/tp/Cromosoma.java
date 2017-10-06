package main.java.ar.edu.utn.frba.ia.tp;

import java.util.Stack;

import main.java.ar.edu.utn.frba.ia.ag.Individuo;

public class Cromosoma extends Individuo {
	
	private Stack<Deporte> pilaDeportes=new Stack<Cromosoma.Deporte>();
	private Stack<Apellido> pilaApellidos=new Stack<Cromosoma.Apellido>();
	private Stack<Esposa> pilaEsposas=new Stack<Cromosoma.Esposa>();
	
	public enum Apellido{
		Ortega, Lopez, Varela, Garcia
	}
	
	public enum Deporte{
		basquetbol, rugby, handbol, voleibol, natación, equitación, fútbol, tenis 
	}
	
	public enum Esposa{
		Alicia, Natalia, Carolina, Florencia
	}

	private Esposo daniel;
	private Esposo enrique;
	private Esposo martin;
	private Esposo pablo;
	
	
	private void cargarPilaDeportes(){
		while(Deporte.values().length != pilaDeportes.size()){
			Deporte element=Deporte.values()[(int) (Math.random() * Deporte.values().length)];
			if(!pilaDeportes.contains(element)){
				pilaDeportes.push(element);
			}
		}
	}
	
	private void cargarPilaApellidos(){
		while(Apellido.values().length != pilaApellidos.size()){
			Apellido element=Apellido.values()[(int) (Math.random() * Apellido.values().length)];
			if(!pilaApellidos.contains(element)){
				pilaApellidos.push(element);
			}
		}
	}
	
	private void cargarPilaEsposas(){
		while(Esposa.values().length != pilaEsposas.size()){
			Esposa element=Esposa.values()[(int) (Math.random() * Esposa.values().length)];
			if(!pilaEsposas.contains(element)){
				pilaEsposas.push(element);
			}
		}
	}	

	
	@Override
	public double aptitud() {
		return this.aptitudDaniel() + this.aptitudEnrique() + this.aptitudPablo() + this.aptitudMartin();
	}
	

	public Cromosoma() {
		this.cargarPilaEsposas();
		this.cargarPilaApellidos();
		this.cargarPilaDeportes();
		
		this.setDaniel(new Esposo(this.pilaApellidos.pop(),this.pilaDeportes.pop(),this.pilaEsposas.pop(),this.pilaDeportes.pop()));
		this.setEnrique(new Esposo(this.pilaApellidos.pop(),this.pilaDeportes.pop(),this.pilaEsposas.pop(),this.pilaDeportes.pop()));
		this.setMartin(new Esposo(this.pilaApellidos.pop(),this.pilaDeportes.pop(),this.pilaEsposas.pop(),this.pilaDeportes.pop()));
		this.setPablo(new Esposo(this.pilaApellidos.pop(),this.pilaDeportes.pop(),this.pilaEsposas.pop(),this.pilaDeportes.pop()));
		
		this.printCromosoma();
	}
	
	public void printCromosoma(){
		System.out.println("Daniel: "+this.daniel.printEsposo());
		System.out.println("Enrique: "+this.enrique.printEsposo());
		System.out.println("Martin: "+this.martin.printEsposo());
		System.out.println("Pablo: "+this.pablo.printEsposo());
		System.out.println("====================================");
	}
	
	
	private double aptitudDaniel(){
		double value=0;
		Esposo esposo = this.daniel;
		//Daniel no se apellida Ortega.
		if(!esposo.getApellido().equals(Apellido.Ortega)){
			value++;
		}else{
			value--;
		}				
		//La joven que practica natación no conoce a Daniel.
		if(!esposo.getDeporteMujer().equals(Deporte.natación)){
			value++;
		}else{
			value--;
		}
		value+=this.aptitudGeneral(esposo);
		return value;
	}
	
	private double aptitudEnrique(){
		double value=0;
		//Enrique se apellida López. 
		Esposo esposo = this.enrique;
		if(!esposo.getApellido().equals(Apellido.Lopez)){
			value++;
		}else{
			value--;
		}
		value+=this.aptitudGeneral(esposo);
		return value;
	}	
	
	private double aptitudPablo(){
		double value=0;
		//El nombre de García es Pablo.
		if(this.pablo.getApellido().equals(Apellido.Garcia)){
			value++;
		}else{
			value--;
		}		
		value+=this.aptitudGeneral(this.pablo);		
		return value;
	}	
	
	private double aptitudMartin(){
		double value=0;
		//Martín, que no practica basquetbol, no conoce a Alicia.
		if(!this.martin.getDeporteVaron().equals(Deporte.basquetbol)){
			value++;
		}else{
			value--;
		}
		//Martin no conoce a Alicia
		if(!this.martin.getEsposa().equals(Esposa.Alicia)){
			value++;
		}else{
			value--;
		}		
		//Florencia no conoce a Martín  
		if(!this.martin.getEsposa().equals(Esposa.Florencia)){
			value++;
		}else{
			value--;
		}	
		
		value+=this.aptitudGeneral(this.martin);
		return value;
	}
	
	
	private double aptitudGeneral(Esposo esposo){
		double value=0;
		//El marido de Natalia integra un equipo de rugby.
		if(esposo.getEsposa().equals(Esposa.Natalia) && esposo.getDeporteVaron().equals(Deporte.rugby)){
			value++;
		}else{
			value--;
		}
		//El que juega al handbol se apellida Varela.
		if(esposo.getDeporteVaron().equals(Deporte.handbol) && esposo.getApellido().equals(Apellido.Varela)){
			value++;
		}else{
			value--;
		}		
		//La joven que juega al voleibol no es la pareja de López. 
		if(esposo.getDeporteMujer().equals(Deporte.voleibol) && !esposo.getApellido().equals(Apellido.Lopez)){
			value++;
		}else{
			value--;
		}			
		//El esposo de Carolina no practica basquetbol ni handbol.
		if(esposo.getEsposa().equals(Esposa.Carolina) && 
			!esposo.getDeporteVaron().equals(Deporte.basquetbol) && 
			!esposo.getDeporteVaron().equals(Deporte.handbol)){
			value++;
		}else{
			value--;
		}			
		//La que practica equitación no se llama Florencia y no conoce a Varela. 
		if(esposo.getDeporteMujer().equals(Deporte.equitación) &&
			!esposo.getEsposa().equals(Esposa.Florencia) &&
			!esposo.getApellido().equals(Apellido.Varela)){
			value++;
		}else{
			value--;
		}
		//El que integra un equipo de fútbol está en pareja con la joven que juega al tenis.
		if(esposo.getDeporteVaron().equals(Deporte.fútbol) && esposo.getDeporteMujer().equals(Deporte.tenis)){
			value++;
		}else{
			value--;
		}			
		//Florencia no conoce a Varela. 
		if(esposo.getEsposa().equals(Esposa.Florencia) && 
				!esposo.getApellido().equals(Apellido.Varela)){
			value++;
		}else{
			value--;
		}
		
		//Ni López ni Ortega conocen a Natalia.
		if(esposo.getEsposa().equals(Esposa.Natalia) && 
			!esposo.getApellido().equals(Apellido.Lopez) &&
			!esposo.getApellido().equals(Apellido.Ortega)){
			value++;
		}else{
			value--;
		}		
		return value;

	}




	public Esposo getDaniel() {
		return daniel;
	}


	public void setDaniel(Esposo daniel) {
		this.daniel = daniel;
	}


	public Esposo getEnrique() {
		return enrique;
	}


	public void setEnrique(Esposo enrique) {
		this.enrique = enrique;
	}


	public Esposo getMartin() {
		return martin;
	}


	public void setMartin(Esposo martin) {
		this.martin = martin;
	}


	public Esposo getPablo() {
		return pablo;
	}


	public void setPablo(Esposo pablo) {
		this.pablo = pablo;
	}


	@Override
	public Individuo generarRandom() {
		return this.clone();
	}
	
	@Override
	public String toString() {
		return (new Double(aptitud())).toString();
	}

	public Stack<Deporte> getPilaDeportes() {
		return pilaDeportes;
	}

	public void setPilaDeportes(Stack<Deporte> pilaDeportes) {
		this.pilaDeportes = pilaDeportes;
	}

	public Stack<Apellido> getPilaApellidos() {
		return pilaApellidos;
	}

	public void setPilaApellidos(Stack<Apellido> pilaApellidos) {
		this.pilaApellidos = pilaApellidos;
	}

	public Stack<Esposa> getPilaEsposas() {
		return pilaEsposas;
	}

	public void setPilaEsposas(Stack<Esposa> pilaEsposas) {
		this.pilaEsposas = pilaEsposas;
	}
	
	
	
}
