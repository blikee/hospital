/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.intro.oke.controllers;

import eu.intro.oke.service.PatientService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import eu.intro.oke.model.Patient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PatientController {
    private final PatientService patientService;
    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }
    @GetMapping("/patients")
    public String findAll(Model model){
        List<Patient>patient=patientService.findAll();
        model.addAttribute("patients1",patient);
        return "patient-list";
    }
    @GetMapping("/patients/create")
    public String createPatientForm(Patient patient){
        return "patient-create";
    }
    @PostMapping("/patients/create")
    public String createPatient(Patient patient){
        patientService.savePatient(patient);
        return "redirect:/patients";
    }
    @GetMapping("/patients/{id}/edit")
    public String updatePatientForm(@PathVariable("id") Long id,Model model){
        Patient patient=patientService.findById(id);
        model.addAttribute("patient",patient);
        return "patient-update";
    }
    @PostMapping("/patients/edit")
    public String updatePatient(Patient patient){
        patientService.savePatient(patient);
        return "redirect:/patients";
    }
    @GetMapping("/patients/{id}/remove")
    public String deletePatient(@PathVariable("id") Long id){
        patientService.deleteById(id);
        return "redirect:/patients";
    }
}
