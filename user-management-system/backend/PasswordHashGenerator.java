import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "admin123";
        String hash = encoder.encode(rawPassword);
        System.out.println("Password hash for 'admin123':");
        System.out.println(hash);

        // Verify the hash
        boolean matches = encoder.matches(rawPassword, hash);
        System.out.println("Verification: " + matches);
    }
}
