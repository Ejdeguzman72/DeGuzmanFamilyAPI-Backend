package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.app_models.MedicalTransaction;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.exception.ResourceNotFoundException;
import com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.repository.MedicalTransactionRepository;

@Service
public class MedicalTransactionService {

	@Autowired
	private MedicalTransactionRepository medicalTransactionRepository;
	
	// returns the Medical transactions in a list
	public List<MedicalTransaction> findAllMedicalTransactionInformation() {
		return medicalTransactionRepository.findAll();
	}
	
	// based on the pathvariable thrown, this returns the Medical Transaction object that has the corresponding ID
	public ResponseEntity<MedicalTransaction> findMedicalTransactionInformationbyId(@PathVariable Long medicalTransactionId) throws ResourceNotFoundException {
		MedicalTransaction medicalTransaction = medicalTransactionRepository.findById(medicalTransactionId)
				.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
		return ResponseEntity.ok().body(medicalTransaction);
	}
	
	// creates an MedicalTransaction object based off the fields that are filled.
	public MedicalTransaction addMedicalTransactionInformation(@Valid @RequestBody MedicalTransaction medicalTransaction) {
		return medicalTransactionRepository.save(medicalTransaction);
	}
	
	// updates the MedicalTransaction based on the id number entered. Once the fields are updated, then a new Auto
		// Transaction object is created.
	public ResponseEntity<MedicalTransaction> updateMedicalTransaction(@PathVariable Long medicalTransactionId,
			@Valid @RequestBody MedicalTransaction medicalTransactionDetails) {
		MedicalTransaction medicalTransaction = null;
		try {
			medicalTransaction = medicalTransactionRepository.findById(medicalTransactionId)
					.orElseThrow(() -> new ResourceNotFoundException("Not Found"));
			medicalTransaction.setAmount(medicalTransactionDetails.getAmount());
			medicalTransaction.setMedicalEntityId(medicalTransaction.getMedicalEntityId());
			medicalTransaction.setMedicalTransactionDate(medicalTransactionDetails.getMedicalTransactionDate());
			medicalTransaction.setPersonId(medicalTransactionDetails.getMedicalEntityId());
		}
		catch (ResourceNotFoundException e)  {
			e.printStackTrace();
		}
		final MedicalTransaction updatedMedicalTransaction = medicalTransactionRepository.save(medicalTransaction);
		return ResponseEntity.ok().body(updatedMedicalTransaction);
	}
	
	public Map<String,Boolean> deleteMedicalTransactionInformation(@PathVariable Long medicalTransactionId) {
		medicalTransactionRepository.deleteById(medicalTransactionId);
		Map<String,Boolean> response = new HashMap<>();
		response.put("Medical Transaction deleted", Boolean.TRUE);
		return response;
		
	}
}
