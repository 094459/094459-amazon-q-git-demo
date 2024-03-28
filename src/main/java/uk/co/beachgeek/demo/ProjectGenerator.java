// SPDX-License-Identifier: MIT 
package uk.co.beachgeek.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectGenerator {

  public static List<Project> generateProjects() {
    List<Project> projects = new ArrayList<>();
    Random random = new Random();
    
    for (int i = 0; i < 10; i++) {
      Project project = new Project();
      project.setName("Project " + i);
      project.setFull_name("Owner/" + project.getName());
      project.setId(Integer.toString(random.nextInt()));
      
      projects.add(project);
    }
    
    return projects;
  }
  
}

