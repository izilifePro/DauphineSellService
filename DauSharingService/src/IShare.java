import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;


public interface IShare extends Remote {
	
	public boolean addProduct(IProduct product) throws RemoteException;
	public boolean delProduct(IProduct product) throws RemoteException;
	public boolean updateProduct(State state, IProduct product) throws RemoteException;
	public boolean addNote(String notes, IProduct product) throws RemoteException;
	public boolean addObservation(String observations, IProduct product) throws RemoteException;
	public List<IProduct> lookCategory(Category category) throws RemoteException;
	public List<IProduct> lookName(String name) throws RemoteException;
	public List<IProduct> lookState(State state) throws RemoteException;

	public boolean addAssignment(IProduct product, IPerson person) throws RemoteException;
	public boolean removeAssignment(IProduct product, IPerson person) throws RemoteException;
	public boolean updateAssignment(IProduct product, IPerson person) throws RemoteException;
	
	public boolean addSubscriber(IPerson person) throws RemoteException;
	public List<IPerson> lookPerson(String name, String first_name) throws RemoteException;
	public List<IPerson> getAllSubscriber() throws RemoteException;
}
