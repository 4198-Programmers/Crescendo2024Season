package frc.robot.subsystems.swervedrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class InternalMoverSubsystem extends SubsystemBase{
    private CANSparkMax internalMoverMotor = new CANSparkMax(Constants.INTERNAL_MOVER_MOTOR_ID, MotorType.kBrushless);
    DigitalInput MiddleLimitSwitch = new DigitalInput(Constants.MIDDLE_LIMIT_SWITCH_ID);

    public void move(double speed){
        internalMoverMotor.set(speed);
    }


    public void stop(){
        internalMoverMotor.set(0);
    }

    public boolean middleLimitStatus(){
        return MiddleLimitSwitch.get();
    }



}
