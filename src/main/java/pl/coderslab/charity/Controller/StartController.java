package pl.coderslab.charity.Controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.coderslab.charity.Repository.DonationRepository;
import pl.coderslab.charity.Service.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StartController {

    @Autowired
    private InstitutionService institutionService;

    @Autowired
    private DonationRepository donationRepository;

    @RequestMapping("/")
    public String start(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        model.addAttribute("username",username);
        model.addAttribute("quantityCount",donationRepository.allQuantity());
        model.addAttribute("donationCount",donationRepository.allDonation());
        model.addAttribute("institutions",institutionService.institutionList());
        model.addAttribute("currentPage", "home");
        return "index";
    }

}
