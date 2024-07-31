package pl.coderslab.charity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class AdminsTableController {

    @GetMapping("/admins")
    public String admins(Model model){

        return "admins";
    }
}
