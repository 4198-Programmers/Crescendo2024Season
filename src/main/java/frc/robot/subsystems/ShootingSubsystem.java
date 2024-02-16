package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootingSubsystem extends SubsystemBase {

    private CANSparkMax shootingMotor = new CANSparkMax(Constants.SHOOTING_MOTOR_ID, MotorType.kBrushless); //MotorType TBD
    private CANSparkMax shootingMotorAngle = new CANSparkMax(Constants.SHOOTING_MOTOR_ANGLE_ID, MotorType.kBrushed);
    private RelativeEncoder shootingAngleEncoder = shootingMotorAngle.getEncoder();

    public ShootingSubsystem(){
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

//TODO SHOOTER_ANGLE_OFFSET is equal to 0 Delete?
    public double getShooterAngle(){
        double shooterAngle = (getShootingAnglePosition() / 360) + Constants.SHOOTER_ANGLE_OFFSET;
        return shooterAngle;
    }
//TODO setShooterAngle needs to be finished (check -speed to make sure it is right for the motor)
    public void setShooterAngle(double angle, double speed, double tolerance) {
        double currentAngle = getShooterAngle();
        if(currentAngle < (angle - tolerance)) {
            shootingMotorAngle.set(speed);
        } if(currentAngle > (angle + tolerance)) {
            shootingMotorAngle.set(-speed);
        } else {
            shootingMotorAngle.set(0);
        }
    }
}