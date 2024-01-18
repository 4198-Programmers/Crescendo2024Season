package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootingSubsytem extends SubsystemBase {

    private CANSparkMax shootingMotor = new CANSparkMax(Constants.SHOOTING_MOTOR_ID, MotorType.kBrushless); //MotorType TBD
    private CANSparkMax shootingMotorAngle = new CANSparkMax(Constants.SHOOTING_MOTOR_ANGLE_ID, MotorType.kBrushless);
    private RelativeEncoder shootingEncoder = shootingMotor.getEncoder();
    private RelativeEncoder shootingAngleEncoder = shootingMotorAngle.getEncoder();

    public ShootingSubsytem(){
        shootingAngleEncoder.setPositionConversionFactor(Constants.ANGLE_POSITION_CONVERSION_FACTOR);
    }
    //Negative is one direction positive is the other
    public void shootingMotorSpeed(double speed){
        shootingMotor.set(speed);
    }

    public void shootingMotorAngle(double speed){
        shootingMotorAngle.set(speed);
    }

    public void shootingMotorStop(){
        shootingMotor.set(0);
    }

    public double getShootingAnglePosition(){
        double motorPosition = shootingAngleEncoder.getPosition();
        return motorPosition;
    }

    public void shootingMotorAngleStop(){
        shootingMotorAngle.set(0);
    }

    public void getAngleShooter(){
        getShootingAnglePosition();
    }
    
}