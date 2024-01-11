package frc.robot.subsystems.Swerve;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveSubsystem extends SubsystemBase{
    private final AHRS gyro = new AHRS(SPI.Port.kMXP);

    private final SwerveModule frontLeftModule, frontRightModule, backLeftModule, backRightModule;
    private SwerveDriveOdometry odometry;
    public ShuffleboardTab driveTab = Shuffleboard.getTab("Drive");

    private final SwerveModule[] modules;

    public SwerveSubsystem(){
        frontLeftModule = new SwerveModule(
            Constants.FRONT_LEFT_MODULE_NAME, 
            Constants.FRONT_LEFT_MODULE_NUMBER, 
            Constants.FRONT_LEFT_DRIVE_MOTOR_ID, 
            Constants.FRONT_LEFT_ANGLE_MOTOR_ID, 
            Constants.FRONT_LEFT_ANGLE_ENCODER_ID, 
            Constants.FRONT_LEFT_ANGLE_OFFSET_DEGREES);
        frontRightModule = new SwerveModule(
            Constants.FRONT_RIGHT_MODULE_NAME, 
            Constants.FRONT_RIGHT_MODULE_NUMBER, 
            Constants.FRONT_RIGHT_DRIVE_MOTOR_ID, 
            Constants.FRONT_RIGHT_ANGLE_MOTOR_ID, 
            Constants.FRONT_RIGHT_ANGLE_ENCODER_ID, 
            Constants.FRONT_RIGHT_ANGLE_OFFSET_DEGREES);
        backLeftModule = new SwerveModule(
            Constants.BACK_LEFT_MODULE_NAME, 
            Constants.BACK_LEFT_MODULE_NUMBER, 
            Constants.BACK_LEFT_DRIVE_MOTOR_ID, 
            Constants.BACK_LEFT_ANGLE_MOTOR_ID, 
            Constants.BACK_LEFT_ANGLE_ENCODER_ID, 
            Constants.BACK_LEFT_ANGLE_OFFSET_DEGREES);

        odometry = new SwerveDriveOdometry(Constants.SWERVE_DRIVE_KINEMATICS, gyro.getRotation2d(), getModulePositions());
        modules = new SwerveModule[]{frontLeftModule, frontRightModule, backLeftModule, backRightModule};
        for(SwerveModule module : modules){
            driveTab.addNumber(module.getName() + " Current Angle:", () -> module.getAngle());
        }
        driveTab.addNumber("Gyro", () -> gyro.getRotation2d().getDegrees());
        
    }
}