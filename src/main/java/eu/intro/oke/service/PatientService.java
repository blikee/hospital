/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.intro.oke.service;

import eu.intro.oke.repository.PatientRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eu.intro.oke.model.Patient;

@Service
public class PatientService {
   private final PatientRepository repository;
    
    @Autowired
    public PatientService(PatientRepository repository){
        this.repository=repository;
    }
    public List<Patient> findAll(){
        return repository.findAll();
    }
    public Patient findById(Long id){
        return repository.getOne(id);
    }
    public Patient savePatient(Patient patient){
        return repository.save(patient);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
    
}
