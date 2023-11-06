package client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.crypto.agreement.X25519Agreement;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.HKDFParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.X25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.math.ec.rfc7748.X25519;

import com.google.common.primitives.Bytes;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.ClientProtocolException;

import apimodels.AuthRequest;
import apimodels.AuthResponse;
import apimodels.DebugRequest;
import apimodels.DebugResponse;
import apimodels.InitialMessageRequest;
import apimodels.MessageRequest;
import apimodels.MessageResponse;
import crypto.DhRatchet;
import crypto.RootRatchet;
import crypto.SendReceiveRatchet;

public class Main {

	private static SecureRandom random;

	private static AsymmetricCipherKeyPair identityKey;
	private static X25519PublicKeyParameters bobIdentityKey;

	private static DhRatchet dhRatchet;
	private static RootRatchet rootRatchet;
	private static SendReceiveRatchet sendRatchet;
	private static SendReceiveRatchet receiveRatchet;
	
	public static void main(String[] args) throws IllegalStateException, InvalidCipherTextException, ClientProtocolException, IOException {
				
		// Initialize key generator
		random = new SecureRandom();
		X25519KeyPairGenerator keygen = new X25519KeyPairGenerator();
		keygen.init(new KeyGenerationParameters(random, 1));

		// Initialize own keys
		identityKey = keygen.generateKeyPair();

		// Initialize API accessor
		ApiAccessor api = new ApiAccessor();

		// Authenticate
		System.out.println("Enter name: ");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();

		// Create authentication request
		AuthRequest authRequest = new AuthRequest();

		/*****************************
		 * TODO: complete AuthRequest
		 *****************************/

		authRequest.setName(name);

        // Get authentication response
		AuthResponse authResponse = api.authenticate(authRequest.toString());
		System.out.println(String.format("Successfully authenticated. Token: %1$s", authResponse.getAuthenticationData().getAuthenticationToken()));


		bobIdentityKey = new X25519PublicKeyParameters(authResponse.getBobIdentityKey(), 0);
		X25519PublicKeyParameters bobPreKey = new X25519PublicKeyParameters(authResponse.getBobPreKey(), 0);
		X25519PublicKeyParameters bobOneTimePreKey = new X25519PublicKeyParameters(authResponse.getBobOneTimePreKey(), 0);


		// Compute X3DH
		AsymmetricCipherKeyPair ephemeralKey = keygen.generateKeyPair();
		byte[] x3dhKeys = new byte[4 * X25519.POINT_SIZE];
		X25519Agreement agreementAlgorithm = new X25519Agreement();

		/**********************************
		 * TODO: complete X3DH computation
		 **********************************/

		//generate my Identity Key
		//AsymmetricCipherKeyPair identityKey = keygen.generateKeyPair();

		//DH1
		//DHK of my identity key and bobs signed prekey
		agreementAlgorithm.init(identityKey.getPrivate());
		int off = 0;
		agreementAlgorithm.calculateAgreement(bobPreKey, x3dhKeys, off);
		off = off + X25519.POINT_SIZE;

		//DH2
		//DHK of my ephermarl and bobs identity key
		agreementAlgorithm.init(ephemeralKey.getPrivate());
		agreementAlgorithm.calculateAgreement(bobIdentityKey, x3dhKeys, off);
		off = off + X25519.POINT_SIZE;

		//DH3
		//DHK of my ephemeral and bobs signed prekey
		agreementAlgorithm.init(ephemeralKey.getPrivate());
		agreementAlgorithm.calculateAgreement(bobPreKey, x3dhKeys, off);
		off = off + X25519.POINT_SIZE;

		//DH4
		//DHK of my ephemeral and bobs one time pre key
		agreementAlgorithm.init(ephemeralKey.getPrivate());
		agreementAlgorithm.calculateAgreement(bobOneTimePreKey, x3dhKeys, off);
		off = off + X25519.POINT_SIZE;

		//Should now have DH1, DH2, DH3 and DH4
		System.out.println("Computed x3dh keys:");
		for (int i = 0; i < 4; i++) { 
			System.out.print("DH" + (i + 1) + ": ");
			for (int j = 0; j < X25519.POINT_SIZE; j++) {
				System.out.printf("%02X", x3dhKeys[i * X25519.POINT_SIZE + j] & 0xFF);
			}
			System.out.println();
		}
		


		// Compute session key for initializing root ratchet
		HKDFBytesGenerator hkdf = new HKDFBytesGenerator(new SHA256Digest());
		hkdf.init(new HKDFParameters(x3dhKeys, new byte[0], new byte[0]));
		byte[] sk = new byte[32];
		hkdf.generateBytes(sk, 0, sk.length);
		rootRatchet = new RootRatchet(sk);

		// Initialize DH ratchet
		AsymmetricCipherKeyPair dhKey = keygen.generateKeyPair();
		dhRatchet = new DhRatchet();

		/*******************************************
		 * TODO: complete DH ratchet initialization
		 *******************************************/

		dhRatchet.localPrivateKey = (X25519PrivateKeyParameters) dhKey.getPrivate();
		dhRatchet.remotePublicKey = bobPreKey;
		// Initialize send ratchet
		sendRatchet = new SendReceiveRatchet(rootRatchet.step(dhRatchet.getSharedSecret()));

		// Prepare first message
		System.out.println("Enter first message: ");
		String firstMessage = scanner.nextLine();
		byte[] firstMessageEncrypted = encryptMessage(firstMessage);

		// Send first message
		InitialMessageRequest firstMessageRequest = new InitialMessageRequest();

		/***************************************
		 * TODO: complete first message request
		 ***************************************/
		byte[] nonce = Arrays.copyOfRange(firstMessageEncrypted, 0, 12); 
		byte[] cipherText = Arrays.copyOfRange(firstMessageEncrypted, 12, firstMessageEncrypted.length); 


		firstMessageRequest.setAuthHeader(authResponse.getAuthenticationData());
		firstMessageRequest.setAliceIdentityKey(((X25519PublicKeyParameters)identityKey.getPublic()).getEncoded());
		firstMessageRequest.setAliceEphemeralKey(((X25519PublicKeyParameters)ephemeralKey.getPublic()).getEncoded());
		firstMessageRequest.setNewRatchetPublicKey(((X25519PublicKeyParameters)dhKey.getPublic()).getEncoded());
		firstMessageRequest.setFirstMessageNonce(nonce);
		firstMessageRequest.setFirstMessageEncrypted(cipherText);

		System.out.println(firstMessageRequest.toString());



        // Get first message response

		MessageResponse firstMessageResponse = api.firstMessage(firstMessageRequest);

		boolean allowUpdateDhKey = handleMessageResponse(firstMessageResponse);
		
		// Message loop
		while (true) {

			// Prompt
			System.out.println("Enter message (or leave empty to exit): ");
			String message = scanner.nextLine();
			if (StringUtils.isBlank(message)) {
				break;
			}

			// Can we generate a new DH key?
			boolean dhKeyChanged = false;
			if (allowUpdateDhKey) {

				// Should we do it?
				System.out.println("Change DH key (1: yes)? ");
				String change = scanner.nextLine();
				dhKeyChanged = StringUtils.equals(change, "1");

				if (dhKeyChanged) {

					/*******************************************************
					* TODO: Generate and set new private key for DH ratchet
		 			********************************************************/
					AsymmetricCipherKeyPair newDhKey = null;



					/***********************************
					* TODO: Initialize new send ratchet
		 			************************************/
					


					// Toggle flag
					allowUpdateDhKey = false;
				}
			}



			// Insert debug stuff if needed 
			//DebugRequest debugRequest = new DebugRequest();
			/**********************************************************
		 	* TODO (optional): DEBUG AREA: insert parameters if needed
		 	***********************************************************/



			//System.out.println(debugRequest.toString());
			//DebugResponse debugResponse = api.message(debugRequest);
			//System.out.println(debugResponse.toString());




			// Encrypt message
			byte[] messageEncrypted = encryptMessage(message);
			
			// Send message
			MessageRequest messageRequest = new MessageRequest();

			/********************************
		 	* TODO: complete message request
			 ********************************/
			 


			// Get message response
			MessageResponse messageResponse = api.message(messageRequest);
			allowUpdateDhKey = handleMessageResponse(messageResponse) || allowUpdateDhKey;
		}

		scanner.close();

	}

