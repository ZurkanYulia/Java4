package Service;

import Motocycle.Garage;
import Motocycle.Motorcycle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GarageService {
	private Garage garage;
	public GarageService(Garage garage){
		this.garage=garage;
	}

	public List<Motorcycle> sortByDrivers(){
		List<Motorcycle> motorcycles = new ArrayList<>();
		motorcycles.addAll(garage.getMotorcycleList());
		Collections.sort(motorcycles);
		return motorcycles;
	}
	public List<Motorcycle> sortByManufactureYear(){
		List<Motorcycle> motorcycles = new ArrayList<>();
		motorcycles.addAll(garage.getMotorcycleList());
		Collections.sort(motorcycles,new ManufactureYearComparator());
		return motorcycles;
	}
	public boolean checkClient (String client){
		Collection<String> clients = new ArrayList<>();
		for(Motorcycle motorcycle : garage.getMotorcycleList()){
			clients.add(motorcycle.getDriver());
		}
		return clients.contains(client);
	}
}
