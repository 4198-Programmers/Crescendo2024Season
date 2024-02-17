package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AmpBarSubsystem extends SubsystemBase{

    private static final Solenoid intakeSolenoid = null;
    private static final Solenoid intakeMotor = null;
    private static boolean switchValue = false;
    private Solenoid ampBarSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.AMP_BAR_PNEUMATIC_CHANNEL);

    public AmpBarSubsystem(){
        this.initialize();
    }
    public void close(){
        switchValue = false;
    }

    public void open(){
        switchValue = true;
    }

    public void switchIntakeSolenoidState(){
        switchValue = !switchValue;
    }

    public void intakePneumaticKillSwitch(){
        intakeSolenoid.set(false);
    }
    public void autoIntake(boolean speed){
        switchValue = true;
        intakeSolenoid.set(true);
        intakeMotor.set(speed);
    }

    public void initialize(){
        intakeSolenoid.set(switchValue);
    }
    public void pullAmpBarUp() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pullAmpBarUp'");
    }
    public void ampBarKillSwitch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ampBarKillSwitch'");
    }
}
