/**
 * 
 */
package com.tdjsf.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;







/**
 * @author HP
 *
 */
@RequestScoped
@Named
public class EtudiantBean {
	private Etudiant etudiant;
	private List<Etudiant> listeEtudiant;
	private Date date;
	private boolean modif=false;
	private static int etuid;
	
	
	
	
	
	
	


	

	
	public EtudiantBean() {
		// TODO Auto-generated constructor stub
		etudiant = new Etudiant();
	}
	
	//debut connection à la base
	public Connection connect() {
		try {
			//on va choisir notre driver mysql
			Class.forName("com.mysql.jdbc.Driver");
			//on va se connecter a la base de données
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdjsfcrud", "root", "");
		    return con;
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			Connection con = null ;
			return con;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Connection con = null;
			return con;
		}
	}
	//fin connection à la base
	 
	
	
	//affichage de nos données qui se trouve à la base
		public List<Etudiant> afficheEtudiant() {
			listeEtudiant = new ArrayList<Etudiant>();
			
			//on va preparer notre requete
			String req = "select * from etudiant";
			try {
				PreparedStatement ps = connect().prepareStatement(req);
				//on va executer notre requete
				ResultSet res = ps.executeQuery();
				//on recupere le resultat de la requete et on le stock dans listeEtudiant
				while(res.next()){
					//on cree une instance d'etudiant
					Etudiant e = new Etudiant();
					e.setId(res.getInt("id"));
					e.setNom(res.getString("nom"));
					e.setPrenom(res.getString("prenom"));
					e.setDatenais(res.getDate("datenais"));
					//ajout de l'etudiant dans la liste des etudiants
					listeEtudiant.add(e);
					}
				return listeEtudiant;
			}catch (SQLException e) {
				e.printStackTrace();
				return listeEtudiant;
			}
		}
		
