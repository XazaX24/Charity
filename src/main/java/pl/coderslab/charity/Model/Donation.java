package pl.coderslab.charity.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer quantity;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Category> categories;

    @OneToOne
    @JoinColumn(name="institution_id")
    private Institution institution;

    private String steeet;

    private String city;

    private String zipCode;

    private LocalDate pickUpDate;

    private LocalTime pickUpTime;

    private String pickUpComment;
}
