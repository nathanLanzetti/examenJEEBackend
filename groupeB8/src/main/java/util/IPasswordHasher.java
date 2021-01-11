package util;

public interface IPasswordHasher {

	String hashWith256(String textToHash);
}
