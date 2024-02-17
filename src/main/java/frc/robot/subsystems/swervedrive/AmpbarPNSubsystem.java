package frc.robot.subsystems.swervedrive;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AmpbarPNSubsystem extends SubsystemBase {
    private Solenoid ampbarPN = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.AMP_BAR_PN_ID);
    public boolean switchValue = false;
    Compressor compressor;
    
    public AmpbarPNSubsystem(Compressor compressor){
        this.initialize();
        this.compressor = compressor;
    }

    public void initialize(){
        ampbarPN.set(false);
    }

    public void pullAmpBarDown(){
        ampbarPN.set(false);
    }
    public void pullAmpBarUp(){
        ampbarPN.set(true);
    }

    public void toggle(){
        ampbarPN.toggle();
    }
    
    public void pushAmpBarChoose(boolean switchValue){
        ampbarPN.set(switchValue);
    }

    public void ampBarKillSwitch(){
        ampbarPN.set(false);
    }
}
