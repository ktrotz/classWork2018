
package classWork;

public class Generics2<T extends Number> extends Generics<T>
{
	/* Class 'Generics' is the superclass of 'Generics2' */

	
	private T zCoordinate; 
	
	//Constructor
	public Generics2(T x, T y, T z)
	{
		super(x, y); //call to 'Generics' class constructor

		zCoordinate = z;
	}

	//Set values
	public void setZ(T z)
	{
		zCoordinate = z;
	}


	//Get values
	public T getZ()
	{
		return zCoordinate;
	}

	

	//Main
	public static void main(String[] args)
	{
		// Create a Point3D object that can hold Integers.
		Generics2<Integer> point = new Generics2<>(10, 20, 30);


		System.out.println("X Coordinate: " + point.getX());
		System.out.println("Y Coordinate: " + point.getY());
		System.out.println("Z Coordinate: " + point.getZ());
	}
}

