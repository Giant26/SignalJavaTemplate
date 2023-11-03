package crypto;

import java.util.Arrays;
import com.google.common.primitives.Bytes;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

public class SendReceiveRatchet {
	
	private static byte[] hmacInputMessageKey = {1};
	private static byte[] hmacInputChainKey = {2};
	public byte[] currentChainKey;
	
	public SendReceiveRatchet(byte[] key) {
		if (key.length != 32) {
			throw new IllegalArgumentException("The initial send/receive ratchet key is too short.");
		}
		currentChainKey = Arrays.copyOf(key, 32);
	}
	
	public byte[] step() {
		// Initialize HMAC
		HMac hmac = new HMac(new SHA256Digest());
		
		// Derive new message key
		hmac.init(new KeyParameter(currentChainKey));
		byte[] messageKey = new byte[32];
		hmac.update(hmacInputMessageKey, 0, hmacInputMessageKey.length);
		hmac.doFinal(messageKey, 0);
		
		// Derive new chain key
		hmac.init(new KeyParameter(currentChainKey));
		hmac.update(hmacInputChainKey, 0, hmacInputChainKey.length);
		hmac.doFinal(currentChainKey, 0);
		
		return messageKey;
	}
	
	public byte[] peek() {
		// Initialize HMAC
		HMac hmac = new HMac(new SHA256Digest());
				
		// Derive new message key
		hmac.init(new KeyParameter(currentChainKey));
		byte[] messageKey = new byte[32];
		hmac.update(hmacInputMessageKey, 0, hmacInputMessageKey.length);
		hmac.doFinal(messageKey, 0);
		
		// Derive new chain key
		hmac.init(new KeyParameter(currentChainKey));
		byte[] newChainKey = new byte[32];
		hmac.update(hmacInputChainKey, 0, hmacInputChainKey.length);
		hmac.doFinal(newChainKey, 0);
		
		byte[] result = Bytes.concat(messageKey, newChainKey);
		
		return result;
	}

}
