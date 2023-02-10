package group22;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import group22.utils.*;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import org.json.simple.JSONObject;
import group22.utils.SendEmailNotification;






/** 
 * An implementation of a simple CI server.
 * The class uses Jetty and can clone, compile and test a branch of a Github repo using webhooks.
 * Implemented using the skeleton found at https://github.com/KTH-DD2480/smallest-java-ci
*/
public class CIServer extends AbstractHandler
{
    public static final String localRepoPath = "./repo";

    @Override
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) 
        throws IOException, ServletException
    {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        baseRequest.setHandled(true);

        //insert email here
        String to="hannamina@live.se";
        String method = request.getMethod();
        String cloneUrl = null;
        String branch = null;
        boolean testRsl = false;
        String localPath = "./repo";

        JSONObject jsonObject = new JSONObject();

        if ("POST".equals(method)) {
            try {
                jsonObject = Helpers.convertBody(request);
                cloneUrl = Helpers.getCloneUrl(jsonObject);
                branch = Helpers.getBranch(jsonObject);

                CloneRepository.cloneRepository(cloneUrl, localPath, branch);
                response.getWriter().println("Cloned repository");

                CompileProject.compileProject(localPath);
                response.getWriter().println("Built project");

                testRsl = AutomatedTestProject.runTests(localPath);
                if (!testRsl) {
                    response.setStatus(400);
                    response.getWriter().println("test failed");
                    SendEmailNotification.sendEmailNotification( "Build result", "build failed, tests failed or an error occured while testing");
                } else {
                    response.getWriter().println("test passed");
                    SendEmailNotification.sendEmailNotification( "Build result", "build succeded, tests passed");

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        
        response.getWriter().println("CI job done");

    }
 
    /** 
    * Starts the CIServer on port 8080
    * @param args arguments to the program, none used
    * @throws Exception on errors
    */
    public static void main(String[] args) throws Exception
    {

        Server server = new Server(8080);
        server.setHandler(new CIServer());
        server.start();
        server.join();

    }
}
