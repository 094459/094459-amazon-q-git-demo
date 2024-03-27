package uk.co.beachgeek.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProjectsControllerTests {
	
	private ProjectsController controller;

	@BeforeEach
	public void setup() {
		controller = new ProjectsController();
	}

	@Test
	public void testGetProjects() throws Exception {
		List<Project> projects = controller.getProjects();
		
		assertNotNull(projects);
		assertTrue(projects.size() > 0);
	}

}

