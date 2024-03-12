package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AmpBarSubsystem extends SubsystemBase{

  
    private Solenoid ampBarSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.AMP_BAR_PNEUMATIC_CHANNEL);

    public AmpBarSubsystem(){}

    public void intakePneumaticKillSwitch(){
        ampBarSolenoid.set(false);
    }

    public void pullAmpBarUp() {
        ampBarSolenoid.set(true);
    }

    public void pushAmpBarDown(){
        ampBarSolenoid.set(false);
    }
    
}
