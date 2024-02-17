// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.sensors.AbsoluteSensorRange;
import com.ctre.phoenix6.signals.AbsoluteSensorRangeValue;
import com.ctre.phoenix6.signals.SensorDirectionValue;

import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  //Phoenix v6 sensor constants
  public static final AbsoluteSensorRangeValue ANGLE_ENCODER_ABSOLUTE_SENSOR_RANGE = AbsoluteSensorRangeValue.Signed_PlusMinusHalf;
  public static final SensorDirectionValue SENSOR_DIRECTION_VALUE = SensorDirectionValue.CounterClockwise_Positive;

  //Shooter Constants
  public static final double SHOOTER_ANGLE_OFFSET = 0;
  //Angle Constants
  public static final boolean ANGLE_MOTOR_INVERTED = false;
  public static final double VOLTAGE_COMPENSATION = 12.0; //Max battery volts we can half
  public static final boolean ANGLE_ENCODER_DIRECTION = false;
  //Angle PID Controller Constants
  public static final double ANGLE_KP = 0;
  public static final double ANGLE_KI = 0;
  public static final double ANGLE_KD = 0;
  //Drive Constants
  public static final double DRIVE_VELOCITY_CONVERSION_FACTOR = 1;
  public static final double DRIVE_POSITION_CONVERSION_FACTOR = 1/6.75;
  public static final double ANGLE_POSITION_CONVERSION_FACTOR = 1/21.43;
  //Front Left Module Constants
  public static final String FRONT_LEFT_MODULE_NAME = "Front Left Swerve Module";
  public static final int FRONT_LEFT_MODULE_NUMBER = 0;
  public static final int FRONT_LEFT_DRIVE_MOTOR_ID = 7;
  public static final int FRONT_LEFT_ANGLE_MOTOR_ID = 8;
  public static final int FRONT_LEFT_ANGLE_ENCODER_ID = 7;
  public static final double FRONT_LEFT_ANGLE_OFFSET_DEGREES = 0;
  //Front Right Module Constants
  public static final String FRONT_RIGHT_MODULE_NAME = "Front Right Swerve Module";
  public static final int FRONT_RIGHT_MODULE_NUMBER = 1;
  public static final int FRONT_RIGHT_DRIVE_MOTOR_ID = 1;
  public static final int FRONT_RIGHT_ANGLE_MOTOR_ID = 2;
  public static final int FRONT_RIGHT_ANGLE_ENCODER_ID = 2;
  public static final double FRONT_RIGHT_ANGLE_OFFSET_DEGREES = 0;
  
  //Back Left Module Constants
  public static final String BACK_LEFT_MODULE_NAME = "Back Left Swerve Module";
  public static final int BACK_LEFT_MODULE_NUMBER = 2;
  public static final int BACK_LEFT_DRIVE_MOTOR_ID = 10;
  public static final int BACK_LEFT_ANGLE_MOTOR_ID = 9;
  public static final int BACK_LEFT_ANGLE_ENCODER_ID = 9;
  public static final double BACK_LEFT_ANGLE_OFFSET_DEGREES = 0;
  //Back Right Module Constants
  public static final String BACK_RIGHT_MODULE_NAME = "Back Right Swerve Module";
  public static final int BACK_RIGHT_MODULE_NUMBER = 3;
  public static final int BACK_RIGHT_DRIVE_MOTOR_ID = 4;
  public static final int BACK_RIGHT_ANGLE_MOTOR_ID = 3;
  public static final int BACK_RIGHT_ANGLE_ENCODER_ID = 3;
  public static final double BACK_RIGHT_ANGLE_OFFSET_DEGREES = 0;
  //Swerve Drive Kinematics Constants
  public static final double ROBOT_BASE_WIDTH_METERS = 0.30;
  public static final double ROBOT_BASE_LENGTH_METERS = 0.295;
  public static final double X_FROM_CENTER = ROBOT_BASE_LENGTH_METERS / 2;
  public static final double Y_FROM_CENTER = ROBOT_BASE_WIDTH_METERS / 2;
