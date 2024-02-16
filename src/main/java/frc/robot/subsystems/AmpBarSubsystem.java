package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AmpBarSubsystem extends SubsystemBase{

    private Solenoid ampBarSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.AMP_BAR_PNEUMATIC_CHANNEL);

    private boolean switchValue = false;

    public AmpBarSubsystem(){
        this.initialize();
    }

    public void changeAmpBarState(){
        switchValue =! switchValue;
    }

    public void ampBarKillSwitch(){
        ampBarSolenoid.set(false);
    }
    
    public void initialize(){
        ampBarSolenoid.set(switchValue);
    }
}
