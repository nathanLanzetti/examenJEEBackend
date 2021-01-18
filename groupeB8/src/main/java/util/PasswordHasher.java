package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class PasswordHasher implements IPasswordHasher {

	// Méthode qui se charge de crypter les mots de passe
	@Override
	public String hashWith256(String textToHash) {
		MessageDigest digest;
		try {
			// fonction qui permet de hasher avec l'algorythme "SHA-256"
			digest = MessageDigest.getInstance("SHA-256");
			byte[] byteOfTextToHash = textToHash.getBytes(StandardCharsets.UTF_8);
		    byte[] hashedByteArray = digest.digest(byteOfTextToHash);
		    // Encode le byte crypté en string 
		    String encoded = Base64.getEncoder().encodeToString(hashedByteArray);
		    return encoded;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}

}
