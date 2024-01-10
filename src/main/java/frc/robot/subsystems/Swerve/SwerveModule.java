package frc.robot.subsystems.Swerve;

import com.ctre.phoenix.sensors.WPI_CANCoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.controller.PIDController;

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
    /**Used to let angle motors remember their positions */
    private WPI_CANCoder angleEncoder;
    /**This is used to have the angle motors go to the right spot */
    private PIDController anglePIDController;
    /**Used in println's to make it easier to see */
    private String swerveModuleName;
    /**Used in arrays to make it easier to read */
    private int moduleNumber;

    public SwerveModule(String swerveModuleName, int moduleNumber; int driveMotorID, int angleMotorID, int angleEncoderID, double angleOffsetDegrees){
        
    }
}
