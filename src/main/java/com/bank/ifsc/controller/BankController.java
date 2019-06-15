package com.bank.ifsc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bank.ifsc.model.BankModel;
import com.bank.ifsc.repository.BankRepository;
import com.bank.utilities.Utility;




@RestController
@RequestMapping("/api")
public class BankController {

	@Autowired
	private BankRepository bankrepository;
	
	@GetMapping("/bankdetail/{ifsc}")
	public ResponseEntity<?> getBank( @PathVariable (value = "ifsc") String ifsc ){
		
		List<BankModel> bankdata=bankrepository.findByIfsc(ifsc);
		
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success",bankdata.size(), bankdata));
	}
	
	@GetMapping("/bankbyname/{bankname}")
	public ResponseEntity<?> getByBank(@PathVariable (value = "bankname") String bankName){
		List<BankModel> bankdata=bankrepository.findByBank(bankName);
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", bankdata.size(), bankdata));
	}
	
	@GetMapping("/allbank")
	public ResponseEntity<?> getAllBank(){
		List<String> bankName=bankrepository.findAllBank();
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", bankName.size(), bankName));
	}  
	
	@GetMapping("/state/{bankname}")
	public ResponseEntity<?> getStateByBank(@PathVariable (value = "bankname") String bankname){
		List<String> state=bankrepository.findState(bankname);
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", state.size(), state));
	}
	
	@GetMapping("/district/{bankname}/{state}")
	public ResponseEntity<?> getDistrict(@PathVariable (value = "bankname") String bankname,@PathVariable (value = "state") String state){
	
	List<String> district=bankrepository.findDistrict(bankname,state);
	return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", district.size(), district));
	}
	
	@GetMapping("/branch/{bankname}/{state}/{district}")
	public ResponseEntity<?> getBranch(@PathVariable (value = "district") String district ,@PathVariable (value = "bankname") String bankname,@PathVariable (value = "state") String state){
	
	List<String> branch=bankrepository.findBranch(district,bankname,state);
	return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", branch.size(), branch));
	}
	@GetMapping("/ifsc/{bankname}/{state}/{district}/{branch}")
	public ResponseEntity<?> getIfsc(@PathVariable (value = "branch") String branch,@PathVariable (value = "district") String district ,@PathVariable (value = "bankname") String bankname,@PathVariable (value = "state") String state){
	
		List<BankModel> ifscdetails=bankrepository.findIfsc(bankname,state,district,branch);
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", ifscdetails.size(), ifscdetails));
	}
	@GetMapping("/bankdetail/{bankname}/{branch}")
	public ResponseEntity<?> getBankByBranch(@PathVariable (value = "bankname") String bankname,@PathVariable (value = "branch") String branch){
		List<BankModel> bankdetail=bankrepository.findBankByBranch(bankname,branch);
		return ResponseEntity.status(HttpStatus.OK).body(Utility.getResponse("Success", bankdetail.size(), bankdetail));
	}
	
}
