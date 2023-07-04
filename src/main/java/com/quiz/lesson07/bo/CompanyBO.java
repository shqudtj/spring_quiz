package com.quiz.lesson07.bo;

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
	
}
