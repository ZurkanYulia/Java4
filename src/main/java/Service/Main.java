package Service;

import Motocycle.Garage;
import Motocycle.Motorcycle;
import Motocycle.TransmissionType;

import java.util.List;

public class Main {
	public static void main(String[] args){
		Motorcycle moto1 = new Motorcycle.Builder( "BMW G 310 R",
				"AT1234AA",
				313,
				TransmissionType.MANUAL,
				2017,
				"Roman Mel'nyk")
				.setColor("red")
				.buidl();
		try{
			Validator validator = new Validator() ;
			validator.valid(moto1);
		}catch(RuntimeException e){
			System.out.println(e);
		}
	}
}
