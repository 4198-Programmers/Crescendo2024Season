// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  //Angle Constants
  public static final boolean ANGLE_MOTOR_INVERTED = false;
  public static final double VOLTAGE_COMPENSATION = 12.0; //Max battery volts we can half
  public static final boolean ANGLE_ENCODER_DIRECTION = false;
  //Angle PID Controller Constants
  public static final double ANGLE_KP = 0;
  public static final double ANGLE_KI = 0;
  public static final double ANGLE_KD = 0;
  //Drive Constants
  public static final double DRIVE_VELOCITY_CONVERSION_FACTOR = 0;
  public static final double DRIVE_POSITION_CONVERSION_FACTOR = 0;
  //Front Left Module Constants
  public static final String FRONT_LEFT_MODULE_NAME = null;
  public static final int FRONT_LEFT_MODULE_NUMBER = 0;
  public static final int FRONT_LEFT_DRIVE_MOTOR_ID = 0;
  public static final int FRONT_LEFT_ANGLE_MOTOR_ID = 0;
  public static final int FRONT_LEFT_ANGLE_ENCODER_ID = 0;
  public static final double FRONT_LEFT_ANGLE_OFFSET_DEGREES = 0;
  //Front Right Module Constants
  public static final String FRONT_RIGHT_MODULE_NAME = null;
  public static final int FRONT_RIGHT_MODULE_NUMBER = 0;
  public static final int FRONT_RIGHT_DRIVE_MOTOR_ID = 0;
  public static final int FRONT_RIGHT_ANGLE_MOTOR_ID = 0;
  public static final int FRONT_RIGHT_ANGLE_ENCODER_ID = 0;
  public static final double FRONT_RIGHT_ANGLE_OFFSET_DEGREES = 0;
  //Back Left Module Constants
  public static final String BACK_LEFT_MODULE_NAME = null;
  public static final int BACK_LEFT_MODULE_NUMBER = 0;
  public static final int BACK_LEFT_DRIVE_MOTOR_ID = 0;
  public static final int BACK_LEFT_ANGLE_MOTOR_ID = 0;
  public static final int BACK_LEFT_ANGLE_ENCODER_ID = 0;
  public static final double BACK_LEFT_ANGLE_OFFSET_DEGREES = 0;
  //Back Right Module Constants
  public static final String BACK_RIGHT_MODULE_NAME = null;
  public static final int BACK_RIGHT_MODULE_NUMBER = 0;
  public static final int BACK_RIGHT_DRIVE_MOTOR_ID = 0;
  public static final int BACK_RIGHT_ANGLE_MOTOR_ID = 0;
  public static final int BACK_RIGHT_ANGLE_ENCODER_ID = 0;
  public static final double BACK_RIGHT_ANGLE_OFFSET_DEGREES = 0;
  //Swerve Drive Kinematics Constants
  public static final double ROBOT_BASE_WIDTH_METERS = 0;
  public static final double ROBOT_BASE_LENGTH_METERS = 0;
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
  public static final SwerveDriveKinematics SWERVE_DRIVE_KINEMATICS = null;
  //General Subsystem Motor Constants
  public static final int INTAKE_MOTOR_ID = 0;
  //Joystick Constants
  public static final int RIGHT_JOYSTICK_PORT = 0;
  public static final int MIDDLE_JOYSTICK_PORT = 0;
  public static final int LEFT_JOYSTICK_PORT = 0;
  //Joystick Button ID Constants
  public static final int INTAKE_MOTOR_IN_BUTTON_ID = 0;
  public static final int INTAKE_MOTOR_OUT_BUTTON_ID = 0;

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
  //Deadband for joysticks
    public static final double DEADBAND = 0;
}
