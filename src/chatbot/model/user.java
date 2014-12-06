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
	private boolean isCool;
	private String hobbies;
	private String believesInDent;
	
	/**
	 * The characteristics to ask the user about
	 * @param name
	 * @param age
	 * @param iscool
	 * @param hobbies
	 * @param believesInDent
	 */
	public user(String name, int age, boolean iscool, String hobbies, String believesInDent)
	{
		this.name = "";
		this.age = -999;
		this.isCool = false;
		this.hobbies = "";
		this.believesInDent = "";
	}

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


