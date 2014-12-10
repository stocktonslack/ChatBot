package chatbot.model;

/**
 * A few things about the user
 * @author ssla9721
 *
 */
public class User
{
	/**
	 * The name of the user
	 */
	private String name;
	
	/**
	 * the age of the user.
	 */
	private int age;
	
	/**
	 * Whether or not the user is cool.
	 */
	private boolean isCool;
	
	/**
	 * The hobbies of the user.
	 */
	private String hobbies;
	
	/**
	 * Whether or not the user believes in Harvey Dent!
	 */
	private String believesInDent;
	
	
	public User()
	{
		
	}
	
	/**
	 * The characteristics to ask the user about
	 * @param name
	 * @param age
	 * @param iscool
	 * @param hobbies
	 * @param believesInDent
	 */
	public User(String name, int age, boolean iscool, String hobbies, String believesInDent)
	{
		this.name = "";
		this.age = -999;
		this.isCool = false;
		this.hobbies = "";
		this.believesInDent = "";
	}

	/**
	 * The getters and setters
	 * @return
	 */
	
	public String getName() 
	{
		return name;
	}

	public int getAge() 
	{
		return age;
	}

	public boolean getIsCool() 
	{
		return isCool;
	}

	public String getHobbies() 
	{
		return hobbies;
	}

	public String getBelievesInDent() 
	{
		return believesInDent;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public void setAge(int age) 
	{
		this.age = age;
	}

	public void setIscool(boolean iscool) 
	{
		this.isCool = iscool;
	}

	public void setHobbies(String hobbies) 
	{
		this.hobbies = hobbies;
	}

	public void setBelievesInDent(String believesInDent) 
	{
		this.believesInDent = believesInDent;
	}
}


