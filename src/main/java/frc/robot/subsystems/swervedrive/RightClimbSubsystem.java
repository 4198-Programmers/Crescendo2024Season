package frc.robot.subsystems.swervedrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RightClimbSubsystem extends SubsystemBase{
    private CANSparkMax rightClimbMotor = new CANSparkMax(Constants.RIGHT_CLIMB_MOTOR_ID, MotorType.kBrushless);

    RelativeEncoder rightClimbPosition = rightClimbMotor.getEncoder();

    public RightClimbSubsystem() {
        initialize();
    }

    
    public void initialize(){
        rightClimbPosition.setPosition(0);
    }

    public double rightClimbMotorPosition(){
        return rightClimbPosition.getPosition();
    }

    public void move(double speed) {
        rightClimbMotor.set(speed);
    }
    public void stop() {
        rightClimbMotor.set(0);
    }
}
