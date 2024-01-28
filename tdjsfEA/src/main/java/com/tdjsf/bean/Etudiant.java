/**
 * 
 */
package com.tdjsf.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HP
 *
 */
public class Etudiant {
	private int id;
	private String nom;
	private String prenom;
	private Date datenais;
	private List<String> imag;
	private String color;
	
	


	


	//contructeur sans argument
	public Etudiant() {
		// TODO Auto-generated constructor stub
		imag = new ArrayList<String>();
		imag.add("2.jpg");
		imag.add("4.jpg");
		imag.add("6.jpg");
	}
	
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}



	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}



	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}



	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	/**
	 * @return the datenais
	 */
	public Date getDatenais() {
		return datenais;
	}



	/**
	 * @param datenais the datenais to set
	 */
	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}


//constructeur avec argument
	/**
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param datenais
	 */
	public Etudiant(int id, String nom, String prenom, Date datenais) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.datenais = datenais;
	}
  
	/**
	 * @return the imag
	 */
	public List<String> getImag() {
		return imag;
	}


	/**
	 * @param imag the imag to set
	 */
	public void setImag(List<String> imag) {
		this.imag = imag;
	}
	
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}


	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
}
