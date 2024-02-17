package frc.robot.subsystems.swervedrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class RightClimbSubsystem extends SubsystemBase{
    private CANSparkMax rightClimbMotor = new CANSparkMax(Constants.RIGHT_CLIMB_MOTOR_ID, MotorType.kBrushless);

    public void move(double speed) {
        rightClimbMotor.set(speed);
    }
    public void stop() {
        rightClimbMotor.set(0);
    }
}
