package hackerRankJavaTest;

interface Syrupable {
	void getSugary();
}

abstract class Pancake implements Syrupable { }

class BlueberryPancake implements Pancake {
	public void getSugary() {;}
}

class SourdoughBBP extends BlueberryPancake {
	void getSugary(int s) {;}
}
