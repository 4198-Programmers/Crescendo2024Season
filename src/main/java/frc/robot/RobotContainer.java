// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.InternalMoverDownCommand;
import frc.robot.commands.InternalMoverUpCommand;
import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.subsystems.MotorClimbSubsystem;
import frc.robot.commands.AimAngleDownCommand;
import frc.robot.commands.AimAngleupCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.ShooterAngleCommand;
import frc.robot.commands.ShootingMotorCommand;
import frc.robot.commands.SwerveTeleopDrive;
import frc.robot.commands.AutoCommands.AutoIntake;
import frc.robot.commands.ClimbCommands.BothMotorClimbDownCommand;
import frc.robot.commands.ClimbCommands.BothMotorClimbUpCommand;
import frc.robot.commands.ClimbCommands.LeftMotorClimbUpCommand;
import frc.robot.commands.ClimbCommands.RightMotorClimbDownCommand;
import frc.robot.commands.ClimbCommands.RightMotorClimbUpCommand;
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
  private BothMotorClimbUpCommand bothMotorClimbCommandUp = new BothMotorClimbUpCommand(motorClimbSubsystem);
  private BothMotorClimbDownCommand bothMotorClimbCommandDown = new BothMotorClimbDownCommand(motorClimbSubsystem);

  private LeftMotorClimbUpCommand leftMotorClimbUpCommand = new LeftMotorClimbUpCommand(motorClimbSubsystem);
  private LeftMotorClimbUpCommand leftMotorClimbDownCommand = new LeftMotorClimbUpCommand(motorClimbSubsystem);

  private RightMotorClimbUpCommand rightMotorClimbUpCommand = new RightMotorClimbUpCommand(motorClimbSubsystem);
  private RightMotorClimbDownCommand rightMotorClimbDownCommand = new RightMotorClimbDownCommand(motorClimbSubsystem);


  private IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem, Constants.INTAKE_MOTOR_SPEED);
  private ShootingMotorCommand shootingMotorCommand = new ShootingMotorCommand(shootingSubsytem, Constants.SHOOTING_MOTOR_SPEED);
  
  private InternalMoverUpCommand internalMoverUpCommand = new InternalMoverUpCommand(internalMoverSubsystem);
  private InternalMoverDownCommand internalMoverDownCommand = new InternalMoverDownCommand(internalMoverSubsystem);
  private final AutoIntake autoIntake = new AutoIntake(intakeSubsystem, internalMoverSubsystem);

  private ShooterAngleCommand shooterAngleCommand = new ShooterAngleCommand(shootingSubsytem, 0, 1, 0.05);
  //TODO deleate AimAngleupCommand and AimAngleDownCommand when aim command finished
  private AimAngleupCommand aimAngleUpCommand = new AimAngleupCommand(shootingSubsytem);
  private AimAngleDownCommand aimAngleDownCommand = new AimAngleDownCommand(shootingSubsytem);


  //Joysticks
  Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);

  //Buttons
  JoystickButton internalMoverUpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_5);
  JoystickButton internalMoverDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_3);
  JoystickButton intakeButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_2);
  JoystickButton autoIntakeButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_8);

  JoystickButton shootingMotorButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_1);
  JoystickButton aimAngleUpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_6);
  JoystickButton aimAngleDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_4);

  JoystickButton changeIntakePneumaticStateButton = new JoystickButton(middleJoystick, Constants.PLACEHOLDER_BUTTON_ID);

  JoystickButton LeftMotorClimbButtonUp = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_5);
  JoystickButton LeftMotorClimbButtonDown = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_3);
  JoystickButton RightMotorClimbButtonUp = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_6);
  JoystickButton RightMotorClimbButtonDown = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_4);
  JoystickButton bothMotorClimbButtonDown = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_9);
  JoystickButton bothMotorClimbButtonUp = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_10);




 
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
    intakeButton.whileTrue(intakeCommand);
    internalMoverUpButton.whileTrue(internalMoverUpCommand);
    internalMoverDownButton.whileTrue(internalMoverDownCommand);
    autoIntakeButton.whileTrue(autoIntake);

    shootingMotorButton.whileTrue(shootingMotorCommand);

    LeftMotorClimbButtonUp.whileTrue(leftMotorClimbUpCommand);
    LeftMotorClimbButtonDown.whileTrue(leftMotorClimbDownCommand);
    RightMotorClimbButtonUp.whileTrue(rightMotorClimbUpCommand);
    RightMotorClimbButtonDown.whileTrue(rightMotorClimbDownCommand);

    bothMotorClimbButtonDown.whileTrue(bothMotorClimbCommandDown);
    bothMotorClimbButtonUp.whileTrue(bothMotorClimbCommandUp);

    aimAngleUpButton.whileTrue(aimAngleUpCommand);
    aimAngleDownButton.whileTrue(aimAngleDownCommand);



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
