package com.quiz.lesson07.bo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {

	@Autowired
	private CompanyRepository companyRepository;
	
	// input: 파라미터들
	// output: entity
	public CompanyEntity addCompany(String name, String business, String scale,	int headcount) {
		CompanyEntity company = companyRepository.save(
					CompanyEntity.builder()	// builder가 안뜨면 project란의 clean실행
					.name(name)
					.business(business)
					.scale(scale)
					.headcount(headcount)
					.build()
				);
				
		return company;
	}
	
	// input: id, scale, headcount
	// output: CompanyEntity
	public CompanyEntity updateCompanyById(int id, String scale, int headcount) {
		
		CompanyEntity company = companyRepository.findById(id).orElse(null);
		
		if (company != null) {
			company = company.toBuilder() //Entity파트에 build에 어노테이션해줘야함 =>@Builder(toBuilder = true)
					.scale(scale)
					.headcount(headcount)
					.build();
			company = companyRepository.save(company);
		}
		
		return company;
	}
	
	public void deleteCompanyById(int id) {
		// 방법1)
//		CompanyEntity company = companyRepository.findById(id).orElse(null);
//		if (company != null) {
//			companyRepository.deleteById(id);
//		}
		
		// 방법2)
		Optional<CompanyEntity> companyOptional = companyRepository.findById(id);
		companyOptional.ifPresent(c -> companyRepository.delete(c));
	}
	
}
