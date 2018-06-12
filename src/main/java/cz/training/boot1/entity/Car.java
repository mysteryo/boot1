package cz.training.boot1.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "CAR")
public class Car {

		@Id
		@SequenceGenerator(name = "CAR_SEQ", sequenceName = "CAR_SEQ", allocationSize = 1)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CAR_SEQ")
		private int id;
		@Column(name = "NAME")
		private String Name;
		
		@ManyToMany
		@JoinTable(name = "CAR_PERSONA" , joinColumns = {@JoinColumn(name = "CAR_ID")},inverseJoinColumns = {@JoinColumn(name = "PERSONA_ID")})
		List<Persona> persons;
		
		@Override
		public String toString() {
			return "CAR [id=" + id + ", Name=" + Name + "]";
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public List<Persona> getPersons() {
			return persons;
		}
		public void setPersons(List<Persona> persons) {
			this.persons = persons;
		}
		
}
