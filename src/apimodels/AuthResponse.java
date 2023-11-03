package apimodels;

//import java.util.List;

/**
 * Contains the new authentication token and Bob's public key information.
 */
public class AuthResponse {

	private AuthHeader authenticationData = null;
	private byte[] bobIdentityKey = null;
	private byte[] bobPreKey = null;
	private byte[] bobOneTimePreKey = null;

	/**
	 * Get authenticationData
	 * 
	 * @return authenticationData
	 **/
	public AuthResponse authenticationData(AuthHeader authenticationData) {
		this.authenticationData = authenticationData;
		return this;
	}

	public AuthHeader getAuthenticationData() {
		return authenticationData;
	}

	public void setAuthenticationData(AuthHeader authenticationData) {
		this.authenticationData = authenticationData;
	}

	/**
	 * Bob's public identity key.
	 * 
	 * @return bobIdentityKey
	 **/
	public AuthResponse bobIdentityKey(byte[] bobIdentityKey) {
		this.bobIdentityKey = bobIdentityKey;
		return this;
	}

	public byte[] getBobIdentityKey() {
		return bobIdentityKey;
	}

	public void setBobIdentityKey(byte[] bobIdentityKey) {
		this.bobIdentityKey = bobIdentityKey;
	}

	/**
	 * Bob's public pre key.
	 * 
	 * @return bobPreKey
	 **/
	public AuthResponse bobPreKey(byte[] bobPreKey) {
		this.bobPreKey = bobPreKey;
		return this;
	}

	public byte[] getBobPreKey() {
		return bobPreKey;
	}

	public void setBobPreKey(byte[] bobPreKey) {
		this.bobPreKey = bobPreKey;
	}

	/**
	 * Bob's public one-time pre key.
	 * 
	 * @return bobOneTimePreKey
	 **/
	public AuthResponse bobOneTimePreKey(byte[] bobOneTimePreKey) {
		this.bobOneTimePreKey = bobOneTimePreKey;
		return this;
	}

	public byte[] getBobOneTimePreKey() {
		return bobOneTimePreKey;
	}

	public void setBobOneTimePreKey(byte[] bobOneTimePreKey) {
		this.bobOneTimePreKey = bobOneTimePreKey;
	}

}
