import java.rmi.RemoteException;


public class Teacher extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Teacher(String name, String first_name) throws RemoteException {
		super(name, first_name);
	}

}
