package pl.coderslab.charity.Repository;

import pl.coderslab.charity.Model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstitutionRepository extends JpaRepository<Institution,Long> {
    List<Institution> findAll();
}
