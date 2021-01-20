/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.intro.oke.service;
import eu.intro.oke.model.Recipe;
import eu.intro.oke.repository.RecipeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
        
@Service
public class RecipeService {
   private final RecipeRepository repository;
   @Autowired
   public RecipeService(RecipeRepository repository){
       this.repository=repository;
   }
  
   public List<Recipe> findAll(){
       return repository.findAll();
   }
   public Recipe findbyid(Long id){
       return repository.getOne(id);
   }
   public Recipe save(Recipe recipe){
       return repository.save(recipe);
   }
   public void delete(Long id){
       repository.deleteById(id);
   }
}
