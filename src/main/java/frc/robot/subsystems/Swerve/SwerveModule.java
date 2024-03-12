
package frc.robot.subsystems.Swerve;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.CANcoderConfiguration;
import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import frc.robot.Constants;

/**This is the class to set up each swerve module.
 * <p>
 * Each swerve module will have all of the things located here.
 */

public class SwerveModule {
  //Initializing all the objects we need for a swerve module


  private CANSparkMax driveMotor;
  private CANSparkMax angleMotor;
  private RelativeEncoder driveEncoder;
  private CANcoder angleEncoder;
  private CANcoderConfiguration angleEncoderConfiguration;
  private PIDController angleController;
  private String moduleName;
  private int moduleNumber;


  public SwerveModule(String moduleName, int moduleNumber, int driveMotorID, int angleMotorID, int angleEncoderID, double angleOffsetDegrees){
    driveMotor = new CANSparkMax(driveMotorID, MotorType.kBrushless);
    driveEncoder = driveMotor.getEncoder();

    angleMotor = new CANSparkMax(angleMotorID, MotorType.kBrushless);
    angleEncoder = new CANcoder(angleEncoderID);
    angleEncoderConfiguration = new CANcoderConfiguration();

    driveMotor.restoreFactoryDefaults();
    angleMotor.restoreFactoryDefaults();

    angleEncoderConfiguration.MagnetSensor.AbsoluteSensorRange = Constants.ANGLE_ENCODER_ABSOLUTE_SENSOR_RANGE;
    angleEncoderConfiguration.MagnetSensor.MagnetOffset = angleOffsetDegrees;
    angleEncoderConfiguration.MagnetSensor.SensorDirection = Constants.SENSOR_DIRECTION_VALUE;
    angleEncoder.getConfigurator().apply(angleEncoderConfiguration);

    angleMotor.setInverted(Constants.ANGLE_MOTOR_INVERTED);
    angleMotor.enableVoltageCompensation(Constants.VOLTAGE_COMPENSATION);
    angleMotor.setIdleMode(IdleMode.kBrake);

    angleController = new PIDController(Constants.ANGLE_KP, Constants.ANGLE_KI, Constants.ANGLE_KD);
    angleController.enableContinuousInput(-1, 1);
    // angleController.setIntegratorRange(-1, 1);

    driveMotor.enableVoltageCompensation(Constants.VOLTAGE_COMPENSATION);
    driveMotor.setIdleMode(IdleMode.kBrake);

    driveEncoder.setVelocityConversionFactor(Constants.DRIVE_VELOCITY_CONVERSION_FACTOR);
    driveEncoder.setPositionConversionFactor(Constants.DRIVE_POSITION_CONVERSION_FACTOR);
    this.moduleName = moduleName;
    this.moduleNumber = moduleNumber;
  }
/**
 * Used for Print Statements
 * @return Module Name to identify each module
 */

  public String getName(){
    return moduleName;
  }
  /**
   * Used in SwerveModule array to identify each module
   * @return Module Number for the location in the array
   */

  public int getModuleNumber(){
    return moduleNumber;
  }
  /**
   * Get the state of the Module.
   * <p>
   * This is the current speed the robot is moving and what angle the motors are currently facing.
   * @return
   */

  public SwerveModuleState getState(){
    return new SwerveModuleState(driveEncoder.getVelocity(), Rotation2d.fromDegrees(getAngle()));
  }
/**
 * Get the distance the wheels have traveled throughout the game.
 * @return the distance traveled and current angle of the wheels
 */

  public SwerveModulePosition getPosition(){
    return new SwerveModulePosition(driveEncoder.getPosition(), Rotation2d.fromDegrees(getAngle()));
  }
/**
 * This sets the drive speed and angle speed
 * <p>
 * Angle speed is based on the current angle and the wanted angle
 * @param state We are passing in the current state of the robot in order to calculate how fast the angle motors need to move to reach the wanted angle
 */

  public void setState(SwerveModuleState state){
    SwerveModuleState optimizedState = SwerveModuleState.optimize(state, getState().angle);
    
    double angleOutput = angleController.calculate(getState().angle.getDegrees(), optimizedState.angle.getDegrees());
    angleMotor.set(angleOutput);
    driveMotor.set(optimizedState.speedMetersPerSecond);
  }
/**
 * We are using the absolute position of the angle motors
 * @return Aboslute position of angle encoders
 */

  public double getAngle(){
    StatusSignal<Double> anglePosition = angleEncoder.getAbsolutePosition();
    return anglePosition.getValueAsDouble();
  }
/**
 * Get the drive speed of the module
 * @return Drive Speed
 */

  public double getDriveSpeed(){
    return getState().speedMetersPerSecond;
  }
  /**
   * Get the angle speed of the module
   * @return Angle Speed
   */

  public StatusSignal<Double> getAngleSpeed(){
    return angleEncoder.getVelocity();
  }
}
