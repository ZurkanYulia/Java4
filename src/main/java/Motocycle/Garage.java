package Motocycle;

import java.util.ArrayList;
import java.util.List;

public class Garage {
	private List<Motorcycle> motorcycleList;

	public Garage(){
		motorcycleList = new ArrayList<>();
	}

	public List<Motorcycle> getMotorcycleList(){
		return motorcycleList;
	}

	public void addMotorcycle(Motorcycle car){
		motorcycleList.add(car);
	}
}