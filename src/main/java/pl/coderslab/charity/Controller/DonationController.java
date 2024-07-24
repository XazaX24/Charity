package pl.coderslab.charity.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.Model.Category;
import pl.coderslab.charity.Model.Donation;
import pl.coderslab.charity.Repository.CategoryRepository;
import pl.coderslab.charity.Service.DonationService;
import pl.coderslab.charity.Service.InstitutionService;

@Slf4j
@Controller
public class DonationController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    InstitutionService institutionService;

    @Autowired
    DonationService donationService;

    @GetMapping("/form")
    public String donation(Model model) {

        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("institutions", institutionService.allInstitutions());
        model.addAttribute("currentPage", "home");
        return "form";
    }

    @PostMapping("/form")
    public String donationAdd(Donation donation, Model model) {
        // Weryfikacja ID kategorii
        for (Category category : donation.getCategories()) {
//            if (category.getId() == null) {
                log.error("Category ID is null for category: " + category.getName());
 //           }
        }
        donationService.save(donation);
        return "form-confirmation";
    }

}
