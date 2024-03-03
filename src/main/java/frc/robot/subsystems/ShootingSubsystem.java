package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootingSubsystem extends SubsystemBase{
    private CANSparkMax shootingMotor = new CANSparkMax(Constants.SHOOTER_MOTOR_ID, MotorType.kBrushless);
    private CANSparkMax shootingMotor2 = new CANSparkMax(Constants.SHOOTER_MOTOR_2_ID, MotorType.kBrushless);
    private RelativeEncoder shooterEncoder = shootingMotor.getEncoder();

public void shootOut(double speed){
    shootingMotor.set(-speed);
    shootingMotor2.set(-speed);
}

public void stop(){
    shootingMotor.set(0);
    shootingMotor2.set(0);
}

public double getSpeed(){
    return shooterEncoder.getVelocity();
}

public double getVelocity(){
    return shooterEncoder.getVelocity();
}
}
