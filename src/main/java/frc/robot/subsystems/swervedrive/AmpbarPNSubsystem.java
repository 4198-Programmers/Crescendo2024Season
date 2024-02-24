package frc.robot.subsystems.swervedrive;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AmpbarPNSubsystem extends SubsystemBase {
    private Solenoid ampbarPN = new Solenoid(21, PneumaticsModuleType.CTREPCM, Constants.AMP_BAR_PN_ID);
    //compressor is enabled in the constructor for robot container
    
    public AmpbarPNSubsystem(){
        this.initialize();
    }

    public void initialize(){
        ampbarPN.set(false);
    }

    public void pullAmpBarUp(){
        if(ampbarPN.get()){
        ampbarPN.toggle();
        }
    }
    
    public void pullAmpBarDown() {
        if(!ampbarPN.get()) {
        ampbarPN.toggle();
        }
    }

    public boolean solenoidPosition(){
        return ampbarPN.get();
    }

    public void ended(){
        ampbarPN.set(false);
    }
    
}
