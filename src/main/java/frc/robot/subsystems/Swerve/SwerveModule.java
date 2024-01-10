package frc.robot.subsystems.Swerve;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

/**This is the class to set up each swerve module.
 * <p>
 * Each swerve module will have all of the things located here.
 */
public class SwerveModule {
    /**This is the motor that is going to cause the robot to actually move */
    private CANSparkMax driveMotor;
    /**This is the motor that causes the robot to turn */
    private CANSparkMax angleMotor;
    /**Used to get information from the motor */
    private RelativeEncoder driveEncoder;
    
}
