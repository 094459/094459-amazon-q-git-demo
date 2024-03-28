package uk.co.beachgeek.demo;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
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

  public AmazonS3 s3Client;

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

    List<Project> projectList = Arrays.asList(projects);
    
    // Upload project list to S3    
    //AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
    AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
      .withRegion("eu-west-2")
      .build();
    s3Client.putObject("094459-s3-github", "projects.json", 
      mapper.writeValueAsString(projectList));
      
    return projectList;
    
  }

}

