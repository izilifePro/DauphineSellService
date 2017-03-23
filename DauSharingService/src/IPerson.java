import java.rmi.Remote;
import java.rmi.RemoteException;


public interface IPerson extends Remote {
	public String getUidToString() throws RemoteException;
	public String getName() throws RemoteException;
	public String getFirstName() throws RemoteException;
	public int getLoanCount() throws RemoteException;
	public void addALoan() throws RemoteException;
}
