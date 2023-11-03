package apimodels;

/**
 * Contains authentication data.
 */
public class AuthHeader {

	private String authenticationToken = null;

	public AuthHeader authenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
		return this;
	}

	/**
	 * The authentication token returned by the /api/auth endpoint.
	 * 
	 * @return authenticationToken
	 **/
	public String getAuthenticationToken() {
		return authenticationToken;
	}

	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}

}
