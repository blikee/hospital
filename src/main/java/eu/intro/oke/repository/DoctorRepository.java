/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.intro.oke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.intro.oke.model.Doctor;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    
      @Query("select distinct d FROM  Doctor d left join fetch d.recipe")
    public List<Doctor> findAll();
    
   
}
