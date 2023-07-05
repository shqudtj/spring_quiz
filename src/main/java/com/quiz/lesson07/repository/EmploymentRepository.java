package com.quiz.lesson07.repository;

import java.time.LocalDate;
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
	public List<EmploymentEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<EmploymentEntity> findByRegionAndSalaryBetween(String region, int start, int end);
	
	public List<EmploymentEntity> findBySalary(int salary);
	
	
	
	// native query
	@Query(value = "select * from employment where type = :type, deadline >= :deadline, salary >= :salary", nativeQuery = true)
	public List<EmploymentEntity> findByTypeAndDeadLineAfterAndSalaryGreaterThanEqual(
			@Param("type") String type, 
			@Param("deadline") LocalDate deadline, 
			@Param("salary") int salary);
	
}
