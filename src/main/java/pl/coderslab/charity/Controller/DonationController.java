package pl.coderslab.charity.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.Repository.CategoryRepository;
import pl.coderslab.charity.Service.InstitutionService;

@Controller
public class DonationController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    InstitutionService institutionService;

    @RequestMapping("/donationAdd")
    public String donationAdd(Model model) {

        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionService.allInstitutions());
        model.addAttribute("currentPage", "home");
        return "form";
    }

}
