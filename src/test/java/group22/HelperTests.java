package group22;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;

import group22.utils.Helpers;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
* This class tests functions in the class Helpers.java
*/
    
public class HelperTests {
    //a string of an example request payload 
    String payload = "{\"ref\":\"refs/heads/main\",\"before\":\"f09985ddff7c8da99283313951a92ea469c4124c\",\"after\":\"39c0e76f1db886e115ed6896b51c0f2c09cb1b0b\",\"repository\":{\"id\":597426304,\"node_id\":\"R_kgDOI5wAgA\",\"name\":\"CI-server\",\"full_name\":\"hannapeters/CI-server\",\"private\":false,\"owner\":{\"name\":\"hannapeters\",\"email\":\"78764188+hannapeters@users.noreply.github.com\",\"login\":\"hannapeters\",\"id\":78764188,\"node_id\":\"MDQ6VXNlcjc4NzY0MTg4\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/78764188?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/hannapeters\",\"html_url\":\"https://github.com/hannapeters\",\"followers_url\":\"https://api.github.com/users/hannapeters/followers\",\"following_url\":\"https://api.github.com/users/hannapeters/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/hannapeters/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/hannapeters/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/hannapeters/subscriptions\",\"organizations_url\":\"https://api.github.com/users/hannapeters/orgs\",\"repos_url\":\"https://api.github.com/users/hannapeters/repos\",\"events_url\":\"https://api.github.com/users/hannapeters/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/hannapeters/received_events\",\"type\":\"User\",\"site_admin\":false},\"html_url\":\"https://github.com/hannapeters/CI-server\",\"description\":\"CI-server\",\"fork\":false,\"url\":\"https://github.com/hannapeters/CI-server\",\"forks_url\":\"https://api.github.com/repos/hannapeters/CI-server/forks\",\"keys_url\":\"https://api.github.com/repos/hannapeters/CI-server/keys{/key_id}\",\"collaborators_url\":\"https://api.github.com/repos/hannapeters/CI-server/collaborators{/collaborator}\",\"teams_url\":\"https://api.github.com/repos/hannapeters/CI-server/teams\",\"hooks_url\":\"https://api.github.com/repos/hannapeters/CI-server/hooks\",\"issue_events_url\":\"https://api.github.com/repos/hannapeters/CI-server/issues/events{/number}\",\"events_url\":\"https://api.github.com/repos/hannapeters/CI-server/events\",\"assignees_url\":\"https://api.github.com/repos/hannapeters/CI-server/assignees{/user}\",\"branches_url\":\"https://api.github.com/repos/hannapeters/CI-server/branches{main}\",\"tags_url\":\"https://api.github.com/repos/hannapeters/CI-server/tags\",\"blobs_url\":\"https://api.github.com/repos/hannapeters/CI-server/git/blobs{/sha}\",\"git_tags_url\":\"https://api.github.com/repos/hannapeters/CI-server/git/tags{/sha}\",\"git_refs_url\":\"https://api.github.com/repos/hannapeters/CI-server/git/refs{/sha}\",\"trees_url\":\"https://api.github.com/repos/hannapeters/CI-server/git/trees{/sha}\",\"statuses_url\":\"https://api.github.com/repos/hannapeters/CI-server/statuses/{sha}\",\"languages_url\":\"https://api.github.com/repos/hannapeters/CI-server/languages\",\"stargazers_url\":\"https://api.github.com/repos/hannapeters/CI-server/stargazers\",\"contributors_url\":\"https://api.github.com/repos/hannapeters/CI-server/contributors\",\"subscribers_url\":\"https://api.github.com/repos/hannapeters/CI-server/subscribers\",\"subscription_url\":\"https://api.github.com/repos/hannapeters/CI-server/subscription\",\"commits_url\":\"https://api.github.com/repos/hannapeters/CI-server/commits{/sha}\",\"git_commits_url\":\"https://api.github.com/repos/hannapeters/CI-server/git/commits{/sha}\",\"comments_url\":\"https://api.github.com/repos/hannapeters/CI-server/comments{/number}\",\"issue_comment_url\":\"https://api.github.com/repos/hannapeters/CI-server/issues/comments{/number}\",\"contents_url\":\"https://api.github.com/repos/hannapeters/CI-server/contents/{+path}\",\"compare_url\":\"https://api.github.com/repos/hannapeters/CI-server/compare/{base}...{head}\",\"merges_url\":\"https://api.github.com/repos/hannapeters/CI-server/merges\",\"archive_url\":\"https://api.github.com/repos/hannapeters/CI-server/{archive_format}{/ref}\",\"downloads_url\":\"https://api.github.com/repos/hannapeters/CI-server/downloads\",\"issues_url\":\"https://api.github.com/repos/hannapeters/CI-server/issues{/number}\",\"pulls_url\":\"https://api.github.com/repos/hannapeters/CI-server/pulls{/number}\",\"milestones_url\":\"https://api.github.com/repos/hannapeters/CI-server/milestones{/number}\",\"notifications_url\":\"https://api.github.com/repos/hannapeters/CI-server/notifications{?since,all,participating}\",\"labels_url\":\"https://api.github.com/repos/hannapeters/CI-server/labels{/name}\",\"releases_url\":\"https://api.github.com/repos/hannapeters/CI-server/releases{/id}\",\"deployments_url\":\"https://api.github.com/repos/hannapeters/CI-server/deployments\",\"created_at\":1675520087,\"updated_at\":\"2023-02-04T14:25:24Z\",\"pushed_at\":1675525654,\"git_url\":\"git://github.com/hannapeters/CI-server.git\",\"ssh_url\":\"git@github.com:hannapeters/CI-server.git\",\"clone_url\":\"https://github.com/ppplbngth/CI-server.git\",\"svn_url\":\"https://github.com/hannapeters/CI-server\",\"homepage\":null,\"size\":1,\"stargazers_count\":0,\"watchers_count\":0,\"language\":\"Java\",\"has_issues\":true,\"has_projects\":true,\"has_downloads\":true,\"has_wiki\":true,\"has_pages\":false,\"has_discussions\":false,\"forks_count\":0,\"mirror_url\":null,\"archived\":false,\"disabled\":false,\"open_issues_count\":0,\"license\":null,\"allow_forking\":true,\"is_template\":false,\"web_commit_signoff_required\":false,\"topics\":[],\"visibility\":\"public\",\"forks\":0,\"open_issues\":0,\"watchers\":0,\"default_branch\":\"main\",\"stargazers\":0,\"master_branch\":\"main\"},\"pusher\":{\"name\":\"hannapeters\",\"email\":\"78764188+hannapeters@users.noreply.github.com\"},\"sender\":{\"login\":\"hannapeters\",\"id\":78764188,\"node_id\":\"MDQ6VXNlcjc4NzY0MTg4\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/78764188?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/hannapeters\",\"html_url\":\"https://github.com/hannapeters\",\"followers_url\":\"https://api.github.com/users/hannapeters/followers\",\"following_url\":\"https://api.github.com/users/hannapeters/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/hannapeters/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/hannapeters/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/hannapeters/subscriptions\",\"organizations_url\":\"https://api.github.com/users/hannapeters/orgs\",\"repos_url\":\"https://api.github.com/users/hannapeters/repos\",\"events_url\":\"https://api.github.com/users/hannapeters/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/hannapeters/received_events\",\"type\":\"User\",\"site_admin\":false},\"created\":false,\"deleted\":false,\"forced\":false,\"base_ref\":null,\"compare\":\"https://github.com/hannapeters/CI-server/compare/f09985ddff7c...39c0e76f1db8\",\"commits\":[{\"id\":\"39c0e76f1db886e115ed6896b51c0f2c09cb1b0b\",\"tree_id\":\"aee5650186f431900a68e3c052b5aa56b34aec8b\",\"distinct\":true,\"message\":\"teststhewebhook\",\"timestamp\":\"2023-02-04T16:46:56+01:00\",\"url\":\"https://github.com/hannapeters/CI-server/commit/39c0e76f1db886e115ed6896b51c0f2c09cb1b0b\",\"author\":{\"name\":\"Hanna\",\"email\":\"hannamina@live.se\",\"username\":\"hannapeters\"},\"committer\":{\"name\":\"Hanna\",\"email\":\"hannamina@live.se\",\"username\":\"hannapeters\"},\"added\":[],\"removed\":[],\"modified\":[\"README.md\"]}],\"head_commit\":{\"id\":\"39c0e76f1db886e115ed6896b51c0f2c09cb1b0b\",\"tree_id\":\"aee5650186f431900a68e3c052b5aa56b34aec8b\",\"distinct\":true,\"message\":\"teststhewebhook\",\"timestamp\":\"2023-02-04T16:46:56+01:00\",\"url\":\"https://github.com/hannapeters/CI-server/commit/39c0e76f1db886e115ed6896b51c0f2c09cb1b0b\",\"author\":{\"name\":\"Hanna\",\"email\":\"hannamina@live.se\",\"username\":\"hannapeters\"},\"committer\":{\"name\":\"Hanna\",\"email\":\"hannamina@live.se\",\"username\":\"hannapeters\"},\"added\":[],\"removed\":[],\"modified\":[\"README.md\"]}}";

