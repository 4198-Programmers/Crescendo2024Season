package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class InternalMovor extends SubsystemBase{
    

private CANSparkMax internalMotor = new CANSparkMax(Constants.INTERNAL_MOTOR_ID, MotorType.kBrushless);

DigitalInput MiddleLimitSwitch = new DigitalInput(Constants.MIDDLE_LIMIT_SWITCH);

/** 
 * transfer to shooter
 */
public void up() {
}
/**
 * transfer out
 */
public void down() {

}
/**
 * when switch activated in shooting position
 */
public boolean inShootingPostion() {
    
}
/**
 * intake has ring and middle can take
 */
public boolean intakeFull() {
    
}
}
