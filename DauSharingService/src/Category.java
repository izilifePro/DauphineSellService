
public enum Category {
	
	//Objets directement construits
	Accessories ("Accessoires"),
	Books ("Livres"),
	Bricolage ("Bricolage"),
	Clothing ("Vêtement"),
	HomeAppliance ("Electroménager"),
	Informatic ("Infomatique"),
	Games ("Jeux"),
	Phones ("Téléphonie"),
	Sport ("Sport"),
	Musics ("Musique"),
	Undefinied ("Non Définie")
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
