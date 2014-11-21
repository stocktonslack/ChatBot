package chatbot.model;

/**
 * A few things about the user
 * @author ssla9721
 *
 */
public class user
{
	private String name;
	private int age;
	private boolean iscool;
	private String hobbies;
	
	/**
	 * The characteristics to ask the user about
	 * @param name
	 * @param age
	 * @param iscool
	 * @param hobbies
	 */
	public user(String name, int age, boolean iscool, String hobbies)
	{
		this.name = "";
		this.age = 999;
		this.iscool = true;
		this.hobbies = "";
	}
}