		//connection des donnés liées à la base de données
		public void ajouterListeEtudiant() {
			
			listeEtudiant = new ArrayList<Etudiant>(); 
				
				try {
			 //on va choisir notre driver mysql
					Class.forName("com.mysql.jdbc.Driver");
					
					//on va se connecter a la base de données
					Connection con= DriverManager.getConnection("jdbc:mysql://Localhost:3306/bdjsfcrud","root","");
				
					//on va preparer notre requete
					PreparedStatement ps = con.prepareStatement("select *from etudiant");
				
					//on va executer notre requete
					ResultSet rs = ps.executeQuery();
					
					//on recupere le resultat de la requete et on le stock dans listeEtudiant
				    while(rs.next()) {
				    	//on va creer une instance d'etudiant
				    	Etudiant e = new Etudiant();
				    	e.setId(rs.getInt("id"));
				    	e.setNom(rs.getString("nom"));
				    	e.setPrenom(rs.getString("prenom"));
				    	e.setDatenais(rs.getDate("datenais"));
				    	
				    	//ajout de l'etudiant dans la liste des etudiants
				    	listeEtudiant.add(e);
				    }
				
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	         //fin 
		
		
		//ajouter d'etudiant sur la base de données grace à un formulaire d'ajout
		 //public void ajouterEtudiant() {
			//requete sql
			//String req = "insert into etudiant (nom,prenom,datenais) value(?,?,?)";
			//converti le java.util en java.sql
		//	etudiant.setDatenais(convDate(date));
		//	try {
				//on prepare la requete
		//		PreparedStatement ps = connect().prepareStatement(req);
				//ajout de la requete sql on remplace les points d'interrogation
		//		ps.setString(1, etudiant.getNom());
		//		ps.setString(2, etudiant.getPrenom());
				//ps.setDate(3, etudiant.getDatenais());
			//	ps.setDate(3, java.sql.Date.valueOf("1996-09-23"));
				//on execute la requete
			//	ps.execute();
			//	afficheEtudiant();
			//	etudiant = new Etudiant();
			//	date = null;
			 // }catch(SQLException e1) {
			//	e1.printStackTrace();
			//}
		//}
			
		//fin pour code pour ajouter les etudiants 
		//ajout etudiant dans la base ne marche pas essayons un autre code 
		 
		//nouveau code pour ajouter un etudiant
		public void ajouterEtudiant(Etudiant e)
		{
			
			try {
				//on choisie notre driver
				Class.forName("com.mysql.jdbc.Driver");
				
				//connection à la base de données
			Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/bdjsfcrud","root","");
			
			//definir la requete
			String req ="insert into etudiant (nom,prenom,datenais) value (?,?,?)";
			
			//on va preparer la requete
			PreparedStatement ps = con.prepareStatement(req);
			
			//pour chaque ? on met la requete correspondante
			ps.setString(1, e.getNom());
			ps.setString(2, e.getPrenom());
			//ps.setDate(3, e.getDatenais());
			//ps.setDate(3, java.util.Date());
			ps.setDate(3, java.sql.Date.valueOf("2012-10-24"));
			//ps.setDate(3, new java.sql.Date(e.getDatenais().getTime()));
			
			
			//on execute la requete
			ps.execute();
			
			//return "index";
			etudiant = new Etudiant();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				//return"";
				
			
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
				//return"";
				
				
			}
		}
		//fin ajout etudiant
		
		
		 
		 //debut suppression etudiant
		 public void deleteEtudiant(Etudiant e) {
			 String req ="delete from etudiant where id = ?";
			 try {
				 PreparedStatement ps = connect().prepareStatement(req);
				 ps.setInt(1, e.getId());
				 ps.execute();
			 }catch(SQLException e1) {
				 e1.printStackTrace();
			 }
		 }
		 //fin suppression etudiant
		 
		 //afficher et prendre les valeurs de l'etudiant
		 public void affiche(Etudiant e) {
			 modif=true;
			 etuid =e.getId();
			 date = e.getDatenais();
			 etudiant = e;
		 }
		 
		 //modification des etudiants ce code ne marche pas
		 
		 //public void modifEtudiant() {
			// conversion de la date
			//etudiant.setDatenais(convDate(date));
		//	 try {
		//		 String req = "UPDATE etudiant SET nom = ?, prenom = ?, datenais = ? WHERE id = ?" ;
		//		 PreparedStatement ps = connect().prepareStatement(req);
				 //instance d'etudiant
		//	 ps.setString(1, etudiant.getNom());
		//	 ps.setString(1, etudiant.getPrenom());
				// ps.setDate(3, etudiant.getDatenais());
		 //	 ps.setDate(3, java.sql.Date.valueOf("1996-04-21"));
		//		 ps.setInt(4, etuid);
				   
		//		 System.out.println(ps);
				 
		//		 ps.executeUpdate();
				 
		//		 afficheEtudiant();
		//		 etudiant = new Etudiant();
		//		 date = null;
		 //   }catch(SQLException e1) {
		  //  	e1.printStackTrace();
		    	
		  //  }
		// }
		 //fin modification des etudiants ce code ne marche pas
		 
		
		
		 //code qui a marché 
		 public void modifEtudiant()
			{
				
				try {
					//on choisie notre driver
					Class.forName("com.mysql.jdbc.Driver");
					
					//connection à la base de données
				Connection con = DriverManager.getConnection("jdbc:mysql://Localhost:3306/bdjsfcrud","root","");
				
				//definir la requete
				 String req = "UPDATE etudiant SET nom = ?, prenom = ?, datenais = ? WHERE id = ?" ;
				
				//on va preparer la requete
				PreparedStatement ps = con.prepareStatement(req);
				
				//pour chaque ? on met la requete correspondante
				ps.setString(1, etudiant.getNom());
				ps.setString(2, etudiant.getPrenom());
				ps.setDate(3, java.sql.Date.valueOf("1996-04-21"));
				 ps.setInt(4, etuid);
				 
				 System.out.println(ps);
				 
				 ps.executeUpdate();
				
				//on execute la requete
				ps.execute();
				
				 afficheEtudiant();
				 date = null;
				//return "index";
				etudiant = new Etudiant();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					//return"";
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
					//return"";
					
					
				}
			}
			//fin mise à jour etudiant
		 
		 
		 
		 
		//pour dire que date est de type date calendrier java.sql
		public java.sql.Date convDate(java.util.Date calendarDate){
		return new java.sql.Date(calendarDate.getTime());
		}
		
		
		
		
	
	/**
	 * @return the etudiant
	 */
	public Etudiant getEtudiant() {
		return etudiant;
	}
	/**
	 * @param etudiant the etudiant to set
	 */
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	/**
	 * @return the listeEtudiant
	 */
	public List<Etudiant> getListeEtudiant() {
		return listeEtudiant;
	}
	/**
	 * @param listeEtudiant the listeEtudiant to set
	 */
	public void setListeEtudiant(List<Etudiant> listeEtudiant) {
		this.listeEtudiant = listeEtudiant;
	}
	
	/**
	 * @return the pisteEtudiant
	 */
	public List<Etudiant> getPisteEtudiant() {
		return afficheEtudiant();
	}


	/**
	 * @param pisteEtudiant the pisteEtudiant to set
	 */
	public void setPisteEtudiant(List<Etudiant> pisteEtudiant) {
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	/**
	 * @return the modif
	 */
	public boolean isModif() {
		return modif;
	}


	/**
	 * @param modif the modif to set
	 */
	public void setModif(boolean modif) {
		this.modif = modif;
	}


	/**
	 * @return the etuid
	 */
	public int getEtuid() {
		return etuid;
	}

	/**
	 * @param etuid the etuid to set
	 */
	public void setEtuid(int etuid) {
		//this.etuid = etuid;
		EtudiantBean.etuid = etuid;
	}

}
