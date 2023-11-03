package apimodels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * A message from Bob.
 */
public class MessageResponse {

	private byte[] newRatchetPublicKey = null;
	private byte[] messageNonce = null;
	private byte[] messageEncrypted = null;

	public MessageResponse newRatchetPublicKey(byte[] newRatchetPublicKey) {
		this.newRatchetPublicKey = newRatchetPublicKey;
		return this;
	}

	/**
	 * Bob's new public key for the DH ratchet. If this is 'null', the existing key
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

	public MessageResponse messageNonce(byte[] messageNonce) {
		this.messageNonce = messageNonce;
		return this;
	}

	/**
	 * The GCM nonce of the message from Bob.
	 * 
	 * @return messageNonce
	 **/
	public byte[] getMessageNonce() {
		return messageNonce;
	}

	public void setMessageNonce(byte[] messageNonce) {
		this.messageNonce = messageNonce;
	}

	public MessageResponse messageEncrypted(byte[] messageEncrypted) {
		this.messageEncrypted = messageEncrypted;
		return this;
	}

	/**
	 * The message from Bob.
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
