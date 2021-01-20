/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.intro.oke.controllers;

import eu.intro.oke.service.DoctorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import eu.intro.oke.model.Doctor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DoctorController {
    private final DoctorService service;
    @Autowired
    public DoctorController(DoctorService service){
        this.service=service;
    }
   
    @GetMapping("")
    public String main(){
        return "main-list";}
        
    @GetMapping("/doctors")
    public String findAll(Model model){
         List<Doctor>doctors=service.findAll();
        model.addAttribute("doctors",doctors);
       
        return "doctor-list";
    } 
    @GetMapping("/doctors/create")
    public String createDoctorForm(Doctor doctor){
        return "doctor-create";
    }
    @PostMapping("/doctors/create")
    public String createDoctor(Doctor doctor){
        service.save(doctor);
        return "redirect:/doctors";
    }
    @GetMapping("/doctors/{id}/update")
    public String updateDoctorForm(@PathVariable("id")Long id,Model model){
        Doctor doctor=service.getById(id);
        model.addAttribute("doctor",doctor);
        return "doctor-update";
    }
    @PostMapping("/doctors/update")
    public String updateDoctor(Doctor doctor){
        service.save(doctor);
        return "redirect:/doctors";
    }
    @GetMapping("/doctors/{id}/delete")
    public String deleteDoctor(@PathVariable("id")Long id){
        service.deleteById(id);
        return "redirect:/doctors";
    }
}