	private static byte[] encryptMessage(String message) throws IllegalStateException, InvalidCipherTextException {

		// Encode message
		byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);

		// Compose associated data for encryption
		byte[] encryptAd = new byte[3 * X25519.POINT_SIZE];
		((X25519PublicKeyParameters) identityKey.getPublic()).encode(encryptAd, 0);
		bobIdentityKey.encode(encryptAd, X25519.POINT_SIZE);
		dhRatchet.localPrivateKey.generatePublicKey().encode(encryptAd, 2 * X25519.POINT_SIZE);

		// Encrypt message
		byte[] encryptKey = sendRatchet.step();
		byte[] nonce = new byte[12];
		random.nextBytes(nonce);
		GCMBlockCipher aesGcm = new GCMBlockCipher(new AESEngine());
		aesGcm.init(true, new AEADParameters(new KeyParameter(encryptKey), 128, nonce));
		aesGcm.processAADBytes(encryptAd, 0, encryptAd.length);
		byte[] cipherBytes = new byte[aesGcm.getOutputSize(messageBytes.length)];
		int encTmpLen = aesGcm.processBytes(messageBytes, 0, messageBytes.length, cipherBytes, 0);
		aesGcm.doFinal(cipherBytes, encTmpLen);

		byte[] result = Bytes.concat(nonce, cipherBytes);

