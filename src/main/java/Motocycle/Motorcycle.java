package Motocycle;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class Motorcycle implements Comparable<Motorcycle>{
	/**
	 * This is fields of Motorcycle class
	 */
	@NotNull(message = "Can't be a null")
	private String model;
	@Pattern(regexp = "[A-Z]{2}[0-9]{4}[A-Z]{2}", message = "Must be format 'AA0000AA' ")
	private String licensePlate;
	private String color;
	@NotNull(message = "Can't be a null")
	private double engineCapacity;
	@NotNull(message = "Can't be a null")
	private TransmissionType transmissionType;
	@Min(value = 1885, message = "Can't be lover than 1885")
	@Max(value = 2100, message = "Can't be higher than 2100")
	private int manufactureYear;
	@NotNull(message = "Can't be a null")
	private String driver;

	@Override
	public int compareTo(Motorcycle o){
		return this.driver.compareTo(o.driver);
	}

	/**
	 * there are static class Builder with which we will create instances
	 */
	public static class Builder {
		private String model;
		private String licensePlate;
		private String color = "white";
		private double engineCapacity;
		private TransmissionType transmissionType;
		private int manufactureYear;
		private String driver;

		/**
		 * @param model       is motorcycle model.
		 * @param licensePlate is motorcycle ID.
		 * @param engineCapacity is a measurement of engine displacement (in cm3).
		 * @param transmissionType is one of four different types of transmission.
		 * @param manufactureYear is year of manufacture of the motorcycle.
		 * @param driver is owner firstname and lastname.
		 */
		public Builder(String model,String licensePlate, double engineCapacity, TransmissionType transmissionType, int manufactureYear, String driver){
			this.model = model;
			this.licensePlate = licensePlate;
			this.engineCapacity = engineCapacity;
			this.transmissionType = transmissionType;
			this.manufactureYear = manufactureYear;
			this.driver = driver;
		}

		/**
		 * @param color is a color of motorcycle.
		 * @return Builder class instance.
		 */
		public Builder setColor(String color){
			this.color = color;
			return this;
		}

		/**
		 * @return instance Motorcycle class
		 */
		public Motorcycle buidl(){
			return new Motorcycle(this);
		}
	}
	public Motorcycle(Builder builder){
		model = builder.model;
		color = builder.color;
		licensePlate = builder.licensePlate;
		engineCapacity = builder.engineCapacity;
		transmissionType = builder.transmissionType;
		manufactureYear = builder.manufactureYear;
		driver = builder.driver;
	}

	public int getManufactureYear(){
		return manufactureYear;
	}

	public String getDriver(){
		return driver;
	}

	/**
	 * needs for Comparison
	 * @return integer number
	 */

	public int hashCode(){
		int hash = 7;
		hash = 31 * hash * licensePlate.hashCode();
		return hash;
	}

	/**
	 * Compare two instances
	 *
	 * @return boolean
	 */

	public boolean equals(Object obj){
		if(obj == null || obj.getClass() != this.getClass()) return false;
		else if(obj == this) return true;
		Motorcycle motorcycle = (Motorcycle) obj;
		return licensePlate == motorcycle.licensePlate || (licensePlate != null && licensePlate.equals(motorcycle.licensePlate));
	}

	/**
	 * @return instance attributes
	 */

	public String toString(){
		return "Модель: " + model + ". Колір: " + color + ". Об'єм двигуна: " + engineCapacity + "cm3. Тип трансмісії: " + transmissionType + ". Рік випуску: " + manufactureYear + ". Водій: " + driver;
	}
}
