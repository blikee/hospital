/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.intro.oke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.intro.oke.model.Patient;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Артём
 */
@Repository
public interface PatientRepository extends JpaRepository<Patient,Long> {
    
}
