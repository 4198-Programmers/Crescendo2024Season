package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private CANSparkMax intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_ID, MotorType.kBrushless);
    private RelativeEncoder intakeEncoder = intakeMotor.getEncoder();
    private double speed = 1.0;
    
    public IntakeSubsystem(){}

    public void intakeMotorIn(){
        intakeMotor.set(speed);
    }

    public void intakeMotorOut(){
        intakeMotor.set(-speed);
    }

    public void intakeMotorStop(){
        intakeMotor.set(0);
    }

    public double getIntakePosition(){
        double motorPosition = intakeEncoder.getPosition();
        return motorPosition;
    }

    @Override
    public void periodic(){}




}