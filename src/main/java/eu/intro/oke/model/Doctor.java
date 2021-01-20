/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.intro.oke.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;


@Entity
@Data
@Table(name="doctor")

public class Doctor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="имя")
    private String name;
    
    @Column(name="фамилия")
    private String lastname;
    
    @Column(name="отчество")
    private String dadname;
    
    @Column(name="специализация")
    private String specialize;

    @OneToMany(mappedBy = "doctor",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Recipe> recipe;

   
  
    
}
