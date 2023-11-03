package crypto;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.crypto.params.HKDFParameters;

public class RootRatchet {
	
	static String s = "RootRatchet";
	private static byte[] hkdfInfo = s.getBytes(StandardCharsets.US_ASCII);
	public byte[] currentRootKey;
	
	public RootRatchet(byte[] rootKey) {
		currentRootKey = rootKey;
	}
	
	public byte[] step(byte[] dhInputKey) {
		// Initialize HKDF
		HKDFBytesGenerator hkdf = new HKDFBytesGenerator(new SHA256Digest());
		hkdf.init(new HKDFParameters(dhInputKey, currentRootKey, hkdfInfo));
		
		// Derive 64 bytes
		byte[] bytes = new byte[64];
		hkdf.generateBytes(bytes, 0, bytes.length);
		
		// Store new root key
		currentRootKey = Arrays.copyOfRange(bytes, 0, 32);
		
		// Return new chain key
		byte[] result = new byte[32];
		result = Arrays.copyOfRange(bytes, 32, 64);
		return result;
	}
	
	public byte[] peek(byte[] dhInputKey) {
		// Initialize HKDF
		HKDFBytesGenerator hkdf = new HKDFBytesGenerator(new SHA256Digest());
		hkdf.init(new HKDFParameters(dhInputKey, currentRootKey, hkdfInfo));
		
		// Derive 64 bytes
		byte[] bytes = new byte[64];
		hkdf.generateBytes(bytes, 0, bytes.length);
		
		// Return values
		return bytes;
	}

}
