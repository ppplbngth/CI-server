package src.test.java.servertests;

import group22.utils.CloneRepository;
import group22.utils.CompileProject;
import group22.utils.AutomatedTestProject;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.assertTrue;

public class AutomatedTestTest {
    
    /**
     * Clones, compiles and run the tests located in the folder test/java/group22
     * Pass the test if all the tests in the repository are successfull. 
     * @throws IOException
     */
    @Test
    public void testPositiveCompileProject() throws IOException, InterruptedException {
        String repositoryURL = "https://github.com/ppplbngth/CI-server.git";
        String localPath = "test-repository-testing";
        String branch = "main";
        CloneRepository.cloneRepository(repositoryURL, localPath, branch);

        CompileProject.compileProject(localPath);
        Boolean result = AutomatedTestProject.runTests(localPath);

        assertTrue("All tests should have passed successfully", result);
    }
}