    /**
     * Tests the getCloneUrl function. The test should extract the proper url from the payload.
     * @throws ParseException
     */
    @Test
    public void positiveGetCloneUrl() throws ParseException{

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(payload);
        String result = Helpers.getCloneUrl(json);
        assertEquals(result, "https://github.com/ppplbngth/CI-server.git");
    
    }
    /**
     * Tests the getCloneUrl function. Tests that a url which is not equal to the clone-url is not equal.
     * @throws ParseException
     */
    @Test
    public void negativeGetCloneUrl() throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(payload);
        String result = Helpers.getCloneUrl(json);
        assertNotEquals(result, "https://github.com/ppplbngth/CI-server");
    }
    /**
     * Tests the getBranch function. The test should extract the proper branch ref from the payload.
     * @throws ParseException
     */
    @Test
    public void positiveGetBranch() throws ParseException{

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(payload);
        String result = Helpers.getBranch(json);
        assertEquals(result, "refs/heads/main");
    
    }
    /**
     * Tests the getBranch function. Tries a ref not equal to the branch ref in the payload.
     * @throws ParseException
     */
    public void negativeGetBranch() throws ParseException{

        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(payload);
        String result = Helpers.getBranch(json);
        assertEquals(result, "refs/heads/other-branch");
    
    }

}
