package com.example.project_spring_boot.services;


import com.example.project_spring_boot.dto.SimpleResponse;
import com.example.project_spring_boot.exceptions.CompanyNotFoundException;
import com.example.project_spring_boot.exceptions.CourseIsAlreadyAssignedException;
import com.example.project_spring_boot.models.Company;
import com.example.project_spring_boot.models.Course;
import com.example.project_spring_boot.repositories.CompanyRepository;
import com.example.project_spring_boot.repositories.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;


@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    private final CourseRepository courseRepository;

    public List<Company> findAllCompanies() {
        return companyRepository.findAll();
    }


    public Company findByCompanyId(Long id) {
        return companyRepository.findById(id).orElseThrow(() -> new CompanyNotFoundException());
    }

    public Company save(Company company) {

        return companyRepository.save(company);
    }

    public SimpleResponse deleteById(Long id) {
        boolean exists = companyRepository.existsById(id);
        if (!exists) {
            throw new CompanyNotFoundException();
        }
        companyRepository.deleteById(id);
        return new SimpleResponse("DELETED", "Company successfully deleted");

    }

    @Transactional
    public Company update(Long id, Company company) {
        Company com = findByCompanyId(id);
        com.setCompanyName(company.getCompanyName());
        com.setLocatedCountry(company.getLocatedCountry());
        return com;
    }

    @Transactional
    public Company addCourseToCompany(Long companyId, Long courseId) {
        Company company = findByCompanyId(companyId);
        Course course = courseRepository.getById(courseId);
        if (Objects.nonNull(course.getCompany())) {
            throw new CourseIsAlreadyAssignedException(courseId, course.getCompany().getId());
        }
        company.setCourse(course);
        course.setCompany(company);
        return company;
    }

    @Transactional

    public Company removeCourseFromCompany(Long companyId, Long courseId) {
        Company company = findByCompanyId(companyId);
        Course course = courseRepository.getById(courseId);
        company.removeCourse(course);
        return company;
    }
}
