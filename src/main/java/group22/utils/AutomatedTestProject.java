package group22.utils;


import java.io.File;
import java.io.IOException;

public class AutomatedTestProject {
    /**
     * automated test
     *
     * @param localPath
     * @return if test results are all correct
     */
    public static Boolean testBranch(String localPath){

        try{
            String mvnCommand = "mvn test -Dtest=AutomatedTest";
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

