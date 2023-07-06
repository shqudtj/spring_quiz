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
	public List<EmploymentEntity> findByCompanyId(int companyId);
	public List<EmploymentEntity> findByPositionAndType(String position, String type);
	public List<EmploymentEntity> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	public List<EmploymentEntity> findBySalaryGreaterThanEqual(int salary);
	public List<EmploymentEntity> findTop3ByTypeOrderBySalaryDesc(String type);
	public List<EmploymentEntity> findByRegionAndSalaryBetween(String region, int start, int end);
	
	public List<EmploymentEntity> findBySalary(int salary);
	
	
	
	// native query => DB에 직접 조회 (My sql 쿼리문)
	@Query(value = "select * from employment where deadline > :deadline and salary >= :salary and type = :type order by salary desc", nativeQuery = true)
	public List<EmploymentEntity> findByDeadLineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc(
			@Param("deadline") String deadline, 
			@Param("salary") int salary, 
			@Param("type") String type);
	
}
