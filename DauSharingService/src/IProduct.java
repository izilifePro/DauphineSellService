import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UID;
import java.util.Date;


public interface IProduct extends Remote {
	public String getName() throws RemoteException;

	public void setName(String name) throws RemoteException;

	public Category getCategory() throws RemoteException;

	public void setCategory(Category category) throws RemoteException;

	public State getState() throws RemoteException;

	public void setState(State state) throws RemoteException;

	public String getNote() throws RemoteException;

	public void setNote(String note) throws RemoteException;

	public String getObservation() throws RemoteException;

	public void setObservation(String observation) throws RemoteException;
	
	public String getCondition() throws RemoteException;

	public void setCondition(String note) throws RemoteException;

	public String getUidToString() throws RemoteException;
	
	public UID getUid() throws RemoteException;

	public void setUid(UID uid) throws RemoteException;
	
	public Date getDate() throws RemoteException;
	
	public void setDate(Date date) throws RemoteException;
	
	public void addObservation(String observation) throws RemoteException;
	
	public void addNote(String note) throws RemoteException;

}
