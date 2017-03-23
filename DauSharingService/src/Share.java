import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


public class Share extends UnicastRemoteObject implements IShare {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Catalogue des produits disponibles
	 */
	private HashMap <String, IProduct> catalog;
	
	/**
	 * Liste des personnes abonnées
	 */
	private HashMap <String, IPerson> subscribers;

	/**
	 * Gestion des allocations des produits
	 */
	private HashMap <String, IPerson> assignments;
	
	protected Share() throws RemoteException {
		super();
		setCatalog(new HashMap<String, IProduct>());
		setAssignments(new HashMap<String, IPerson>());
		setSubscribers(new HashMap<String, IPerson>());
		
		//creation du catalogue de produit
		Product p = new Product("Montain Bike", Category.Sport, State.Available);
		this.addProduct(p);
		p = new Product("Bike", Category.Sport, State.Available);
		this.addProduct(p);
		p = new Product("Jean Denim", Category.Clothing, State.Available);
		this.addProduct(p);
		p = new Product("Black Shirt", Category.Clothing, State.Available);
		this.addProduct(p);
		
		//creation de la liste des personnes abonnées
		Person g = new Student("Duchesne", "Mickael");
		this.addSubscriber(g);
		g = new Teacher("Zargayouna", "Mahdi");
		this.addSubscriber(g);
	}
	
	public HashMap <String, IProduct> getCatalog() {
		return catalog;
	}

	public void setCatalog(HashMap<String, IProduct> hashMap) {
		this.catalog = hashMap;
	}
	
	public HashMap <String, IPerson> getAssignments() {
		return assignments;
	}

	public void setAssignments(HashMap<String, IPerson> hashMap) {
		this.assignments = hashMap;
	}
	
	public HashMap <String, IPerson> getSubscribers() {
		return subscribers;
	}

	public void setSubscribers(HashMap<String, IPerson> hashMap) {
		this.subscribers = hashMap;
	}
	
	@Override
	public boolean addSubscriber(IPerson person) throws RemoteException {
		boolean res = false;
		String key = person.getUidToString();
		if(subscribers.containsKey(key))
		{
			subscribers.replace(key, person);
			res = true;
		}
		else
		{
			this.subscribers.put(key, person);
			res = true;
		}
		return res;
	}
	
	@Override
	public boolean addProduct(IProduct product) throws RemoteException {
		boolean res = false;
		String key = product.getUidToString();
		if(catalog.containsKey(key))
		{
			catalog.replace(key, product);
			res = true;
		}
		else
		{
			this.catalog.put(key, product);
			res = true;
		}
		return res;
	}

	@Override
	public boolean delProduct(IProduct product) throws RemoteException {
		boolean res = false;
		String key = product.getUidToString();
		if(catalog.containsKey(key))
		{
			catalog.remove(key, product);
			res = true;
		}
		return res;
	}

	@Override
	public boolean updateProduct(State state, IProduct product) throws RemoteException {
		boolean res = false;
		String key = product.getUidToString();
		if(catalog.containsKey(key))
		{
			product.setState(state);
			catalog.replace(key, product);
			res = true;
		}
		return res;
	}

	@Override
	public boolean addNote(String note, IProduct product) throws RemoteException {
		boolean res = false;
		for(Entry <String, IProduct> entry : catalog.entrySet()) 
		{
			IProduct p = entry.getValue();
			if (p.getUidToString().equals(product.getUid().toString())){
				p.addNote(note);
				res = true;
			}
		}
		return res;
	}

	@Override
	public boolean addObservation(String observation, IProduct product) throws RemoteException {
		boolean res = false;
		for(Entry <String, IProduct> entry : catalog.entrySet()) 
		{
			IProduct p = entry.getValue();
			if (p.getUidToString().equals(product.getUid().toString())) {
				p.addObservation(observation);
				res = true;
			}
		}
		return res;
	}

	@Override
	public List<IProduct> lookCategory(Category category) throws RemoteException 
	{
		List<IProduct> prods = new ArrayList<IProduct>();
		
		for(Entry <String, IProduct> entry : catalog.entrySet()) 
		{
			IProduct p = entry.getValue();
			if (p.getCategory().equals(category))
				prods.add(p);
		}
		
		return prods;
	}

	@Override
	public List<IProduct> lookName(String name) throws RemoteException {
		
		List<IProduct> prods = new ArrayList<IProduct>();
		
		for(Entry <String, IProduct> entry : catalog.entrySet()) 
		{
			IProduct p = entry.getValue();
			if (p.getName().equals(name))
				prods.add(p);
		}
		
		return prods;
	}
	
	@Override
	public List<IProduct> lookState(State state) throws RemoteException {
		
		List<IProduct> prods = new ArrayList<IProduct>();
		
		for(Entry <String, IProduct> entry : catalog.entrySet()) 
		{
			IProduct p = entry.getValue();
			if (p.getState().equals(state))
				prods.add(p);
		}
		
		return prods;
	}

	@Override
	public boolean addAssignment(IProduct product, IPerson person) throws RemoteException {
		boolean res = false;
		String prodKey = product.getUidToString();
		if(!assignments.containsKey(prodKey))
		{
			assignments.put(prodKey, person);
			res = true;
		}
		return res;
	}

	@Override
	public boolean removeAssignment(IProduct product, IPerson person) throws RemoteException {
		boolean res = false; 
		String prodKey = product.getUidToString();
		if(assignments.containsKey(prodKey))
		{
			assignments.remove(prodKey);
			res = true;
		}
		return res;
	}

	@Override
	public boolean updateAssignment(IProduct product, IPerson person) throws RemoteException {
		boolean res = false;
		String prodKey = product.getUidToString();
		if(assignments.containsKey(prodKey))
		{
			assignments.replace(prodKey, person);
			res = true;
		}
		
		return res;
	}

	@Override
	public List<IPerson> lookPerson(String name, String first_name)	throws RemoteException {
		List<IPerson> pers = new ArrayList<IPerson>();
		IPerson p = null;
		for(Entry <String, IPerson> entry : subscribers.entrySet()) 
		{
			p = entry.getValue();
			if (p.getName().equals(name) && p.getFirstName().equals(first_name))
				pers.add(p);
		}
		
		return pers;
	}

	@Override
	public List<IPerson> getAllSubscriber() throws RemoteException {
		List<IPerson> pers = new ArrayList<IPerson>();

		for(Entry <String, IPerson> entry : subscribers.entrySet()) 
		{
			IPerson p = entry.getValue();
			pers.add(p);
		}
		
		return pers;
	}
	
}
