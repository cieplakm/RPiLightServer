import com.mmc.rpilight.OnRequestListener;
import com.mmc.rpilight.RPiLight;
import com.mmc.rpilight.server.Request;
import com.mmc.rpilight.server.Response;
import com.mmc.rpilight.server.Server;
import com.mmc.rpilight.server.ServerImplementation;

public class RPiServer {

	public static void main(String[] args) {
		
		
		
        final Server server = RPiLight.serverInstance();
        final PiGPIO piGPIO = new PiGPIO();
        server.setOnRequestListener(new OnRequestListener() {
            public void onRequest(Request request) {

                System.out.println(request.getTypeDescription());

                Response response = new Response(request);

                if (request.isAction()){
                    // do operation with lamp
                    // and response
                	
                	if (request.shouldOn()) {
                		piGPIO.swichOnGpioPin();
						
					}else {
						piGPIO.swichOffGpioPin();
					}
                	
                	response.setLampOn( piGPIO.isLampOn() );
                	
                	
                }else {
                    //return lamp state
      
                    response.setLampOn( piGPIO.isLampOn() );
                    
                }
                
                System.out.println("Lamp is now : " + piGPIO.isLampOn());

                server.response(response);

            }
        });

        server.start();
		
	}

}
