package frc.robot.subsystems.swervedrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LeftClimbSubsystem extends SubsystemBase{
    private CANSparkMax leftClimbMotor = new CANSparkMax(Constants.LEFT_CLIMB_MOTOR_ID, MotorType.kBrushless);

    RelativeEncoder leftClimbMotorPosition = leftClimbMotor.getEncoder();


    public LeftClimbSubsystem() {
        initialize();
    }

    public void initialize(){
        leftClimbMotorPosition.setPosition(0);
    }

    public double getPosition(){
        return leftClimbMotorPosition.getPosition();
    }
    
    public void move(double speed) {
        leftClimbMotor.set(speed);
    }

    public void stop() {
        leftClimbMotor.set(0);
    }


}
