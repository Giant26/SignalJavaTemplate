package apimodels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Request for debug info.
 */
public class DebugRequest {

	private AuthHeader authHeader = null;

	public DebugRequest authHeader(AuthHeader authHeader) {
		this.authHeader = authHeader;
		return this;
	}

	/**
	 * Get authHeader
	 * 
	 * @return authHeader
	 **/
	public AuthHeader getAuthHeader() {
		return authHeader;
	}

	public void setAuthHeader(AuthHeader authHeader) {
		this.authHeader = authHeader;
	}
	
	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		return "";
	}
	
}
