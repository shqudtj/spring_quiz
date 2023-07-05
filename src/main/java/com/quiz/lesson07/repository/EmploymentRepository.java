package com.quiz.lesson07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.EmploymentEntity;

@Repository
public interface EmploymentRepository extends JpaRepository<EmploymentEntity, Integer> {

	public List<EmploymentEntity> findById(int id);
	public List<EmploymentEntity> findByCompanyId(int id);
	public List<EmploymentEntity> findByPositionAndType(String position, String type);
	public List<EmploymentEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<EmploymentEntity> findBySalaryGreaterThanEqual(int salary);
	public List<EmploymentEntity> findTop3ByTypeOrderBySalayDesc(String type);
	public List<EmploymentEntity> findByRegionAndSalaryBetween(String region, int start, int end);
	
	// native query
	@Query(value = "select * from employment where type = :type, deadline = :deadline, salary = :salary")
	public List<EmploymentEntity> findByTypeAndDeadLineGreaterThanAndSalaryGreaterThanEqual(
			@Param("type") String type, 
			@Param("deadline") String deadline, 
			@Param("salary") int salary);
	
}
