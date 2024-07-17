package pl.coderslab.charity.Repository;

import pl.coderslab.charity.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