//      Robot Orientation
//               +x(front)
//               _________
//               |       |
//     +y(left)  |       | -y(right)
//               |       |
//               |_______|
//                -x(back)
  public static final double FRONT_LEFT_X_LOCATION = X_FROM_CENTER;
  public static final double FRONT_LEFT_Y_LOCATION = Y_FROM_CENTER;

  public static final double FRONT_RIGHT_X_LOCATION = X_FROM_CENTER;
  public static final double FRONT_RIGHT_Y_LOCATION = -Y_FROM_CENTER;

  public static final double BACK_LEFT_X_LOCATION = -X_FROM_CENTER;
  public static final double BACK_LEFT_Y_LOCATION = Y_FROM_CENTER;

  public static final double BACK_RIGHT_X_LOCATION = -X_FROM_CENTER;
  public static final double BACK_RIGHT_Y_LOCATION = -Y_FROM_CENTER;

  public static final SwerveDriveKinematics SWERVE_DRIVE_KINEMATICS = new SwerveDriveKinematics(
    new Translation2d(FRONT_LEFT_X_LOCATION, FRONT_LEFT_Y_LOCATION),
    new Translation2d(FRONT_RIGHT_X_LOCATION, FRONT_RIGHT_Y_LOCATION),
    new Translation2d(BACK_LEFT_X_LOCATION, BACK_LEFT_Y_LOCATION),
    new Translation2d(BACK_RIGHT_X_LOCATION, BACK_RIGHT_Y_LOCATION));
  //Pneumatic Values
  public static final int INTAKE_PNUEMATIC_INTEGER = 0;
  public static final int INTAKE_PNEUMATIC_CHANNEL_FORWARD = 0;
  public static final int INTAKE_PNEUMATIC_CHANNEL_REVERSE = 0;
  public static final int CLIMB_PNUEMATIC_INTEGER = 0;
  public static final int CLIMB_PNEUMATIC_CHANNEL_A = 0;
  public static final int CLIMB_PNEUMATIC_CHANNEL_B = 0;

  //General Subsystem Motor Constants
  public static final int INTAKE_MOTOR_ID = 5;
  public static final int SHOOTING_MOTOR_ID = 6;
  public static final int CLIMB_MOTOR_LEFT_ID = 14;
  public static final int CLIMB_MOTOR_RIGHT_ID = 13;
  public static final int INTERNAL_MOTOR_ID = 11;
  public static final int SHOOTING_MOTOR_ANGLE_ID = 12;

  //Joystick Constants
  public static final int RIGHT_JOYSTICK_PORT = 2;
  public static final int MIDDLE_JOYSTICK_PORT = 1;
  public static final int LEFT_JOYSTICK_PORT = 0;
  
  public static final int PLACEHOLDER_BUTTON_ID = 0;

  //Left Joystick Button ID Constants
  public static final int JOYSTICK_BUTTON_1 = 1;
  public static final int JOYSTICK_BUTTON_2 = 2;
  public static final int JOYSTICK_BUTTON_3 = 3;
  public static final int JOYSTICK_BUTTON_4 = 4;
  public static final int JOYSTICK_BUTTON_5 = 5;
  public static final int JOYSTICK_BUTTON_6 = 6;
  public static final int JOYSTICK_BUTTON_7 = 7;
  public static final int JOYSTICK_BUTTON_8 = 8;
  public static final int JOYSTICK_BUTTON_9 = 9;
  public static final int JOYSTICK_BUTTON_10 = 10;
  //TODO is this constant joystick ID button for 11 suppost to be equal to 12 and 12 equal to 13
  public static final int JOYSTICK_BUTTON_11 = 12;
  public static final int JOYSTICK_BUTTON_12 = 13;

  //Deadband for joysticks
    public static final double DEADBAND = 0;
  
  //Internal Mover Direction/speed
  public static final int MIDDLE_LIMIT_SWITCH = 9;
  public static final double INTERAL_MOVER_UP = 1;
  public static final double INTERNAL_MOVER_DOWN = 1;

  /*Game Target Location Constants: Y and X are measured from the corner of the red Source, 
  *and positive in their respective directions.*/
  //z height location of the target
  public static final double TARGET_Z_HEIGHT = Units.inchesToMeters(80.515);
  //y target location on coordinate plane
  public static final double TARGET_Y_DISTANCE = Units.inchesToMeters(218.42);
  //x target location on coordinate plane
  public static final double TARGET_X_DISTANCE = Units.inchesToMeters(9.055);

  //target position
  public static final Pose3d TARGET_POSITION = 
    new Pose3d(new Translation3d(TARGET_X_DISTANCE, TARGET_Y_DISTANCE, TARGET_Z_HEIGHT),
    new Rotation3d(0.0, 0.0, Units.degreesToRadians(180)));
  public static final double CAMERA_HEIGHT = 0;
  public static final double CAMERA_PITCH = 0;

  //Math Constants
  public static final double SHOOTER_MAX_VELOCITY = 0;
  public static final double INITIAL_SHOOTER_HEIGHT = 0;
  public static final double ACCELERATION_DUE_TO_GRAVITY = -9.8;
  public static final double SOURCE_TAG_HEIGHTS = Units.inchesToMeters(53.75);
  public static final double SPEAKER_TAG_HEIGHTS = Units.inchesToMeters(57.125);
  public static final double AMP_TAG_HEIGHTS = Units.inchesToMeters(53.375);
  public static final double STAGE_TAG_HEIGHTS = Units.inchesToMeters(52);

  //MotorSpeeds
  public static final double INTAKE_MOTOR_SPEED = 0.5;
  public static final double SHOOTING_MOTOR_SPEED = 1;
  
  public static final double BOTH_CLIMB_SET_SPEED = 0.1;
  public static final double LEFT_CLIMB_SET_SPEED = 0.1;
  public static final double RIGHT_CLIMB_SET_SPEED = 0.1;

  public static final double SHOOTING_ANGLE_INCREASE_SPEED = 0.2;
  public static final double SHOOTING_ANGLE_DECREASE_SPEED = 0.2;
  
  //climb min and max
  public static final double CLIMB_MOTOR_MAX = 0;
  public static final double CLIMB_MOTOR_MIN = 0;

}






