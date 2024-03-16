// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.pathplanner.lib.util.PIDConstants;

import edu.wpi.first.math.geometry.Translation3d;
import edu.wpi.first.math.util.Units;
import swervelib.math.Matter;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean constants. This
 * class should not be used for any other purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants
{
//Swerve stuff (DONT MESS WITH)
  public static final double ROBOT_MASS = (148 - 20.3) * 0.453592; // 32lbs * kg per pound
  public static final Matter CHASSIS    = new Matter(new Translation3d(0, 0, Units.inchesToMeters(8)), ROBOT_MASS);
  public static final double LOOP_TIME  = 0.13; //s, 20ms + 110ms sprk max velocity lag

  public static final class Events {

    public static final String AMP_EVENT_NAME_ON = "NAME";
    public static final String AMP_EVENT_NAME_OFF = null;

  }
  public static final class AutonConstants
  {

    public static final PIDConstants TRANSLATION_PID = new PIDConstants(0.7, 0, 0);
    public static final PIDConstants ANGLE_PID   = new PIDConstants(0.4, 0, 0.01);
  }

  public static final class DrivebaseConstants
  {

    // Hold time on motor brakes when disabled
    public static final double WHEEL_LOCK_TIME = 10; // seconds
  }

  public static class OperatorConstants
  {

    // Joystick Deadband
    public static final double LEFT_X_DEADBAND  = 0.1;
    public static final double LEFT_Y_DEADBAND  = 0.1;
    public static final double RIGHT_X_DEADBAND = 0.1;
    public static final double TURN_CONSTANT    = 6;
  }

//motor ID
public static final int INTAKE_MOTOR_ID = 5;
public static final int INTERNAL_MOVER_MOTOR_ID = 11;
public static final int SHOOTER__ANGLE_MOTOR_ID = 12;
public static final int SHOOTER_MOTOR_ID = 6;
public static final int LEFT_CLIMB_MOTOR_ID = 14;
public static final int RIGHT_CLIMB_MOTOR_ID = 13;
public static final int AMP_BAR_PN_ID = 4;
public static final int SHOOTER_MOTOR_2_ID = 15;

public static final int BOTTOM_LIMIT_SWITCH_ID = 7;

//motor speeds
public static final double INTAKE_MOTOR_SPEED = 1;
public static final double INTERNAL_MOVER_SPEED = 0.5;
public static final double SHOOTING_MOTOR_SPEED = 1;
public static final double CLIMB_SPEED = 0.5;
public static final double SHOOTING_ANGLE_MOTOR_SPEED = 0.5;

//limits
public static final double MAX_SHOOTING_SPEED = 5000;
public static final double MAX_LEFT_CLIMB_POSITION = 100;
public static final double MIN_LEFT_CLIMB_POSITION = -1;
public static final double MAX_RIGHT_CLIMB_POSITION = 100;
public static final double MIN_RIGHT_CLIMB_POSITION = -1;

//swtiches 
public static final int MIDDLE_LIMIT_SWITCH_ID = 9;

//LED
public static final int DRIVE_BASE_LED_ID = 3;
public static final int AddressableLEDBuffer = 300;

//Pneumatic channel
public static final int INTAKE_PNEUMATIC_CHANNEL = 5;

//joystick id
public static final int RIGHT_JOYSTICK_ID = 2;
public static final int MIDDLE_JOYSTICK_ID = 1;
public static final int LEFT_JOYSTICK_ID = 0;

//joystick button
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
public static final int JOYSTICK_BUTTON_11 = 11;
public static final int JOYSTICK_BUTTON_12 = 12;

//shooter angle math constants
public static final double SHOOTER_ANGLE_A = -0.0235642;
public static final double SHOOTER_ANGLE_B = -1.52065;
public static final double SHOOTER_ANGLE_C = 43.2451;


}
