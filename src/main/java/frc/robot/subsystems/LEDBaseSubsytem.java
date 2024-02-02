package frc.robot.subsystems;

import org.w3c.dom.css.RGBColor;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.hal.AddressableLEDJNI;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDBaseSubsytem extends SubsystemBase {

    private static final String LedBuffer = null;

    private static final String m_ledBuffer = null;

    private AddressableLED driveBaseLED = new AddressableLED(Constants.DRIVE_BASE_LED_ID);

    // length(num of stips)
    private AddressableLEDBuffer driveBaseLEDBuffer = new AddressableLEDBuffer(Constants.AddressableLEDBuffer);

    public double m_rainbowFirstPixelHue = 180;

    public LEDBaseSubsytem() {
         driveBaseLED.setLength(driveBaseLEDBuffer.getLength());
         driveBaseLED.setData(driveBaseLEDBuffer);
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
   
        for (var i = 0; i < LedBuffer.length(); i ++){

            final var hue = (this.m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.length()));

            m_ledBuffer.setHSV(i, hue, 255, 128);
        }
        
        this.m_rainbowFirstPixelHue += 3;

        this.m_rainbowFirstPixelHue %= 180;
        
        }
    }
// No periodic 
// change different sections of led seperatly 
//
