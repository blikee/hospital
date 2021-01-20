/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.intro.oke.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import eu.intro.oke.model.Recipe;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    @Query(value = "SELECT * FROM recipe r INNER JOIN doctor d ON r.doctorid=d.id INNER JOIN patient p ON r.patientid=p.id;",nativeQuery=true)
    public List<Recipe> findAll();
    
    
}
