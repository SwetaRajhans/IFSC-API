package com.bank.ifsc.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bank.ifsc.model.BankModel;

public interface BankRepository extends JpaRepository<BankModel, String> {

	Optional<BankModel> findByIfsc(String ifsc);

	List<BankModel> findByBank(String bankName);

	
	@Query(value = "select distinct bank from bank_details", nativeQuery = true)
	List<String> findAllBank();

	@Query(value = "select distinct state from bank_details where bank=?1 ", nativeQuery = true)
	List<String> findState(String bankname);

	@Query(value = "select distinct district from bank_details where bank=?1 and state=?2", nativeQuery = true)
	List<String> findDistrict(String bankname, String state);

	@Query(value = "select distinct branch from bank_details where district=?1 and bank=?2 and state=?3", nativeQuery = true)
	List<String> findBranch(String district, String bankname, String state);

	@Query(value = "select * from bank_details where bank=?1 and state=?2 and district=?3 and branch=?4", nativeQuery = true)
	List<BankModel> findIfsc(String bankname, String state, String district, String branch);

	@Query(value = "select * from bank_details where bank=?1 and branch=?2", nativeQuery = true)
	List<BankModel> findBankByBranch(String bankname, String branch);
	
	

	
}
