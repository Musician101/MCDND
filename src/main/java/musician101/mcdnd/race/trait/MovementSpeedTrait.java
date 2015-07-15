package musician101.mcdnd.race.trait;

public class MovementSpeedTrait extends SingleValueTrait<Integer>
{
	public MovementSpeedTrait()
	{
		this(30);
	}
	
	public MovementSpeedTrait(int speed)
	{
		super("Speed", speed, "Your movement speed is " + speed + " feet.");
	}
}
