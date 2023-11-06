package crypto;

import org.bouncycastle.crypto.agreement.X25519Agreement;
import org.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.math.ec.rfc7748.X25519;

public class DhRatchet {
	
	public X25519PrivateKeyParameters localPrivateKey;
	public X25519PublicKeyParameters remotePublicKey;

	public byte[] getSharedSecret() {
		// Initialize agreement
		X25519Agreement alg = new X25519Agreement();
		alg.init(localPrivateKey);
		
		// Compute shared secret
		byte[] result = new byte[X25519.POINT_SIZE];
		alg.calculateAgreement(remotePublicKey, result, 0);
		
		return result;
		
	}

}
