package pl.coderslab.charity.Repository;

import pl.coderslab.charity.Model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation,Long> {
}
