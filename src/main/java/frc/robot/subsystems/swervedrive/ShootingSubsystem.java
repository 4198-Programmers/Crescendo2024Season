package frc.robot.subsystems.swervedrive;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootingSubsystem extends SubsystemBase{
    private CANSparkMax shootingMotor = new CANSparkMax(Constants.SHOOTER_MOTOR_ID, MotorType.kBrushless);

public void shootOut(double speed){
    shootingMotor.set(speed);
}

public void stop(){
    shootingMotor.set(0);
}
}
