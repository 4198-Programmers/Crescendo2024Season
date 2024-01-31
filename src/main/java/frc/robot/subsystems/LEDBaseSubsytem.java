package frc.robot.subsystems;

import org.w3c.dom.css.RGBColor;

import com.ctre.phoenix.led.RgbFadeAnimation;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.hal.AddressableLEDJNI;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDBaseSubsytem extends SubsystemBase {

    private AddressableLED driveBaseLED = new AddressableLED(Constants.DRIVE_BASE_LED_ID);

    // length(num of stips)
    private AddressableLEDBuffer driveBaseLEDBuffer = new AddressableLEDBuffer(Constants.AddressableLEDBuffer);

    public LEDBaseSubsytem() {
         driveBaseLED.setLength(driveBaseLEDBuffer.getLength());
         driveBaseLED.setData(driveBaseLEDBuffer);
         driveBaseLED.se
         driveBaseLED.start();
    }

    // setHSV() -> color saturation

    // public void solidColors(){
    public void RGBColorRed() {
        for (var i = 0; i < driveBaseLEDBuffer.getLength(); i++) {
            driveBaseLEDBuffer.setLED(i, Color.kRed);
        }
    }

    public void RGBColorBlue() {
        for (var i = 0; i < driveBaseLEDBuffer.getLength(); i++) {
            driveBaseLEDBuffer.setRGB(i, 0, 0, 255);
        }
    }

    public void RGBColorGreen() {
        for (var i = 0; i < driveBaseLEDBuffer.getLength(); i++) {
            driveBaseLEDBuffer.setRGB(i, 0, 255, 0);
        }
    }
    // }

public static void changingColor(){

    private void rainbow
    {

        for (var i = ; i < LedBuffer.getlength (); i ++){

            final var hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.getlength()))

            m_ledBuffer.setHSV(i, hue, 255, 128);
        }
        
        m_rainbowFirstPixelHue +=3;

        m_rainbowFirstPixelHue %= 180;
    }

}

}
// No periodic 
// change different sections of led seperatly 
//