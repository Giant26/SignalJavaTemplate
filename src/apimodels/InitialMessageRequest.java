package apimodels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * The initial message send by Alice.
 */
public class InitialMessageRequest {

	private AuthHeader authHeader = null;
	private byte[] aliceIdentityKey = null;
	private byte[] aliceEphemeralKey = null;
	private byte[] newRatchetPublicKey = null;
	private byte[] firstMessageNonce = null;
	private byte[] firstMessageEncrypted = null;

	/**
	 * Get authHeader
	 * 
	 * @return authHeader
	 **/
	public InitialMessageRequest authHeader(AuthHeader authHeader) {
		this.authHeader = authHeader;
		return this;
	}

	public AuthHeader getAuthHeader() {
		return authHeader;
	}

	public void setAuthHeader(AuthHeader authHeader) {
		this.authHeader = authHeader;
	}

	/**
	 * Alice's public identity key.
	 * 
	 * @return aliceIdentityKey
	 **/

	public InitialMessageRequest aliceIdentityKey(byte[] aliceIdentityKey) {
		this.aliceIdentityKey = aliceIdentityKey;
		return this;
	}

	public byte[] getAliceIdentityKey() {
		return aliceIdentityKey;
	}

	public void setAliceIdentityKey(byte[] aliceIdentityKey) {
		this.aliceIdentityKey = aliceIdentityKey;
	}

	/**
	 * Alice's ephemeral key.
	 * 
	 * @return aliceEphemeralKey
	 **/

	public InitialMessageRequest aliceEphemeralKey(byte[] aliceEphemeralKey) {
		this.aliceEphemeralKey = aliceEphemeralKey;
		return this;
	}

	public byte[] getAliceEphemeralKey() {
		return aliceEphemeralKey;
	}

	public void setAliceEphemeralKey(byte[] aliceEphemeralKey) {
		this.aliceEphemeralKey = aliceEphemeralKey;
	}

	public InitialMessageRequest newRatchetPublicKey(byte[] newRatchetPublicKey) {
		this.newRatchetPublicKey = newRatchetPublicKey;
		return this;
	}

	/**
	 * Alice's initial public key for the DH ratchet.
	 * 
	 * @return newRatchetPublicKey
	 **/
	public byte[] getNewRatchetPublicKey() {
		return newRatchetPublicKey;
	}

	public void setNewRatchetPublicKey(byte[] newRatchetPublicKey) {
		this.newRatchetPublicKey = newRatchetPublicKey;
	}

	public InitialMessageRequest firstMessageNonce(byte[] firstMessageNonce) {
		this.firstMessageNonce = firstMessageNonce;
		return this;
	}

	/**
	 * The GCM nonce of the first message from Alice.
	 * 
	 * @return firstMessageNonce
	 **/
	public byte[] getFirstMessageNonce() {
		return firstMessageNonce;
	}

	public void setFirstMessageNonce(byte[] firstMessageNonce) {
		this.firstMessageNonce = firstMessageNonce;
	}

	public InitialMessageRequest firstMessageEncrypted(byte[] firstMessageEncrypted) {
		this.firstMessageEncrypted = firstMessageEncrypted;
		return this;
	}

	/**
	 * The first message from Alice.
	 * 
	 * @return firstMessageEncrypted
	 **/
	public byte[] getFirstMessageEncrypted() {
		return firstMessageEncrypted;
	}

	public void setFirstMessageEncrypted(byte[] firstMessageEncrypted) {
		this.firstMessageEncrypted = firstMessageEncrypted;
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
