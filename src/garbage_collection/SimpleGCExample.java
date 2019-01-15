package garbage_collection;

public class SimpleGCExample {
	private int data;
	
	public SimpleGCExample() {
		this.setData(0);
		System.out.println("Test object created");
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleGCExample t1 = new SimpleGCExample();
		t1.setData(2);
		t1 = null;
		System.gc();
		SimpleGCExample t2 = new SimpleGCExample();
		t2.setData(3);
		t2 = null;
		Runtime.getRuntime().gc();
		
	}
	
	@Override
	protected void finalize() {
		System.out.println("Garbage collector called");
	}

}
