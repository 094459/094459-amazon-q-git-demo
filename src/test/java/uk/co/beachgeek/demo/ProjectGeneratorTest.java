// SPDX-License-Identifier: MIT
package uk.co.beachgeek.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ProjectGeneratorTest {

  @Test
  public void testGenerateProjects() {
    List<Project> projects = ProjectGenerator.generateProjects();
    
    assertEquals(10, projects.size());
  }
  
}

