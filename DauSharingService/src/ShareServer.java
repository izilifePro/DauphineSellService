import java.net.*;
import java.net.UnknownHostException;
import java.rmi.*;

public class ShareServer extends java.rmi.server.UnicastRemoteObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String url = "";
	
	private static IShare share = null;
	
	public ShareServer() throws java.rmi.RemoteException
    {
		super();
		setShare(new Share());
		try {
			String localhost = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/ShareService";
			setUrl(localhost);
		} 
		catch (UnknownHostException e) {
			e.printStackTrace();
		}
    }
	
	public static void main(String[] args) throws Exception {
		
		try{
			ShareServer share_server = new ShareServer();
			System.out.println("Enregistrement de l'objet avec l'url : " + share_server.getUrl());
			Naming.rebind(share_server.getUrl(), share_server.getShare());
		}
		catch(Exception e)
		{
			System.out.println("Something goes wrong : " + e);
		}
	}

	public String getUrl() {
		return ShareServer.url;
	}

	public void setUrl(String url) {
		ShareServer.url = url;
	}
	
	public IShare getShare() {
		return ShareServer.share;
	}

	public void setShare(IShare share) {
		ShareServer.share = share;
	}
}
