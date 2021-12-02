package br.com.eleicaoonline.utils;

import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemWriter;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;

/**
 * @author wandyer.silva
 */
public class RSAUtil {

    private static RSAPublicKey readSSHRSAPublicKey(String rsaPublicKeyText)
        throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        final String tag = "ssh-rsa";
        if (!rsaPublicKeyText.startsWith(tag)) {
            throw new IllegalArgumentException("Only support 'ssh-rsa' format!");
        }
        int startPos = tag.length() + 1;
        int endPos = rsaPublicKeyText.lastIndexOf(' ');
        String keyInfoStr = rsaPublicKeyText.substring(startPos, endPos);
        return readSSHRSAPublicKeyBody(keyInfoStr);
    }

    private static RSAPublicKey readSSHRSAPublicKeyBody(String rsaPublicKeyBody)
        throws IOException, NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] decodeKeyInfo = java.util.Base64.getDecoder().decode(rsaPublicKeyBody);
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(decodeKeyInfo));
        BigInteger formatId = readBigInt(dis);
        if (!formatId.toString(16).equals("7373682d727361")) {
            throw new IllegalArgumentException("Only support 'ssh-rsa' format!");
        }
        BigInteger publicExponent = readBigInt(dis);
        BigInteger modulus = readBigInt(dis);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        RSAPublicKeySpec rsaPublicKeySpec = new RSAPublicKeySpec(modulus, publicExponent);
        PublicKey publicKey = keyFactory.generatePublic(rsaPublicKeySpec);
        return (RSAPublicKey) publicKey;
    }

    private static BigInteger readBigInt(DataInputStream dis) throws IOException {
        int len = dis.readInt();
        byte[] tmpBytes = new byte[len];
        dis.readFully(tmpBytes);
        return new BigInteger(1, tmpBytes);
    }

    public static String toPKCS1(RSAPublicKey rsaPublicKey) {
        try {
            byte[] pubBytes = rsaPublicKey.getEncoded();

            SubjectPublicKeyInfo spkInfo = SubjectPublicKeyInfo.getInstance(pubBytes);
            ASN1Primitive primitive = spkInfo.parsePublicKey();
            byte[] publicKeyPKCS1 = primitive.getEncoded();

            PemObject pemObject = new PemObject("RSA PUBLIC KEY", publicKeyPKCS1);
            StringWriter stringWriter = new StringWriter();
            PemWriter pemWriter = new PemWriter(stringWriter);
            pemWriter.writeObject(pemObject);
            pemWriter.close();
            return stringWriter.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String sshRsaStringToPemString(String sshRsa) {
        try {
            final RSAPublicKey rsaPublicKey1 = RSAUtil.readSSHRSAPublicKey(sshRsa);
            return RSAUtil.toPKCS1(rsaPublicKey1);
        } catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String pemStringPrint(String keyString) {
        String begin = "-----BEGIN RSA PUBLIC KEY-----\n";
        String end = "\n-----END RSA PUBLIC KEY-----";
        return begin.concat(keyString).concat(end);
    }
}
