package group22.utils;

import java.io.File;
import java.io.IOException;

/**
 * This class handles the automated testing of the project.
 */
public class AutomatedTestProject {
    /**
     * Runs the test of the cloned repository using the command "mvn test" 
     * 
     * @param localPath path to the repository
     * @return true if all test are correct, else return false. 
     */
    public static Boolean runTests(String localPath){

        try{
            String mvnCommand = "mvn test";
            Process process = Runtime.getRuntime().exec(mvnCommand, null, new File(localPath));
            int exitCode = process.waitFor();

            
            if (0==exitCode){
                System.out.println("Test passed");
                return true;
            }else{
                System.out.println("Test failed");
            }
            } catch (IOException | InterruptedException e) {
                System.out.println("Error running tests: " + e.getMessage());
            }
        return false;
    }
}

