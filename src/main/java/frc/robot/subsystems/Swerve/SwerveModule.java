package frc.robot.subsystems.Swerve;

import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix.sensors.SensorInitializationStrategy;
import com.ctre.phoenix.sensors.WPI_CANCoder;
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
  private CANSparkMax driveMotor;
  private CANSparkMax angleMotor;
  private RelativeEncoder driveEncoder;
  private WPI_CANCoder angleEncoder;
  private PIDController angleController;
  private String moduleName;
  private int moduleNumber;

  public SwerveModule(String moduleName, int moduleNumber, int driveMotorID, int angleMotorID, int angleEncoderID, double angleOffsetDegrees){
    driveMotor = new CANSparkMax(driveMotorID, MotorType.kBrushless);
    driveEncoder = driveMotor.getEncoder();

    angleMotor = new CANSparkMax(angleMotorID, MotorType.kBrushless);
    angleEncoder = new WPI_CANCoder(angleEncoderID);

    driveMotor.restoreFactoryDefaults();
    angleMotor.restoreFactoryDefaults();
    angleEncoder.configFactoryDefault();

    angleMotor.setInverted(Constants.ANGLE_MOTOR_INVERTED);
    angleMotor.enableVoltageCompensation(Constants.VOLTAGE_COMPENSATION);
    angleMotor.setIdleMode(IdleMode.kBrake);

    angleEncoder.configAbsoluteSensorRange(AbsoluteSensorRange.Signed_PlusMinus180);
    angleEncoder.configMagnetOffset(angleOffsetDegrees);
    angleEncoder.configSensorDirection(Constants.ANGLE_ENCODER_DIRECTION);
    angleEncoder.configSensorInitializationStrategy(SensorInitializationStrategy.BootToAbsolutePosition);

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

  public String getName(){
    return moduleName;
  }
  public int getModuleNumber(){
    return moduleNumber;
  }
  
  public SwerveModuleState getState(){
    return new SwerveModuleState(driveEncoder.getVelocity(), Rotation2d.fromDegrees(getAngle()));
  }

  public SwerveModulePosition getPosition(){
    return new SwerveModulePosition(driveEncoder.getPosition(), Rotation2d.fromDegrees(getAngle()));
  }

  public void setState(SwerveModuleState state){
    SwerveModuleState optimizedState = SwerveModuleState.optimize(state, getState().angle);
    double angleOutput = angleController.calculate(getState().angle.getDegrees(), optimizedState.angle.getDegrees());
    angleMotor.set(angleOutput);
    driveMotor.set(optimizedState.speedMetersPerSecond);
  }

  public double getAngle(){
    return angleEncoder.getAbsolutePosition();
  }

  public double getDriveSpeed(){
    return getState().speedMetersPerSecond;
  }
  public double getAngleSpeed(){
    return angleEncoder.getVelocity();
  }
}
