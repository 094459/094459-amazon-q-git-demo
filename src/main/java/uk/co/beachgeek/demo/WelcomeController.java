// SPDX-License-Identifier: MIT
package uk.co.beachgeek.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.lang.Nullable;

@Controller
public class WelcomeController {

@GetMapping("/")
  public String welcome(@Nullable Model model) {
    if(model == null) {
        throw new IllegalArgumentException("Model cannot be null"); 
      }
    model.addAttribute("projectUrl","/projects");
    model.addAttribute("projects", ProjectGenerator.generateProjects());
    return "welcome"; 
  }

}

