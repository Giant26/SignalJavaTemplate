package apimodels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import java.util.List;

/**
 * A message from Alice.
 */
public class MessageRequest {

	private AuthHeader authHeader = null;
	private byte[] newRatchetPublicKey = null;
	private byte[] messageNonce = null;
	private byte[] messageEncrypted = null;

	public MessageRequest authHeader(AuthHeader authHeader) {
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

	public MessageRequest newRatchetPublicKey(byte[] newRatchetPublicKey) {
		this.newRatchetPublicKey = newRatchetPublicKey;
		return this;
	}

	/**
	 * Alice' new public key for the DH ratchet. If this is 'null', the existing key
	 * is re-used.
	 * 
	 * @return newRatchetPublicKey
	 **/
	public byte[] getNewRatchetPublicKey() {
		return newRatchetPublicKey;
	}

	public void setNewRatchetPublicKey(byte[] newRatchetPublicKey) {
		this.newRatchetPublicKey = newRatchetPublicKey;
	}

	public MessageRequest messageNonce(byte[] messageNonce) {
		this.messageNonce = messageNonce;
		return this;
	}

	/**
	 * The GCM nonce of the message from Alice.
	 * 
	 * @return messageNonce
	 **/
	public byte[] getMessageNonce() {
		return messageNonce;
	}

	public void setMessageNonce(byte[] messageNonce) {
		this.messageNonce = messageNonce;
	}

	public MessageRequest messageEncrypted(byte[] messageEncrypted) {
		this.messageEncrypted = messageEncrypted;
		return this;
	}

	/**
	 * The message from Alice.
	 * 
	 * @return messageEncrypted
	 **/
	public byte[] getMessageEncrypted() {
		return messageEncrypted;
	}

	public void setMessageEncrypted(byte[] messageEncrypted) {
		this.messageEncrypted = messageEncrypted;
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
