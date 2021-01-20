/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.intro.oke.model;

import java.sql.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.Type;

@Entity
@Data
@Table(name="recipe")

public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="описание")
    private String description;
    
    @Column(name="дата_создания")
    private int createdate;
    
    @Column(name="срок_действия")
    private int validity;
    
    @Column(name="приоритет")
    private String priority;
    
    @ToString.Exclude
    @ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
    @JoinColumn(name="doctorid")
    private Doctor doctor;
    
    @ToString.Exclude
    @ManyToOne(cascade=CascadeType.REFRESH,fetch=FetchType.LAZY)
    @JoinColumn(name="patientid")
    private Patient patient;
}
