public class Char
{
	private int id;
	private String make;
	private String model;

	public Car(int id, String make, String model)
	{
		this.id = id;
		this.make = make;
		this.model = model;
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