package com.ty.student;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String state;
    private String country;

    @OneToOne(mappedBy = "address")
    @JsonBackReference
    private Student student;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
