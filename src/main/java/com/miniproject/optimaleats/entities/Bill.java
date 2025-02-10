package com.miniproject.optimaleats.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Bill {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
	    private Long id;
	 @ManyToOne
	    @JoinColumn(name = "adminId", nullable = false)
	    private Admin admin;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
}
