// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.InternalMoverDownCommand;
import frc.robot.commands.InternalMoverUpCommand;
import frc.robot.commands.LeftAndRightMotorClimbDownCommand;
import frc.robot.commands.LeftAndRightMotorClimbUpCommand;
import frc.robot.commands.LeftAndRightMotorClimbUpCommandDown;
import frc.robot.commands.LeftMotorClimbUpCommand;
import frc.robot.commands.RightMotorClimbDownCommand;
import frc.robot.commands.RightMotorClimbUpCommand;
import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.subsystems.MotorClimbSubsystem;
import frc.robot.commands.IntakeMotorCommand;
import frc.robot.commands.ShooterAngleCommand;
import frc.robot.commands.ShootingMotorCommand;
import frc.robot.commands.SwerveTeleopDrive;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootingSubsystem;
import frc.robot.subsystems.Swerve.SwerveSubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  // Subsystems
  private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShootingSubsystem shootingSubsytem = new ShootingSubsystem();
  private final InternalMoverSubsystem internalMoverSubsystem = new InternalMoverSubsystem();
  private final MotorClimbSubsystem motorClimbSubsystem = new MotorClimbSubsystem();

  //Commands
  //TODO missing intakeCommand

  private LeftAndRightMotorClimbUpCommand rightAndLeftMotorClimbCommandUp = new LeftAndRightMotorClimbUpCommand(motorClimbSubsystem);
  private LeftAndRightMotorClimbDownCommand rightAndLeftMotorClimbCommandDown = new LeftAndRightMotorClimbDownCommand(motorClimbSubsystem);

  private LeftMotorClimbUpCommand leftMotorClimbCommandUp = new LeftMotorClimbUpCommand(motorClimbSubsystem);
  private LeftMotorClimbUpCommand leftMotorClimbCommandDown = new LeftMotorClimbUpCommand(motorClimbSubsystem);

  private RightMotorClimbUpCommand rightMotorClimbUpCommand = new RightMotorClimbUpCommand(motorClimbSubsystem);
  private RightMotorClimbDownCommand rightMotorClimbDownCommand = new RightMotorClimbDownCommand(motorClimbSubsystem);


  private IntakeMotorCommand intakeMotorCommand = new IntakeMotorCommand(intakeSubsystem, Constants.INTAKE_MOTOR_SPEED);
  private ShootingMotorCommand shootingMotorCommand = new ShootingMotorCommand(shootingSubsytem, Constants.SHOOTING_MOTOR_SPEED);
  private InternalMoverUpCommand internalMoverUp = new InternalMoverUpCommand(internalMoverSubsystem);
  private InternalMoverDownCommand internalMoverDown = new InternalMoverDownCommand(internalMoverSubsystem);
  private ShooterAngleCommand shooterAngleCommand = new ShooterAngleCommand(shootingSubsytem, 0, 1, 0.05);
  
  //Joysticks
  Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);

  //Buttons
  JoystickButton internalMoverUpButton = new JoystickButton(rightJoystick, Constants.LEFT_JOYSTICK_BUTTON_9);
  JoystickButton internalMoverDownButton = new JoystickButton(rightJoystick, Constants.LEFT_JOYSTICK_BUTTON_7);
  JoystickButton intakeMotorButton = new JoystickButton(rightJoystick, Constants.LEFT_JOYSTICK_BUTTON_5);
  JoystickButton shootingMotorButton = new JoystickButton(rightJoystick, Constants.LEFT_JOYSTICK_BUTTON_1);
  JoystickButton changeClimbStateButton = new JoystickButton(rightJoystick, Constants.LEFT_JOYSTICK_BUTTON_8); 
  JoystickButton shootingAngleButton = new JoystickButton(rightJoystick, Constants.LEFT_JOYSTICK_BUTTON_10);

  JoystickButton changeIntakePneumaticStateButton = new JoystickButton(middleJoystick, Constants.PLACEHOLDER_BUTTON_ID);
  JoystickButton LeftMotorClimbButtonUp = new JoystickButton(middleJoystick, Constants.LEFT_JOYSTICK_BUTTON_5);
  JoystickButton LeftMotorClimbButtonDown = new JoystickButton(middleJoystick, Constants.LEFT_JOYSTICK_BUTTON_3);
  JoystickButton RightMotorClimbButtonUp = new JoystickButton(middleJoystick, Constants.LEFT_JOYSTICK_BUTTON_6);
  JoystickButton RightMotorClimbButtonDown = new JoystickButton(middleJoystick, Constants.LEFT_JOYSTICK_BUTTON_4);
  JoystickButton RightAndLeftMotorClimbButtonDown = new JoystickButton(middleJoystick, Constants.LEFT_JOYSTICK_BUTTON_9);
  JoystickButton RightAndLeftMotorClimbButtonUp = new JoystickButton(middleJoystick, Constants.LEFT_JOYSTICK_BUTTON_10);




 
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  //   swerveSubsystem.setDefaultCommand(new SwerveTeleopDrive(
  //     swerveSubsystem, 
  //     () -> leftJoystick.getX(), 
  //     () -> leftJoystick.getY(), 
  //     () -> middleJoystick.getX(), 
  //     () -> true));
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    intakeMotorButton.whileTrue(intakeMotorCommand);
    shootingMotorButton.whileTrue(shootingMotorCommand);
    internalMoverUpButton.whileTrue(internalMoverUp);
    internalMoverDownButton.whileTrue(internalMoverDown);
    shootingAngleButton.whileTrue(shooterAngleCommand);
    LeftMotorClimbButtonUp.whileTrue(leftMotorClimbCommandUp);
    LeftMotorClimbButtonDown.whileTrue(leftMotorClimbCommandDown);
    RightMotorClimbButtonUp.whileTrue(rightMotorClimbUpCommand);
    RightMotorClimbButtonDown.whileTrue(rightMotorClimbDownCommand);
    RightAndLeftMotorClimbButtonDown.whileTrue(rightAndLeftMotorClimbCommandDown);
    RightAndLeftMotorClimbButtonUp.whileTrue(rightAndLeftMotorClimbCommandUp);



    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
    //return Autos.exampleAuto();
  }
}
