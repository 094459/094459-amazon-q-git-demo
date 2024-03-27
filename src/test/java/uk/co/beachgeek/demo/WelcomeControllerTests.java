package uk.co.beachgeek.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

public class WelcomeControllerTests {

	private WelcomeController controller = new WelcomeController();
	
	@Test
	public void testWelcome() {
		Model model = Mockito.mock(Model.class);
		
		Mockito.when(model.addAttribute(anyString(), any())).thenReturn(null);

		String viewName = controller.welcome(model);
		assertEquals("welcome", viewName);

		
		assertEquals("welcome", viewName);
	}
}

