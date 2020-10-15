/**
 * 
 */
package design;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author onkesh.bansal
 *
 */
public class ParkingLotSystem implements ParkingLot{
	
	final int MAX_SPOTS = 10;
	final int MAX_LEVELS = 10;
	
	List<List<Integer>> grid;
	Queue<int[]> recentlyVacated = new LinkedList<>();
	
	public ParkingLotSystem() {
		
	}

}
