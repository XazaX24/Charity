package pl.coderslab.charity.Service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.Model.Donation;
import pl.coderslab.charity.Repository.DonationRepository;

@Service
public class DonationService {

    @Autowired
    DonationRepository donationRepository;

    @Transactional
    public String save(Donation donation){
        donationRepository.save(donation);
        return "ok";
    }
}
