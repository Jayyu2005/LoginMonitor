import java.util.HashMap;
import java.util.Map;

public class Monitor {
	private String password;
	private String username;
	static Map<String, String> map = new HashMap<>();
	private final static int attempts = 6;
	
	Monitor()
	{
		
	}
	
	
	public void setacc(String username, String password)
	{
		map.put(username, password);
	}

	public int getAttempts()
	{
		return attempts;
	}
	
	
}
