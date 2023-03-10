package group22.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * A class for running commands for the server to compile a maven project
 */
public class CompileProject {
    /**
     * Compiles a Maven project without running any test.
     * The mvn project is specified in the localPath directory and runs a process with the Maven command "mvn clean package -DskipTests"
     * If the project compiles successfully the function returns true, else it returns false.
     * @param localPath the project directory path
     * @return Boolean true if the compilation is successful, otherwise false
     */
    public static Boolean compileProject(String localPath) {
        try {
            String mvnCommand = "mvn clean package -DskipTests";
            Process process = Runtime.getRuntime().exec(mvnCommand, null, new File(localPath));
            
            int result = process.waitFor();
            if (result == 0) {
                System.out.println("Project compiled successfully");
                return true;
            } else {
                System.out.println("Error compiling project");
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error compiling project: " + e.getMessage());
        }
        return false;
    }
}
