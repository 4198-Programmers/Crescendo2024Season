package frc.robot.subsystems;

import org.w3c.dom.css.RGBColor;

import com.ctre.phoenix.led.RgbFadeAnimation;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.hal.AddressableLEDJNI;
import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDBaseSubsytem extends SubsystemBase {
     
private AddressableLED driveBaseLED =  new AddressableLED(Constants.AddressableLED);

//length(num of stips)
private AddressableLEDBuffer driveBaseLEDBuffer = new AddressableLEDBuffer(Constants.AddressableLEDBuffer);

public AddressableLED.setData(driveBaseLEDBuffer);

public LEDBaseSubsytem(){}

//setHSV() -> color saturation

public static void solidColors(){
    public void RGBColorRed() {
    for (var i =0; i < driveBaseLEDBuffer.getLength(); i ++){
        driveBaseLEDBuffer.setRGB(i, 255, 0, 0);}
    }

    public void RGBColorBlue(){
    for (var i =0; i < driveBaseLEDBuffer.getLength(); i ++){
        driveBaseLEDBuffer.setRGB(i, 0, 0, 255);}}

    public void RGBColorGreen(){
    for (var i =0; i < driveBaseLEDBuffer.getLength(); i ++){
        driveBaseLEDBuffer.setRGB(i, 0, 255, 0);}
    }
}

public static void changingColor(){


    
}

}
