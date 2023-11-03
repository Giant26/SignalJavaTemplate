package apimodels;

/**
 * Contains meta data for a new session.
 */
public class AuthRequest {

	private String name = null;

	public AuthRequest name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Name of the connecting student.
	 * 
	 * @return name
	 **/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
