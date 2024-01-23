package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorClimbSubsystem extends SubsystemBase {

    private CANSparkMax climbMotorRight = new CANSparkMax(Constants.CLIMB_MOTOR_RIGHT_ID, MotorType.kBrushless);
    private CANSparkMax climbMotorLeft = new CANSparkMax(Constants.CLIMB_MOTOR_LEFT_ID, MotorType.kBrushless);

    public MotorClimbSubsystem(){}

    public void SetClimbMotorSpeedRight(double speed){
        climbMotorRight.set(speed);
    }

    public void SetClimbMotorSpeedLeft(double speed){
        climbMotorLeft.set(speed);
    }

    public void StopRightClimbMotor(  ){
        climbMotorRight.set(0);
    }

    public void StopLeftClimbMotor(){
        climbMotorLeft.set(0);
    }

    public void SetBothClimbMotorSpeeds(double speed){
        climbMotorLeft.set(speed);
        climbMotorRight.set(speed);
    }

    public void StopBothClimbMotor(){
        climbMotorLeft.set(0);
        climbMotorRight.set(0);
    }

}
