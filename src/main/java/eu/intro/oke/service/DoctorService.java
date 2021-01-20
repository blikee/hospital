/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.intro.oke.service;

import eu.intro.oke.repository.DoctorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eu.intro.oke.model.Doctor;
import org.springframework.data.jpa.repository.Query;

@Service
public class DoctorService {
    
    private final DoctorRepository repository;
    @Autowired
    public DoctorService(DoctorRepository repository){
        this.repository=repository;
    }
   
    public List<Doctor> findAll(){
        return repository.findAll();
    }
    public Doctor getById(Long id){
        return repository.getOne(id);
    }
    public Doctor save(Doctor doctor){
        return repository.save(doctor);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
