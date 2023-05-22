
public class Vehicle
{
	private int id;
	private String make;
	private String model;
	private int miles;
	private double price;

	public Vehicle(int id, String make, String model, int miles, double price)
	{
		this.id = id;
		this.make = make;
		this.model = model;
		this.miles = miles;
		this.price = price;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getMiles()
	{
		return this.miles;
	}

	public void setMiles(int miles)
	{
		this.miles = miles;
	}
}