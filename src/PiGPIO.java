import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class PiGPIO {
	
	final GpioController gpio;
	GpioPinDigitalOutput  pin;
	
	public PiGPIO() {
		gpio = GpioFactory.getInstance();
		pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);
		pin.setShutdownOptions(true, PinState.LOW);

	}
	
	
	public boolean isLampOn(){
        return !pin.isHigh(); //high means OFF
	}
	
	public void swichOnGpioPin(){
		pin.low(); //on
	}

			

	public void swichOffGpioPin(){
		pin.high(); //off
	}

}
