

public class ClearingHouseDetailsBean {

	private String username;
	private String password;
	private String env;
	private String epurl;
	
	
	public void setUserName(String string) {
		username = string;
		
	}

	public void setPassword(String string) {
		password = string;
		
	}

	public void setEnvironmentType(String string) {
		env = string;
		
	}

	public void setEndPointURL(String string) {
		epurl = string;
		
	}

	public String getEnvironmentType() {
		return env;
	}

	public String getUserName() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEndPointURL() {
		return epurl;
	}

}
