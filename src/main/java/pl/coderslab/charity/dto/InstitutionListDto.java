package pl.coderslab.charity.dto;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.Model.Institution;

@Getter
@Setter
public class InstitutionListDto {
    private Institution firstColumn;
    private Institution secondColumn;

    public InstitutionListDto(Institution fristColumn, Institution secondColumn) {
        this.firstColumn = fristColumn;
        this.secondColumn = secondColumn;
    }
}
