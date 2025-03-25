package application;

import databasePart1.DatabaseHelper;
import application.User;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class verifies key functionality of the {@link DatabaseHelper} class,
 * including user registration, login, and invitation code generation/validation.
 * <p>
 * Each test targets a specific method in DatabaseHelper and checks for
 * correct system behavior under expected conditions.
 * <p>
 * This version uses dynamic usernames to avoid conflicts with primary key constraints.
 * 
 * @author Daniel Campanella
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class HW3DatabaseTesting {

    private DatabaseHelper db;

    @BeforeAll
    void setup() throws SQLException {
        db = new DatabaseHelper();
        db.connectToDatabase();
    }

    @AfterAll
    void teardown() {
        db.closeConnection();
    }

    /**
     * Tests that registering a user adds them to the database and makes them discoverable
     * via {@code doesUserExist()}.
     */
    @Test
    void testRegisterAndUserExists() throws SQLException {
        String uniqueUser = "testUser_" + UUID.randomUUID();
        User user = new User(uniqueUser, "password123", "user", uniqueUser + "@example.com", false);
        db.register(user);
        assertTrue(db.doesUserExist(uniqueUser), "User should exist after registration");
    }

    /**
     * Tests that a user can log in with valid credentials using {@code login()}.
     */
    @Test
    void testLoginWithValidCredentials() throws SQLException {
        String uniqueUser = "testLoginUser_" + UUID.randomUUID();
        User user = new User(uniqueUser, "pass456", "user", uniqueUser + "@example.com", false);
        db.register(user);
        assertTrue(db.login(user), "Login should succeed with correct credentials");
    }

    /**
     * Tests that {@code doesUserExist()} returns true for a real user
     * and false for a non-existent user.
     */
    @Test
    void testDoesUserExistEdgeCases() throws SQLException {
        String uniqueUser = "checkExistUser_" + UUID.randomUUID();
        User user = new User(uniqueUser, "checkPass", "user", uniqueUser + "@example.com", false);
        db.register(user);
        assertTrue(db.doesUserExist(uniqueUser), "Existing user should be found");
        assertFalse(db.doesUserExist("ghostUser_" + UUID.randomUUID()), "Nonexistent user should not be found");
    }

    /**
     * Verifies that {@code generateInvitationCode()} returns a non-null, 4-character code.
     */
    @Test
    void testGenerateInvitationCode() {
        String code = db.generateInvitationCode();
        System.out.println("Generated code: " + code);
        assertNotNull(code, "Generated code should not be null");
        assertEquals(4, code.length(), "Invitation code should be 4 characters");
    }

    /**
     * Verifies that an invitation code can only be used once.
     * First use should return true; second use should return false.
     */
    @Test
    void testValidateInvitationCodeSingleUse() {
        String code = db.generateInvitationCode();
        assertTrue(db.validateInvitationCode(code), "Code should be valid on first use");
        assertFalse(db.validateInvitationCode(code), "Code should be invalid after one use");
    }
}
