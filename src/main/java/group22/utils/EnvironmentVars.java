
package group22.utils;

/**
 * Class to access environment variable for gmail access code
 */
public class EnvironmentVars {
    /**
     * Gets the password to authorize gmail from environment variable
     *
     * @return Value of GMAIL_PASSWORD, or null if not set
     */
    public static String getPassword() {
        return System.getenv("GMAIL_PASSWORD");
    }
}

