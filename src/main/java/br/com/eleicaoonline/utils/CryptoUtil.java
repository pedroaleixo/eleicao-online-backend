package br.com.eleicaoonline.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import br.com.eleicaoonline.exception.SystemException;

public class CryptoUtil {

	public static Key getPublicKey() {
		byte[] keyBytes;
		try {
			keyBytes = Files.readAllBytes(Paths.get("public_key.der"));
			X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
			KeyFactory kf = KeyFactory.getInstance("RSA");
			return kf.generatePublic(spec);
		} catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new SystemException(e);
		}

	}

	public static Key getPrivateKey() {
		try {
			byte[] keyBytes = Files.readAllBytes(Paths.get("private_key.der"));
			PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
			KeyFactory kf;
			kf = KeyFactory.getInstance("RSA");
			return kf.generatePrivate(spec);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | IOException e) {
			throw new SystemException(e);
		}
	}

	public static String encodeMessage(String message) {
		Cipher encryptCipher;
		try {
			encryptCipher = Cipher.getInstance("RSA");
			encryptCipher.init(Cipher.ENCRYPT_MODE, CryptoUtil.getPublicKey());
			byte[] secretMessageBytes = message.getBytes(StandardCharsets.UTF_8);
			byte[] encryptedMessageBytes = encryptCipher.doFinal(secretMessageBytes);
			return Base64.getEncoder().encodeToString(encryptedMessageBytes);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			throw new SystemException(e);
		}

	}

	public static String decodeMessage(String encodedMessage) {
		try {
			Cipher decryptCipher = Cipher.getInstance("RSA");
			decryptCipher.init(Cipher.DECRYPT_MODE, CryptoUtil.getPrivateKey());
			byte[] decryptedMessageBytes = decryptCipher.doFinal(Base64.getDecoder().decode(encodedMessage));
			return new String(decryptedMessageBytes, StandardCharsets.UTF_8);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException e) {
			throw new SystemException(e);
		}
	}

}
