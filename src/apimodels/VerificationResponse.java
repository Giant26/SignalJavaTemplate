package apimodels;

/**
 * A magic token verification response.
 */
public class VerificationResponse {

	private Boolean valid = null;
	private String content = null;

	public VerificationResponse valid(Boolean valid) {
		this.valid = valid;
		return this;
	}

	/**
	 * Tells whether the magic token is valid.
	 * 
	 * @return valid
	 **/
	public Boolean isValid() {
		return valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	public VerificationResponse content(String content) {
		this.content = content;
		return this;
	}

	/**
	 * If the magic token is valid, this contains its content.
	 * 
	 * @return content
	 **/
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
