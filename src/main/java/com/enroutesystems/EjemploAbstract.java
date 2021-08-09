package com.enroutesystems;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EjemploAbstract {

	public static void imprimeAlgo() {
		log.info("Imprime algo");
	}
	
	
	
	private abstract class CycleVehicle {	

		public abstract int getWheelCount();
	}
	
	private class Monocycle extends CycleVehicle{

		@Override
		public int getWheelCount() {
			return 1;
		}		
	}
	
	private  class Bicycle extends CycleVehicle{

		@Override
		public int getWheelCount() {
			return 2;
		}
		
	}

	
	private void correEjemplos() {
		EjemploAbstract ea = new EjemploAbstract();
		CycleVehicle vehiculo = null;		
		vehiculo = new Bicycle();
		CycleVehicle vehicul2 = new Monocycle();
		
		
		List<CycleVehicle> someList = new ArrayList<>();
		someList.add(vehicul2);
		someList.add(vehiculo);
		
		someList.forEach(v -> {
			log.info("This vehicle has {} wheels and the class name is {}",v.getWheelCount(), v.getClass().getName());
		});
		
	}
	
	
	
	public static void main(String[] args) {
		
		EjemploAbstract.imprimeAlgo();
		EjemploAbstract ea= new EjemploAbstract();
		ea.correEjemplos();
		
		
		
	}
}

final class EsFinal {

}
