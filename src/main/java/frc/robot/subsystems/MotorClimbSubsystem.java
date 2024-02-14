package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class MotorClimbSubsystem extends SubsystemBase {

    private CANSparkMax climbMotorRight = new CANSparkMax(Constants.CLIMB_MOTOR_RIGHT_ID, MotorType.kBrushless);
    private CANSparkMax climbMotorLeft = new CANSparkMax(Constants.CLIMB_MOTOR_LEFT_ID, MotorType.kBrushless);
    private RelativeEncoder climbEncoderRight = climbMotorRight.getEncoder();
    private RelativeEncoder climbEncoderLeft = climbMotorLeft.getEncoder();

    public MotorClimbSubsystem(){}

    public void setClimbMotorSpeedRight(double speed){
        climbMotorRight.set(speed);
    }

    public void setClimbMotorSpeedLeft(double speed){
        climbMotorLeft.set(speed);
    }

    public void stopRightClimbMotor(  ){
        climbMotorRight.set(0);
    }

    public void stopLeftClimbMotor(){
        climbMotorLeft.set(0);
    }

    public void setBothClimbMotorSpeeds(double speed){
        climbMotorLeft.set(speed);
        climbMotorRight.set(speed);
    }

    public void stopBothClimbMotor(){
        climbMotorLeft.set(0);
        climbMotorRight.set(0);
    }

    public double getClimbMotorLeftPosition(){
        double motorPosition = climbEncoderLeft.getPosition();
        return motorPosition;
    }
 
    public double getClimbMotorRightPosition(){
        double motorPosition = climbEncoderRight.getPosition();
        return motorPosition;
    }

}
