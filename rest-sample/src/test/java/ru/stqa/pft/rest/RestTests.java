package ru.stqa.pft.rest;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.message.BasicNameValuePair;
import org.testng.annotations.Test;

import java.io.IOException;

import java.util.Set;


import static org.testng.AssertJUnit.assertEquals;

public class RestTests {
  @Test(enabled = false)
  public void testCreateIssue() throws IOException {
    Set<Issue> oldIssues = getIssues();
    Issue newIssue = new Issue().withSubject("Test issue ").withDescription("New Test Issue");
    int issueId = createIssue(newIssue);
    Set<Issue> newIssues = getIssues();
    oldIssues.add(newIssue.withId(issueId));
    assertEquals(newIssues,oldIssues);
  }


  private Set<Issue> getIssues() throws IOException {
    String json = getExecutor()
            .execute(Request.Get("http://demo.bugify.com/api/issues.json")).returnContent().asString();
    JsonElement parsed = JsonParser.parseString(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());

  }

  private Executor getExecutor() {
    return Executor.newInstance().auth( "814ab0b5d9ac02af6e51ffefb20a4d38","");
  }

  private int createIssue(Issue newIssue) throws IOException {
    String json =  getExecutor()
            .execute(Request.Post("http://demo.bugify.com/api/issues.json")
            .bodyForm(new BasicNameValuePair("subject",newIssue.getSubject()),
                      new BasicNameValuePair("description", newIssue.getDescription())))
            .returnContent().asString();
    JsonElement parsed = JsonParser.parseString(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }

}