		return result;
	}

	private static boolean handleMessageResponse(MessageResponse response)
			throws IllegalStateException, InvalidCipherTextException, UnsupportedEncodingException {

		// Update remote DH public key, if desired
		if (response.getNewRatchetPublicKey() != null) {
			// Update ratchet
			dhRatchet.remotePublicKey = new X25519PublicKeyParameters(response.getNewRatchetPublicKey(), 0);

			// Create new receive ratchet
			receiveRatchet = new SendReceiveRatchet(rootRatchet.step(dhRatchet.getSharedSecret()));
		}

		// Compose associated data for encryption
		byte[] decryptAd = new byte[3 * X25519.POINT_SIZE];
		((X25519PublicKeyParameters) identityKey.getPublic()).encode(decryptAd, 0);
		bobIdentityKey.encode(decryptAd, X25519.POINT_SIZE);
		dhRatchet.remotePublicKey.encode(decryptAd, 2 * X25519.POINT_SIZE);

		// Decrypt first cipher text
		byte[] decryptKey = receiveRatchet.step();
		GCMBlockCipher aesGcm = new GCMBlockCipher(new AESEngine());
		aesGcm.init(false, new AEADParameters(new KeyParameter(decryptKey), 128, response.getMessageNonce()));
		aesGcm.processAADBytes(decryptAd, 0, decryptAd.length);
		byte[] responseBytes = response.getMessageEncrypted();
		byte[] plainBytes = new byte[aesGcm.getOutputSize(responseBytes.length)];
		int decTmpLen = aesGcm.processBytes(responseBytes, 0, responseBytes.length, plainBytes, 0);
		aesGcm.doFinal(plainBytes, decTmpLen);

		System.out.println("Message from Bob: \n\n" + StringUtils.toEncodedString(plainBytes, StandardCharsets.UTF_8));

		// Indicate whether Bob's key has changed
		return response.getNewRatchetPublicKey() != null;
	}

}
