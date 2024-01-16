package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootingSubsytem extends SubsystemBase {

    private CANSparkMax shootingMotor = new CANSparkMax(Constants.SHOOTING_MOTOR_ID, MotorType.kBrushless); //MotorType TBD
    private RelativeEncoder shootingEncoder = shootingMotor.getEncoder();

    public ShootingSubsytem(){}
    //Negative is one direction positive is the other
    public void shootingMotorSpeed(double speed){
        shootingMotor.set(speed);
    }

    public void shootingMotorStop(){
        shootingMotor.set(0);
    }

    public double getShootingPosition(){
        double motorPosition = shootingEncoder.getPosition();
        return motorPosition;
    }

    
}