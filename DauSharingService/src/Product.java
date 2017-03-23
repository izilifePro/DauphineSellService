import java.rmi.RemoteException;
import java.rmi.server.UID;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.GregorianCalendar;


public class Product extends UnicastRemoteObject implements IProduct {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UID uid = new UID();
	
	private String name = "";
	
	private Category category = Category.Undefinied;
	
	private State state = State.Pending;
	
	private String note = "";
	
	private String observation = "";
	
	private String condition = "";
	
	private Date date = (Date) new GregorianCalendar().getTime();
	
	public Product(String name, Category category) throws RemoteException
	{
		super();
		this.setName(name);
		this.setCategory(category);
	}
	
	public Product(String name, Category category, State state) throws RemoteException
	{
		super();
		this.setName(name);
		this.setCategory(category);
		this.setState(state);
	}
	
	public void addObservation(String observation) throws RemoteException
	{
		this.observation.concat(observation);
	}
	
	public void addNote(String note) throws RemoteException
	{
		this.note.concat(note);
	}

	public String getUidToString() {
		return uid.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public UID getUid() {
		return uid;
	}

	public void setUid(UID uid) {
		this.uid = uid;
	}

	@Override
	public Date getDate() throws RemoteException {
		return date;
	}

	@Override
	public void setDate(Date date) throws RemoteException {
		this.date = date;
	}

	@Override
	public String getCondition() throws RemoteException {
		return this.condition;
	}

	@Override
	public void setCondition(String condition) throws RemoteException {
			this.condition = condition;
	}

}
