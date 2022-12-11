package Service;

import Motocycle.Motorcycle;

import java.util.Comparator;

public class ManufactureYearComparator implements Comparator<Motorcycle> {

	@Override
	public int compare(Motorcycle o1, Motorcycle o2){
		return o1.getManufactureYear()-o2.getManufactureYear();
	}
}
