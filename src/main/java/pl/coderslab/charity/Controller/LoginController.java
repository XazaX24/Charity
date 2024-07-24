package pl.coderslab.charity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.Model.Donation;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model) {

        model.addAttribute("currentPage", "home");
        return "login";
    }
}
