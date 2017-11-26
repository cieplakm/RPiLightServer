import com.mmc.rpilight.OnReciveListener;
import com.mmc.rpilight.server.Request;
import com.mmc.rpilight.server.Response;
import com.mmc.rpilight.server.Server;
import com.mmc.rpilight.server.ServerImplementation;

public class RPiServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			final Server server = new ServerImplementation();
			
			server.setOnReciveListener(new OnReciveListener() {
				
				@Override
				public void onRecive(Request request) {
					// TODO Auto-generated method stub
					
					Response response = new Response();
					response.setAddress(request.getAddress());
					
					server.response(response);
					
				}
			});
			
			server.start();
			
			
		
	}

}
