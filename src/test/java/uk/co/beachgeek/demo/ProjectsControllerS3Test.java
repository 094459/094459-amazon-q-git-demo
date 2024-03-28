package uk.co.beachgeek.demo;

import static org.mockito.Mockito.*;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class ProjectsControllerS3Test {

  @Test
  public void testS3Upload() throws Exception {
    
    AmazonS3 s3ClientMock = mock(AmazonS3.class);
    ProjectsController controller = new ProjectsController();
    //controller.s3Client = s3ClientMock; // Inject mock
     controller.s3Client = AmazonS3ClientBuilder.defaultClient();


    controller.getProjects();
    
    // Verify S3 upload was called properly
    ArgumentCaptor<String> bucketArg = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<String> keyArg = ArgumentCaptor.forClass(String.class);
    ArgumentCaptor<String> contentArg = ArgumentCaptor.forClass(String.class);
    verify(s3ClientMock).putObject(bucketArg.capture(), keyArg.capture(), contentArg.capture());
    assert bucketArg.getValue().equals("my-bucket");
    assert keyArg.getValue().equals("projects.json");
  }
}
