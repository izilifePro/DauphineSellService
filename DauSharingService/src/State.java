
public enum State {
	
	//Objets directement construits
	Available ("Disponible"),
	Booked ("Réservé"),
	Borrowed ("Emprunté"),
	Pending ("En attente"),
	Undefinied ("Non Définie")
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
