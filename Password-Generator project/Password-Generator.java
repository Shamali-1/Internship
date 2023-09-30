import java.security.SecureRandom;

public class PasswordGenerator {
    public static void main(String[] args) {
        int minLength = 8;
        int maxLength = 16;

        String password = generateRandomPassword(minLength, maxLength);
        System.out.println("Generated Password: " + password);
        System.out.println("Password Length: " + password.length());

        String strength = checkPasswordStrength(password);
        System.out.println("Password Strength: " + strength);
    }

    // Generate a random password
    public static String generateRandomPassword(int minLength, int maxLength) {
        SecureRandom random = new SecureRandom();
        String passwordAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+";
        
        int passwordLength = minLength + random.nextInt(maxLength - minLength + 1);
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passwordLength; i++) {
            int randomIndex = random.nextInt(passwordAlphabet.length());
            char randomChar = passwordAlphabet.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }

    // Check password strength
    public static String checkPasswordStrength(String password) {
        int length = password.length();

        if (length < 8) {
            return "Very Weak";
        } else if (length >= 8 && length <= 16) {
            if (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*") && password.matches(".*[!@#$%^&*()-_=+].*")) {
                return "Very Strong";
            } else if (password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*\\d.*")) {
                return "Strong";
            } else if (password.matches(".*[A-Z].*") || password.matches(".*[a-z].*")) {
                return "Medium";
            } else {
                return "Weak";
            }
        } else {
            return "Very Weak";
        }
    }
}
