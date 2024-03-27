package uk.co.beachgeek.demo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class WelcomeController {

  @GetMapping("/")
  public String welcome(Model model) {
    model.addAttribute("projectUrl","/projects");
    return "welcome"; 
  }

}
