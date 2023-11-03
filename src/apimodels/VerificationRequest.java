package apimodels;

/**
 * A magic token verification request.
 */
public class VerificationRequest {

	private String magicToken = null;

	public VerificationRequest magicToken(String magicToken) {
		this.magicToken = magicToken;
		return this;
	}

	/**
	 * The magic token as issued by Bob.
	 * 
	 * @return magicToken
	 **/
	public String getMagicToken() {
		return magicToken;
	}

	public void setMagicToken(String magicToken) {
		this.magicToken = magicToken;
	}

}
