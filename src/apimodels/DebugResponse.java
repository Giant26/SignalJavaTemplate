package apimodels;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DebugResponse {

	private byte[] bobIdentityKeyPublic = null;
	private byte[] bobIdentityKeyPrivate = null;
	private byte[] bobPreKeyPublic = null;
	private byte[] bobPreKeyPrivate = null;
	private byte[] bobOneTimePreKeyPublic = null;
	private byte[] bobOneTimePreKeyPrivate = null;
	private byte[] aliceIdentityKeyPublic = null;
	private byte[] dhRatchetBobKeyPrivate = null;
	private byte[] dhRatchetAliceKeyPublic = null;
	private byte[] dhRatchetNextSharedSecret = null;
	private byte[] rootRatchetCurrentKey = null;
	private byte[] rootRatchetNextKey = null;
	private byte[] rootRatchetNextGeneratedChainKey = null;
	private byte[] sendRatchetCurrentKey = null;
	private byte[] sendRatchetNextKey = null;
	private byte[] sendRatchetNextGeneratedMessageKey = null;
	private byte[] receiveRatchetCurrentKey = null;
	private byte[] receiveRatchetNextKey = null;
	private byte[] receiveRatchetNextGeneratedMessageKey = null;

	public DebugResponse bobIdentityKeyPublic(byte[] bobIdentityKeyPublic) {
		this.bobIdentityKeyPublic = bobIdentityKeyPublic;
		return this;
	}

	/**
	 * Bob's identity key (IK_B); public part.
	 * 
	 * @return bobIdentityKeyPublic
	 **/
	public byte[] getBobIdentityKeyPublic() {
		return bobIdentityKeyPublic;
	}

	public void setBobIdentityKeyPublic(byte[] bobIdentityKeyPublic) {
		this.bobIdentityKeyPublic = bobIdentityKeyPublic;
	}

	public DebugResponse bobIdentityKeyPrivate(byte[] bobIdentityKeyPrivate) {
		this.bobIdentityKeyPrivate = bobIdentityKeyPrivate;
		return this;
	}

	/**
	 * Bob's identity key (IK_B); private part.
	 * 
	 * @return bobIdentityKeyPrivate
	 **/
	public byte[] getBobIdentityKeyPrivate() {
		return bobIdentityKeyPrivate;
	}

	public void setBobIdentityKeyPrivate(byte[] bobIdentityKeyPrivate) {
		this.bobIdentityKeyPrivate = bobIdentityKeyPrivate;
	}

	public DebugResponse bobPreKeyPublic(byte[] bobPreKeyPublic) {
		this.bobPreKeyPublic = bobPreKeyPublic;
		return this;
	}

	/**
	 * Bob's pre key (SPK_B); public part.
	 * 
	 * @return bobPreKeyPublic
	 **/
	public byte[] getBobPreKeyPublic() {
		return bobPreKeyPublic;
	}

	public void setBobPreKeyPublic(byte[] bobPreKeyPublic) {
		this.bobPreKeyPublic = bobPreKeyPublic;
	}

	public DebugResponse bobPreKeyPrivate(byte[] bobPreKeyPrivate) {
		this.bobPreKeyPrivate = bobPreKeyPrivate;
		return this;
	}

	/**
	 * Bob's pre key (SPK_B); private part.
	 * 
	 * @return bobPreKeyPrivate
	 **/
	public byte[] getBobPreKeyPrivate() {
		return bobPreKeyPrivate;
	}

	public void setBobPreKeyPrivate(byte[] bobPreKeyPrivate) {
		this.bobPreKeyPrivate = bobPreKeyPrivate;
	}

	public DebugResponse bobOneTimePreKeyPublic(byte[] bobOneTimePreKeyPublic) {
		this.bobOneTimePreKeyPublic = bobOneTimePreKeyPublic;
		return this;
	}

	/**
	 * Bob's one-time pre key (OPK_B); public part.
	 * 
	 * @return bobOneTimePreKeyPublic
	 **/
	public byte[] getBobOneTimePreKeyPublic() {
		return bobOneTimePreKeyPublic;
	}

	public void setBobOneTimePreKeyPublic(byte[] bobOneTimePreKeyPublic) {
		this.bobOneTimePreKeyPublic = bobOneTimePreKeyPublic;
	}

	public DebugResponse bobOneTimePreKeyPrivate(byte[] bobOneTimePreKeyPrivate) {
		this.bobOneTimePreKeyPrivate = bobOneTimePreKeyPrivate;
		return this;
	}

	/**
	 * Bob's one-time pre key (OPK_B); private part.
	 * 
	 * @return bobOneTimePreKeyPrivate
	 **/
	public byte[] getBobOneTimePreKeyPrivate() {
		return bobOneTimePreKeyPrivate;
	}

	public void setBobOneTimePreKeyPrivate(byte[] bobOneTimePreKeyPrivate) {
		this.bobOneTimePreKeyPrivate = bobOneTimePreKeyPrivate;
	}

	public DebugResponse aliceIdentityKeyPublic(byte[] aliceIdentityKeyPublic) {
		this.aliceIdentityKeyPublic = aliceIdentityKeyPublic;
		return this;
	}

	/**
	 * Alice's identity key (IK_A); public part.
	 * 
	 * @return aliceIdentityKeyPublic
	 **/
	public byte[] getAliceIdentityKeyPublic() {
		return aliceIdentityKeyPublic;
	}

	public void setAliceIdentityKeyPublic(byte[] aliceIdentityKeyPublic) {
		this.aliceIdentityKeyPublic = aliceIdentityKeyPublic;
	}

	public DebugResponse dhRatchetBobKeyPrivate(byte[] dhRatchetBobKeyPrivate) {
		this.dhRatchetBobKeyPrivate = dhRatchetBobKeyPrivate;
		return this;
	}

	/**
	 * Bob's current private key in Bob's DH ratchet.
	 * 
	 * @return dhRatchetBobKeyPrivate
	 **/
	public byte[] getDhRatchetBobKeyPrivate() {
		return dhRatchetBobKeyPrivate;
	}

	public void setDhRatchetBobKeyPrivate(byte[] dhRatchetBobKeyPrivate) {
		this.dhRatchetBobKeyPrivate = dhRatchetBobKeyPrivate;
	}

	public DebugResponse dhRatchetAliceKeyPublic(byte[] dhRatchetAliceKeyPublic) {
		this.dhRatchetAliceKeyPublic = dhRatchetAliceKeyPublic;
		return this;
	}

	/**
	 * Alice's current public key in Bob's DH ratchet.
	 * 
	 * @return dhRatchetAliceKeyPublic
	 **/
	public byte[] getDhRatchetAliceKeyPublic() {
		return dhRatchetAliceKeyPublic;
	}

	public void setDhRatchetAliceKeyPublic(byte[] dhRatchetAliceKeyPublic) {
		this.dhRatchetAliceKeyPublic = dhRatchetAliceKeyPublic;
	}

	public DebugResponse dhRatchetNextSharedSecret(byte[] dhRatchetNextSharedSecret) {
		this.dhRatchetNextSharedSecret = dhRatchetNextSharedSecret;
		return this;
	}

	/**
	 * The shared secret which would be generated by the current state of Bob's DH
	 * ratchet.
	 * 
	 * @return dhRatchetNextSharedSecret
	 **/
	public byte[] getDhRatchetNextSharedSecret() {
		return dhRatchetNextSharedSecret;
	}

	public void setDhRatchetNextSharedSecret(byte[] dhRatchetNextSharedSecret) {
		this.dhRatchetNextSharedSecret = dhRatchetNextSharedSecret;
	}

	public DebugResponse rootRatchetCurrentKey(byte[] rootRatchetCurrentKey) {
		this.rootRatchetCurrentKey = rootRatchetCurrentKey;
		return this;
	}

	/**
	 * The current root key in Bob's root ratchet.
	 * 
	 * @return rootRatchetCurrentKey
	 **/
	public byte[] getRootRatchetCurrentKey() {
		return rootRatchetCurrentKey;
	}

	public void setRootRatchetCurrentKey(byte[] rootRatchetCurrentKey) {
		this.rootRatchetCurrentKey = rootRatchetCurrentKey;
	}

	public DebugResponse rootRatchetNextKey(byte[] rootRatchetNextKey) {
		this.rootRatchetNextKey = rootRatchetNextKey;
		return this;
	}

	/**
	 * The next root key in Bob's root ratchet, if the current state of the DH
	 * ratchet would be applied there.
	 * 
	 * @return rootRatchetNextKey
	 **/
	public byte[] getRootRatchetNextKey() {
		return rootRatchetNextKey;
	}

	public void setRootRatchetNextKey(byte[] rootRatchetNextKey) {
		this.rootRatchetNextKey = rootRatchetNextKey;
	}

	public DebugResponse rootRatchetNextGeneratedChainKey(byte[] rootRatchetNextGeneratedChainKey) {
		this.rootRatchetNextGeneratedChainKey = rootRatchetNextGeneratedChainKey;
		return this;
	}

	/**
	 * The next send/receive ratchet chain key from Bob's root ratchet, if the
	 * current state of the DH ratchet would be applied there.
	 * 
	 * @return rootRatchetNextGeneratedChainKey
	 **/
	public byte[] getRootRatchetNextGeneratedChainKey() {
		return rootRatchetNextGeneratedChainKey;
	}

	public void setRootRatchetNextGeneratedChainKey(byte[] rootRatchetNextGeneratedChainKey) {
		this.rootRatchetNextGeneratedChainKey = rootRatchetNextGeneratedChainKey;
	}

	public DebugResponse sendRatchetCurrentKey(byte[] sendRatchetCurrentKey) {
		this.sendRatchetCurrentKey = sendRatchetCurrentKey;
		return this;
	}

	/**
	 * The current chain key in Bob's send ratchet.
	 * 
	 * @return sendRatchetCurrentKey
	 **/
	public byte[] getSendRatchetCurrentKey() {
		return sendRatchetCurrentKey;
	}

	public void setSendRatchetCurrentKey(byte[] sendRatchetCurrentKey) {
		this.sendRatchetCurrentKey = sendRatchetCurrentKey;
	}

	public DebugResponse sendRatchetNextKey(byte[] sendRatchetNextKey) {
		this.sendRatchetNextKey = sendRatchetNextKey;
		return this;
	}

	/**
	 * The next chain key in Bob's send ratchet, if it was incremented once.
	 * 
	 * @return sendRatchetNextKey
	 **/
	public byte[] getSendRatchetNextKey() {
		return sendRatchetNextKey;
	}

	public void setSendRatchetNextKey(byte[] sendRatchetNextKey) {
		this.sendRatchetNextKey = sendRatchetNextKey;
	}

	public DebugResponse sendRatchetNextGeneratedMessageKey(byte[] sendRatchetNextGeneratedMessageKey) {
		this.sendRatchetNextGeneratedMessageKey = sendRatchetNextGeneratedMessageKey;
		return this;
	}

	/**
	 * The next message key generated by Bob's send ratchet, if it was incremented
	 * once.
	 * 
	 * @return sendRatchetNextGeneratedMessageKey
	 **/
	public byte[] getSendRatchetNextGeneratedMessageKey() {
		return sendRatchetNextGeneratedMessageKey;
	}

	public void setSendRatchetNextGeneratedMessageKey(byte[] sendRatchetNextGeneratedMessageKey) {
		this.sendRatchetNextGeneratedMessageKey = sendRatchetNextGeneratedMessageKey;
	}

	public DebugResponse receiveRatchetCurrentKey(byte[] receiveRatchetCurrentKey) {
		this.receiveRatchetCurrentKey = receiveRatchetCurrentKey;
		return this;
	}

	/**
	 * The current chain key in Bob's receive ratchet.
	 * 
	 * @return receiveRatchetCurrentKey
	 **/
	public byte[] getReceiveRatchetCurrentKey() {
		return receiveRatchetCurrentKey;
	}

	public void setReceiveRatchetCurrentKey(byte[] receiveRatchetCurrentKey) {
		this.receiveRatchetCurrentKey = receiveRatchetCurrentKey;
	}

	public DebugResponse receiveRatchetNextKey(byte[] receiveRatchetNextKey) {
		this.receiveRatchetNextKey = receiveRatchetNextKey;
		return this;
	}

	/**
	 * The next chain key in Bob's receive ratchet, if it was incremented once.
	 * 
	 * @return receiveRatchetNextKey
	 **/
	public byte[] getReceiveRatchetNextKey() {
		return receiveRatchetNextKey;
	}

	public void setReceiveRatchetNextKey(byte[] receiveRatchetNextKey) {
		this.receiveRatchetNextKey = receiveRatchetNextKey;
	}

	public DebugResponse receiveRatchetNextGeneratedMessageKey(byte[] receiveRatchetNextGeneratedMessageKey) {
		this.receiveRatchetNextGeneratedMessageKey = receiveRatchetNextGeneratedMessageKey;
		return this;
	}

	/**
	 * The next message key generated by Bob's receive ratchet, if it was
	 * incremented once.
	 * 
	 * @return receiveRatchetNextGeneratedMessageKey
	 **/
	public byte[] getReceiveRatchetNextGeneratedMessageKey() {
		return receiveRatchetNextGeneratedMessageKey;
	}

	public void setReceiveRatchetNextGeneratedMessageKey(byte[] receiveRatchetNextGeneratedMessageKey) {
		this.receiveRatchetNextGeneratedMessageKey = receiveRatchetNextGeneratedMessageKey;
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
