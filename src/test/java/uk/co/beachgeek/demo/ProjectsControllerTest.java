package uk.co.beachgeek.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProjectsControllerTest {

  @Autowired
  ProjectsController projectsController;

  @Test
  void getProjects() throws Exception {

    // Call the method under test
    List<Project> projects = projectsController.getProjects();

    // Add assertions
    assertNotNull(projects);
    assertEquals(10, projects.size());

  }

}

