
public enum Category {
	
	//Objets directement construits
	Accessories ("Accessoires"),
	Books ("Livres"),
	Bricolage ("Bricolage"),
	Clothing ("V�tement"),
	HomeAppliance ("Electrom�nager"),
	Informatic ("Infomatique"),
	Games ("Jeux"),
	Phones ("T�l�phonie"),
	Sport ("Sport"),
	Musics ("Musique"),
	Undefinied ("Non D�finie")
	;
	   
	private String name = "";
	   
	//Constructeur
	Category(String name){
	    this.name = name;
	}
	   
	public String toString(){
	    return name;
	}
}
