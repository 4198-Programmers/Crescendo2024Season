package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class InternalMoverSubsystem extends SubsystemBase{

private CANSparkMax internalMotor = new CANSparkMax(Constants.INTERNAL_MOTOR_ID, MotorType.kBrushless);

DigitalInput MiddleLimitSwitch = new DigitalInput(Constants.MIDDLE_LIMIT_SWITCH);

/** 
 * transfer to shooter
 */
public void up() {
    internalMotor.set(Constants.INTERAL_MOVER_UP);
}

/**
 * transfer out
 */
public void down() {
    internalMotor.set(Constants.INTERNAL_MOVER_DOWN);

}
/**
 * Lets us know if the note is in the transfer
 */
public boolean noteStatus(){
    return MiddleLimitSwitch.get();
}
}
