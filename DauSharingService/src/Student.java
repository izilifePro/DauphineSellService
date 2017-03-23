import java.rmi.RemoteException;


public class Student extends Person {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Student(String name, String first_name) throws RemoteException {
		super(name, first_name);
	}

}
