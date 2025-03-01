package examen;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class PasswordConfigDTO {
    boolean restrictMinDigits;
    int minDigits;
    boolean restrictMinUpperCaseLetters;
    int minUpperCaseLetters;
    boolean restrictMinLowerCaseLetters;
    int minLowerCaseLetters;
    boolean restrictMinNonAlphanumericCharacters;
    int minNonAlphanumericCharacters;
    int minLength;
    
    
    public PasswordConfigDTO(boolean restrictMinDigits, int minDigits,
                             boolean restrictMinUpperCaseLetters, int minUpperCaseLetters,
                             boolean restrictMinLowerCaseLetters, int minLowerCaseLetters,
                             boolean restrictMinNonAlphanumericCharacters, int minNonAlphanumericCharacters,
                             int minLength) {
        this.restrictMinDigits = restrictMinDigits;
        this.minDigits = minDigits;
        this.restrictMinUpperCaseLetters = restrictMinUpperCaseLetters;
        this.minUpperCaseLetters = minUpperCaseLetters;
        this.restrictMinLowerCaseLetters = restrictMinLowerCaseLetters;
        this.minLowerCaseLetters = minLowerCaseLetters;
        this.restrictMinNonAlphanumericCharacters = restrictMinNonAlphanumericCharacters;
        this.minNonAlphanumericCharacters = minNonAlphanumericCharacters;
        this.minLength = minLength;
    }
}
class PasswordGenerator {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIALS = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
    private static final SecureRandom RANDOM = new SecureRandom();
    // Versión 1: Generador de contraseña simple
    public static String generatePassword(int length) {
        if (length < 8) length = 8; // Asegurar longitud mínima
        List<Character> password = new ArrayList<>();
        password.add(LOWERCASE.charAt(RANDOM.nextInt(LOWERCASE.length())));
        password.add(UPPERCASE.charAt(RANDOM.nextInt(UPPERCASE.length())));
        password.add(DIGITS.charAt(RANDOM.nextInt(DIGITS.length())));
        password.add(SPECIALS.charAt(RANDOM.nextInt(SPECIALS.length())));
        while (password.size() < length) {
            String allChars = LOWERCASE + UPPERCASE + DIGITS + SPECIALS;
            password.add(allChars.charAt(RANDOM.nextInt(allChars.length())));
        }
        Collections.shuffle(password);
        return password.stream().map(String::valueOf).reduce("", String::concat);
    }
    // Versión 2: Generador de contraseña configurable
    public static String generatePassword(PasswordConfigDTO config) {
        List<Character> password = new ArrayList<>();
        StringBuilder allChars = new StringBuilder(LOWERCASE + UPPERCASE + DIGITS + SPECIALS);
        if (config.restrictMinDigits) addRandomChars(password, DIGITS, config.minDigits);
        if (config.restrictMinUpperCaseLetters) addRandomChars(password, UPPERCASE, config.minUpperCaseLetters);
        if (config.restrictMinLowerCaseLetters) addRandomChars(password, LOWERCASE, config.minLowerCaseLetters);
        if (config.restrictMinNonAlphanumericCharacters) addRandomChars(password, SPECIALS, config.minNonAlphanumericCharacters);
        while (password.size() < Math.max(config.minLength, 8)) {
            password.add(allChars.charAt(RANDOM.nextInt(allChars.length())));
        }
        Collections.shuffle(password);
        return password.stream().map(String::valueOf).reduce("", String::concat);
    }
    private static void addRandomChars(List<Character> password, String charSet, int count) {
        for (int i = 0; i < count; i++) {
            password.add(charSet.charAt(RANDOM.nextInt(charSet.length())));
        }
    }
}
public class Main {
    public static void main(String[] args) {
        // Generar contraseña usando la versión 1
        System.out.println("Versión 1: " + PasswordGenerator.generatePassword(12));
        // Configuración para la versión 2
        PasswordConfigDTO config = new PasswordConfigDTO(true, 3, true, 2, true, 2, true, 2, 12);
        System.out.println("Versión 2: " + PasswordGenerator.generatePassword(config));
    }
}