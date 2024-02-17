package frc.robot.subsystems.swervedrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
    private CANSparkMax intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_ID, MotorType.kBrushless);
    
    private Solenoid intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.INTAKE_PNEUMATIC_CHANNEL);
    
    public IntakeSubsystem() {
        this.initialize();
    } 

//motor
    public void intakeMotorSpeed(double speed){
        intakeMotor.set(speed);
    }

    public void stop(){
        intakeMotor.set(0);
    }

//pnumatics 
public void PnClose(){
    intakeSolenoid.set(false);

}

public void PnOpen(){
    intakeSolenoid.set(true);

}

public void intakePnKillSwitch(){
    intakeSolenoid.set(false);
}

//combined

public void autoIntake(double speed){
    intakeSolenoid.set(true);
    intakeMotor.set(speed);
}


public void initialize(){
    intakeSolenoid.set(false);
}
    
}
