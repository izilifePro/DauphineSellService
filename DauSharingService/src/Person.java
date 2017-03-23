import java.rmi.RemoteException;
import java.rmi.server.UID;
import java.rmi.server.UnicastRemoteObject;


public class Person extends UnicastRemoteObject implements IPerson {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected int count_loan = 0;
	
	protected UID uid = new UID();
	
	protected String name = "";
	
	protected String first_name = "";
	
	public Person(String name, String first_name) throws RemoteException
	{
		super();
		this.name = name;
		this.first_name = first_name;
	}
	
	public String getUidToString() throws RemoteException {
		return uid.toString();
	}

	public String getName() throws RemoteException {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() throws RemoteException {
		return first_name;
	}

	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}

	public int getLoanCount() throws RemoteException {
		return count_loan;
	}

	public void setLoanCount(int nb_loan) {
		this.count_loan = nb_loan;
	}

	public UID getUid() {
		return uid;
	}

	public void setUid(UID uid) {
		this.uid = uid;
	}
	
	public void addALoan() throws RemoteException
	{
		this.count_loan++;
	}
}
