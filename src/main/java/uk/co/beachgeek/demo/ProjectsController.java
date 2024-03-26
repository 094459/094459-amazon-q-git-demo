package uk.co.beachgeek.demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Controller class for managing Project resources.
 * 
 * This controller provides an endpoint for retrieving a list of Projects 
 * from the GitHub API. It makes a GET request to the GitHub API, parses 
 * the JSON response, and returns a List of Project objects.
 */


@RestController
public class ProjectsController {

  @GetMapping("/projects")
  public List<Project> getProjects() throws IOException {

    String url = "https://api.github.com/orgs/aws-samples/repos?per_page=10";

    OkHttpClient client = new OkHttpClient();
    Request request = new Request.Builder()
      .url(url)
      .build();

    Response response = client.newCall(request).execute();
    String json = response.body().string();

    ObjectMapper mapper = new ObjectMapper();
    Project[] projects = mapper.readValue(json, Project[].class);

    return Arrays.asList(projects);
  }

}

