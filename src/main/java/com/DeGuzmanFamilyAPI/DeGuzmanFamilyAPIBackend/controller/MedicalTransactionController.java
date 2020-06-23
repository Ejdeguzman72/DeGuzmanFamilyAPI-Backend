package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.models.MedicalTransaction;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service.MedicalTransactionService;

@RestController
@RequestMapping("/app/medical-transactions")
@CrossOrigin
public class MedicalTransactionController {

	@Autowired
	private MedicalTransactionService medicalTransactionService;
	
	@GetMapping("/all")
	public List<MedicalTransaction> getAllMedicalTransactionInformation() {
		return medicalTransactionService.findAllMedicalTransactionInformation();
	}
	
	@GetMapping("/medical-transaction/{medicalTransactionId}")
	public ResponseEntity<MedicalTransaction> getMedicalTransactionInformationById(@PathVariable Long medicalTranscationId) throws ResourceNotFoundException {
		return medicalTransactionService.findMedicalTransactionInformationbyId(medicalTranscationId);
	}
	
	@PostMapping("/add-medical-transaction")
	public MedicalTransaction addMedicalTransactionController(@Valid @RequestBody MedicalTransaction medicalTransaction) {
		return medicalTransactionService.addMedicalTransactionInformation(medicalTransaction);
	}
	
	@PutMapping("/medical-transaction/{medicalTransactionId}")
	public ResponseEntity<MedicalTransaction> updateMedicalTransactionController(@PathVariable Long medicalTransactionId,
			@Valid @RequestBody MedicalTransaction medicalTransactionDetails) {
		return medicalTransactionService.updateMedicalTransaction(medicalTransactionId, medicalTransactionDetails);
	}
	
	@DeleteMapping("/medical-transaction/{medicalTransactionId")
	public Map<String,Boolean> deleteMedicalTransactionInfoController(@PathVariable Long medicalTransactionId) {
		return medicalTransactionService.deleteMedicalTransactionInformation(medicalTransactionId);
	}
}