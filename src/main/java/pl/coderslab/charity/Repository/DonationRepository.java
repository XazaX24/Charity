package pl.coderslab.charity.Repository;

import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.Model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation,Long> {

    @Query("SELECT sum(quantity) FROM Donation")
    public int allQuantity();

    @Query("SELECT count(*) FROM Donation")
    public int allDonation();
}
