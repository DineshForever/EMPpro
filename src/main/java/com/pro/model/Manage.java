package com.pro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Manage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String name;
		private String role;
		private long mobileno;
		private String place;	
		@Column(unique = true)
		private String user;
		private String password;

	


}
