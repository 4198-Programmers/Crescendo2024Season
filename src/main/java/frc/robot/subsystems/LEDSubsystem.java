package frc.robot.subsystems;

import java.util.Optional;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDSubsystem extends SubsystemBase {

    private static final String LedBuffer = null;

    private static final String m_ledBuffer = null;

    private AddressableLED driveBaseLED = new AddressableLED(Constants.DRIVE_BASE_LED_ID);

    // length(num of stips)
    private AddressableLEDBuffer driveBaseLEDBuffer = new AddressableLEDBuffer(Constants.AddressableLEDBuffer);

    public static int m_rainbowFirstPixelHue = 180;

    private Optional<Alliance> alliance;

    public LEDSubsystem() {
        driveBaseLED.setLength(driveBaseLEDBuffer.getLength());
        driveBaseLED.setData(driveBaseLEDBuffer);
        driveBaseLED.start();
        this.alliance = DriverStation.getAlliance();
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

    public void changingColor() {
//red = 0-60
//yellow 61-120
//green 121-180
//cyan 181-240
//blue 241-300
//magenta 301-360
        for (var i = 0; i < LedBuffer.length(); i++) {

            final var hue = (m_rainbowFirstPixelHue + (i * 180 / m_ledBuffer.length()));

            driveBaseLEDBuffer.setHSV(i, hue, 255, 128);
        }

        m_rainbowFirstPixelHue += 3;

        m_rainbowFirstPixelHue %= 180;

    }
}
// No periodic
// change different sections of led seperatly
//

