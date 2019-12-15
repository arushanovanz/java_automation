package ru.stqa.pft.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import org.testng.SkipException;

import java.io.IOException;
import java.util.Set;


public class TestBase {



  public void skipIfNotFixed(int issueId) throws IOException {
    if (isIssueOpen(issueId)) {
      throw new SkipException("Ignored because of issue " + issueId);
    }
  }

  public boolean isIssueOpen(int issueId) throws IOException {
//    String json = RestAssured.given().parameter("limit","200")
//            .get( "https://bugify.stqa.ru/api/issues.json").asString();
//    JsonElement parsed = JsonParser.parseString(json);
//    Set<Issue> issues= Gson.fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
//
//    for (Issue issue: issues){
//111
//    }
    return false;
  }

  public int createIssue(Issue newIssue) throws IOException {
    String json = RestAssured.given().parameter("subject",newIssue.getSubject())
            .parameter("description", newIssue.getDescription())
            .post("https://bugify.stqa.ru/api/issues.json").asString();
    JsonElement parsed = JsonParser.parseString(json);
    return parsed.getAsJsonObject().get("issue_id").getAsInt();
  }

  public Set<Issue> getIssues() throws IOException {
    String json = RestAssured.given().parameter("limit","200")
            .get( "https://bugify.stqa.ru/api/issues.json").asString();
    JsonElement parsed = JsonParser.parseString(json);
    JsonElement issues = parsed.getAsJsonObject().get("issues");
    return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());

  }
}
