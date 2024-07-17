package pl.coderslab.charity.Service;

import pl.coderslab.charity.Model.Institution;
import pl.coderslab.charity.Repository.InstitutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.dto.InstitutionListDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstitutionService {

    @Autowired
    private InstitutionRepository institutionRepository;

    public List<Institution> allInstitutions(){
        return institutionRepository.findAll();
    }

    public List<InstitutionListDto> institutionList(){
        List<Institution> allInstitutionList = allInstitutions();
        List<InstitutionListDto> institutionListDtos = new ArrayList<>();
        for(int i=0;i<allInstitutionList.size();i+=2){
            institutionListDtos.add(new InstitutionListDto(
                    allInstitutionList.get(i),
                    (i+1<allInstitutionList.size())? allInstitutionList.get(i+1) : new Institution()
            ));
        }
        return institutionListDtos;
    }

}
