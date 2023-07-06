package com.quiz.lesson07;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.EmploymentEntity;
import com.quiz.lesson07.repository.EmploymentRepository;

@RestController
@RequestMapping("/lesson07/quiz02")
public class Lesson07Quiz02RestController {

	@Autowired
	private EmploymentRepository employmentRepository; 
	
	@GetMapping("/1")
	public List<EmploymentEntity> getEmploymentList() {
		// id가 8인 공고
		return employmentRepository.findById(8);
	}
	
	@GetMapping("/2")
	// companyid : 1
	public List<EmploymentEntity> getEmploymentList(
				@RequestParam("companyId") int id
			) {
		
		return employmentRepository.findByCompanyId(id);
	}
	
	@GetMapping("/3")
	//웹 back-end 개발자 이고 정규직
	public List<EmploymentEntity> getEmploymentListByPositionAndType() {
		return employmentRepository.findByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
//	정규직이거나 연봉이 9000 이상
	@GetMapping("/4")
	public List<EmploymentEntity> getEmploymentListByTypeOrSalary() {
		return employmentRepository.findByTypeOrSalaryGreaterThanEqual("정규직", 9000);
//		return employmentRepository.findBySalaryGreaterThanEqual(9000);
	}
	
	@GetMapping("/5")
//	계약직 목록을 연봉 기준으로 내림차순 정렬해서 3개
	public List<EmploymentEntity> getEmploymentListByTypeOrderByDesc() {
		return employmentRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	@GetMapping("/6")
//	성남시 분당구가 지역인 연봉 7000 이상 8500 이하인 공고
	public List<EmploymentEntity> getEmploymentListByRegion() {
		return employmentRepository.findByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	@GetMapping("/7")
//	마감일이 2026-04-10 이후이고 연봉이 8100 이상인 정규직 공고를 연봉 내림차순
	public List<EmploymentEntity> getEmploymentListByDeadline() {
		return employmentRepository.findByDeadLineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc(
				"2026-04-10", 8100, "정규직");
	}
	
	@GetMapping("/8")
	public List<EmploymentEntity> getEmploymentListBySalay() {
		return employmentRepository.findBySalary(9000);
	}
}





