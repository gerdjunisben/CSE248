package p1;

public class Robot {
	private RobotColor rc;
	private RobotMetal rm;
	private RobotBody rb;
	
	public Robot()
	{
		rc = new RobotColor();
		rm = new RobotMetal();
		rb = new RobotBody();
	}
	
	public Robot(String metal,String color)
	{
		rm = new RobotMetal();
		rm.setMetal(metal);
		rc = new RobotColor();
		rc.setRobotColor(color);
		rb=new RobotBody();
	}
	
	public void constructRobot(String color, String metal)
	{
		System.out.println("Robot creation starts");
		rc.setRobotColor(color);
		rm.setMetal(metal);
		rb.createBody();
		System.out.println("Robot creation completed");
	}
	
	
}
