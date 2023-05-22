public class Vehicle
{
	private int id;
	private String make;
	private String model;
	private doulbe price;

	public Vehicle(int id, String make, String model, double price)
	{
		this.id = id;
		this.make = make;
		this.model = model;
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
}