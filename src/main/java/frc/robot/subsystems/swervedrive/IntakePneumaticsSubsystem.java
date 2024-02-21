package frc.robot.subsystems.swervedrive;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakePneumaticsSubsystem extends SubsystemBase {
    
    private Solenoid intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.INTAKE_PNEUMATIC_CHANNEL);

    public IntakePneumaticsSubsystem(){}

    public void intakeDown(){
        intakeSolenoid.set(true);
    }

    public void intakeUp(){
        intakeSolenoid.set(false);
    }
}