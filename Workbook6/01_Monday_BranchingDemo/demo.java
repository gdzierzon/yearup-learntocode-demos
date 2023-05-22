public class Truck
{
	private int id;
	private String make;
	private String model;
	private int miles;

	public Truck(int id, String make, String model, int miles)
	{
		this.id = id;
		this.make = make;
		this.model = model;
		this.miles = miles;
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