package group22.service;

import group22.CIServer;
import org.apache.maven.shared.invoker.*;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

public class GitService {

    /**
     *  update branch to newest state
     *
     * @param git
     * @param branchName
     */
    public static void pullRepo(Git git, String branchName){
        try {

            boolean existBranch = false;

            List<Ref> call = git.branchList().call();     //得到所有分支信息

            for(Ref ref : call){
                String[] arr = ref.getName().toString().split("/");
                if(arr[arr.length - 1].equals(branchName)){
                    existBranch = true;
                    break;
                }
            }

            if(!existBranch) {
                git.branchCreate()
                        .setName(branchName) //创建的分支名字
                        .call();
            }

            git.pull()
                    .setRemoteBranchName(branchName)
                    .call();


        } catch (GitAPIException e) {
            e.printStackTrace();
        }
    }

    /**
     * automated test
     *
     * @param git
     * @param branchName
     * @return if test results are all correct
     */
    public static Boolean testBranch(Git git, String branchName){

        try {
            git.checkout()
                    .setName(branchName)
                    .call();
        } catch (GitAPIException e) {
            e.printStackTrace();
        }

        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File(CIServer.localRepoPath + "/pom.xml"));
        request.setGoals(Collections.singletonList("test"));
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File("D:\\apache-maven-3.8.2"));


        try {
            InvocationResult result = invoker.execute(request);
            int exitCode = result.getExitCode();
            System.out.println("退出码:"+exitCode);
            if (0==exitCode){
                System.out.println("Test passed");
                return true;
            }else{
                System.out.println("Test failed");
            }
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        }

        return false;
    }

}
