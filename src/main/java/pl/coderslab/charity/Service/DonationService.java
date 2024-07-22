package pl.coderslab.charity.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Model.Donation;
import pl.coderslab.charity.Repository.DonationRepository;

@Service
public class DonationService {

    @Autowired
    DonationRepository donationRepository;

    public String save(Donation donation){
        donationRepository.save(donation);
        return "ok";
    }
}
