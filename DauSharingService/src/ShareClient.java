import java.net.InetAddress;
import java.rmi.*;
import java.util.List;


public class ShareClient {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		try{
			System.out.println("Setting RMISecurityManager");
			System.setSecurityManager(new RMISecurityManager());
			System.out.println("Trying Naming lookup...");
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/ShareService";
			System.out.println("Accès à l'objet avec l'url : " + url);
			IShare share = (IShare) Naming.lookup(url);
			System.out.println("Naming lookup successful...");
			
			//voir tous les produits disponibles
			System.out.println("Liste des produits disponibles...");
			List<IProduct> products = share.lookState(State.Available);
			for (IProduct p : products) {
				System.out.println("uid : " + p.getUidToString() + "; nom : " + p.getName() + "; etat : " + p.getState().toString());
			}
			
			//liste des abonnés
			System.out.println("Liste des abonnés...");
			List<IPerson> person = share.getAllSubscriber();
			for (IPerson p : person) {
				System.out.println("uid : " + p.getUidToString() + "; nom : " + p.getName() + "; prenom : " + p.getFirstName().toString() + "; nombre d'emprunt effectué : " + p.getLoanCount());
			}
			
			//Duchesne emprunte la chemise noire
			person = share.lookPerson("Duchesne", "Mickael");
			products = share.lookName("Black Shirt");
			if(share.addAssignment(products.get(0), person.get(0)))
			{
				person.get(0).addALoan();
				share.updateProduct(State.Borrowed, products.get(0));
			}
			
			
			//Liste des produits pretes
			List<IProduct> borrowed = share.lookState(State.Borrowed);
			for (IProduct p : borrowed) {
				System.out.println("uid : " + p.getUidToString() + "; nom : " + p.getName() + "; etat : " + p.getState().toString());
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Something goes wrong : " + e);
		}
	}

}
