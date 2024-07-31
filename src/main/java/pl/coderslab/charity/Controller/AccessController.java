package pl.coderslab.charity.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.Model.User;
import pl.coderslab.charity.Service.UserService;

@Controller
@RequiredArgsConstructor
public class AccessController {

    private final UserService userService;

    @GetMapping("/register")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("register")
    public String createUser(User user, Model model) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "register";
        }
        model.addAttribute("success", true);
        return "login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/login/fail")
    public String loginFailedPage() {
        return "login-failed";
    }

    @GetMapping("/403")
    public String unauthorized() {
        return "403";
    }

    @GetMapping("/logout")
    public String logout() {
        return "logout";
    }
}