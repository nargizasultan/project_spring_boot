package com.example.project_spring_boot.dto;

import com.example.project_spring_boot.models.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlainCompanyDto {
    private Long id;
    private String companyName;
    private String locatedCountry;

    public static PlainCompanyDto from(Company company){
        PlainCompanyDto plainCompanyDto = new PlainCompanyDto();
        plainCompanyDto.setCompanyName(company.getCompanyName());
        plainCompanyDto.setId(company.getId());
        plainCompanyDto.setLocatedCountry(company.getLocatedCountry());
        return plainCompanyDto;
    }
}
