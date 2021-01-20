package eu.intro.oke.controllers;
import eu.intro.oke.model.Recipe;
import eu.intro.oke.service.DoctorService;
import eu.intro.oke.service.PatientService;
import eu.intro.oke.service.RecipeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import eu.intro.oke.model.Doctor;
import eu.intro.oke.model.Patient;
import org.springframework.web.bind.annotation.RequestBody;

        
@Controller

public class RecipeController {

private final RecipeService service;
private final PatientService patientService;
private final DoctorService doctorService;
@Autowired
public RecipeController(RecipeService service,PatientService patientService,DoctorService doctorService){
    this.service=service;
    this.doctorService=doctorService;
    this.patientService=patientService;
}

        
@GetMapping("/recipes")
public String findAll(Model model){
    List<Recipe>recipes=service.findAll();
    model.addAttribute("recipes",recipes);
    return "recipe-list";
}
@GetMapping("/recipes/create")
public String createRecipeForm(Recipe recipe,Model model){
   List<Doctor>s1=doctorService.findAll();
   model.addAttribute("s1",s1);
   List<Patient>s2=patientService.findAll();
   model.addAttribute("s2",s2);
    return "recipe-create";
}
@PostMapping("/recipes/create")
public String createRecipe(Recipe recipe){
    service.save(recipe);
    return "redirect:/recipes";
}
@GetMapping("/recipes/{id}/delete")
public String deleterecipe(@PathVariable("id")Long id){
    service.delete(id);
    return "redirect:/recipes";
}
@GetMapping("/recipes/{id}/update")
public String updateRecipeForm(@PathVariable("id") Long id,Model model){
    Recipe recipe = service.findbyid(id);
    model.addAttribute("recipe",recipe);
    return "recipe-update";
}
@PostMapping("/recipes/update")
public String updateRecipe(Recipe recipe){
    service.save(recipe);
    return "redirect:/recipes";
}
}