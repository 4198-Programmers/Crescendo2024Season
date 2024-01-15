package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootingSubsytem extends SubsystemBase {

    private CANSparkMax shootingMotor = new CANSparkMax(Constants.SHOOTING_MOTOR_ID, MotorType.kBrushless);
    private RelativeEncoder shootingEncoder = shootingMotor.getEncoder();
    private double speed = 1.0;

    public ShootingSubsytem(){}

    public void shootingMotorIn(){
        shootingMotor.set(speed);
    }
    
    public void shootingMotorOut(){
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
