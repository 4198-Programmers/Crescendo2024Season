package frc.robot.subsystems.swervedrive;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakePneumaticsSubsystem extends SubsystemBase {
    
    private Solenoid intakeSolenoid = new Solenoid(21, PneumaticsModuleType.CTREPCM, Constants.INTAKE_PNEUMATIC_CHANNEL);

    public void intakeDown(){
        System.out.println("Intake Solenoid Status: " + intakeSolenoid.get());

        if(intakeSolenoid.get()){
            intakeSolenoid.toggle();
        }
    }

    public void intakeUp(){
        System.out.println("Intake Solenoid Status: " + intakeSolenoid.get());

        if (!intakeSolenoid.get()){
        intakeSolenoid.toggle();
        }

    }
}