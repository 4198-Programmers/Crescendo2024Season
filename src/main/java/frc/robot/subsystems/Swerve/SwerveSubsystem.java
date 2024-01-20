package frc.robot.subsystems.Swerve;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveSubsystem extends SubsystemBase{
    //This is how we determine the front of the field.
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
        backRightModule = new SwerveModule(
            Constants.BACK_RIGHT_MODULE_NAME, 
            Constants.BACK_RIGHT_MODULE_NUMBER, 
            Constants.BACK_RIGHT_DRIVE_MOTOR_ID, 
            Constants.BACK_RIGHT_ANGLE_MOTOR_ID, 
            Constants.BACK_RIGHT_ANGLE_ENCODER_ID, 
            Constants.BACK_RIGHT_ANGLE_OFFSET_DEGREES);

        odometry = new SwerveDriveOdometry(Constants.SWERVE_DRIVE_KINEMATICS, gyro.getRotation2d(), getModulePositions());
        modules = new SwerveModule[]{frontLeftModule, frontRightModule, backLeftModule, backRightModule};
        for(SwerveModule module : modules){
            driveTab.addNumber(module.getName() + " Current Angle:", () -> module.getAngle());
        }
        driveTab.addNumber("Gyro", () -> gyro.getRotation2d().getDegrees());
    }
    @Override
    public void periodic() {
        odometry.update(gyro.getRotation2d(), getModulePositions());
    }

    public void drive(double xSpeed, double ySpeed, double zSpeed, boolean fieldOriented){
        SwerveModuleState[] states;
        if(fieldOriented){
            states = Constants.SWERVE_DRIVE_KINEMATICS.toSwerveModuleStates(ChassisSpeeds.fromFieldRelativeSpeeds(xSpeed, ySpeed, zSpeed, gyro.getRotation2d()));
        }else{
            states = Constants.SWERVE_DRIVE_KINEMATICS.toSwerveModuleStates(new ChassisSpeeds(xSpeed, ySpeed, zSpeed));
        }
        for(SwerveModule module : modules){
            System.out.println(module.getName() + " DriveSpeed: " + module.getDriveSpeed());
            System.out.println(module.getName() + " Angle Speed: " + module.getAngleSpeed());
            System.out.println(module.getName() + " Current Angle: " + module.getAngle());
            System.out.println(module.getName() + " Wanted Angle: " + states[module.getModuleNumber()].angle.getDegrees());
            System.out.println(module.getName() + " Optimized Angle: " + SwerveModuleState.optimize(states[module.getModuleNumber()], module.getState().angle));
        }
        setModuleStates(states);
    }

    public SwerveModuleState[] getModuleStates(){
        return new SwerveModuleState[]{
            frontLeftModule.getState(),
            frontRightModule.getState(),
            backLeftModule.getState(),
            backRightModule.getState()
        };
    }

    public SwerveModulePosition[] getModulePositions(){
        return new SwerveModulePosition[]{
            frontLeftModule.getPosition(),
            frontRightModule.getPosition(),
            backLeftModule.getPosition(),
            backRightModule.getPosition()
        };
    }

    public void setModuleStates(SwerveModuleState[] desiredStates){
        SwerveDriveKinematics.desaturateWheelSpeeds(desiredStates, 1);
        for(SwerveModule module: modules){
            module.setState(desiredStates[module.getModuleNumber()]);
        }
    }
}