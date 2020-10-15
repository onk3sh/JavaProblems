/**
 * 
 */
package design;

/**
 * @author onkesh.bansal
 *
 */
public class Vehicle {
	
	String plate;
	int spaceRequired;
	
	public String getPlate() {
		return plate;
	}
	
	public void setPlate(String licensePlate) {
		this.plate = licensePlate;
	}
	
	public int getSpaceRequired() {
		return spaceRequired;
	}
}

class TwoWheeler extends Vehicle{
	public TwoWheeler() {
		spaceRequired = 1;
	}
}

class Car extends Vehicle {
	public Car() {
		spaceRequired = 1;
	}
}

class BusTruck extends Vehicle {
	public BusTruck() {
		spaceRequired = 2;
	}
}

