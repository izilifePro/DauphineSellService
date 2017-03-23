
public enum State {
	
	//Objets directement construits
	Available ("Disponible"),
	Booked ("R�serv�"),
	Borrowed ("Emprunt�"),
	Pending ("En attente"),
	Undefinied ("Non D�finie")
	;
	   
	private String name = "";
	   
	//Constructeur
	State(String name){
	    this.name = name;
	}
	   
	public String toString(){
	    return name;
	}
}
