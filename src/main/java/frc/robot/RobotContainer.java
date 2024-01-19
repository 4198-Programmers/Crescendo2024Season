// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.InternalMoverDownCommand;
import frc.robot.commands.InternalMoverUpCommand;
import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.commands.ChangeClimbStateCommand;
import frc.robot.commands.ChangeIntakeSolenoidCommand;
import frc.robot.commands.IntakeMotorCommand;
import frc.robot.commands.ShootingMotorCommand;
import frc.robot.subsystems.ClimbSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootingSubsytem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  // Subsystems
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShootingSubsytem shootingSubsytem = new ShootingSubsytem();
  private final InternalMoverSubsystem internalMoverSubsystem = new InternalMoverSubsystem();
  private final ClimbSubsystem climbSubsystem = new ClimbSubsystem();

  //Commands
  private IntakeMotorCommand intakeMotorCommand = new IntakeMotorCommand(intakeSubsystem, Constants.INTAKE_MOTOR_SPEED);
  private ShootingMotorCommand shootingMotorCommand = new ShootingMotorCommand(shootingSubsytem, Constants.SHOOTING_MOTOR_SPEED);
  private ChangeIntakeSolenoidCommand changeIntakeSolenoidCommand = new ChangeIntakeSolenoidCommand(intakeSubsystem);
  private InternalMoverUpCommand internalMoverUp = new InternalMoverUpCommand(internalMoverSubsystem);
  private InternalMoverDownCommand internalMoverDown = new InternalMoverDownCommand(internalMoverSubsystem);
  private ChangeClimbStateCommand climbStateChangeCommand = new ChangeClimbStateCommand(climbSubsystem);

  //Joysticks
  Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);

  
  //Buttons
  JoystickButton internalMoverUpButton = new JoystickButton(middleJoystick, Constants.INTERNAL_MOVER_UP_BOTTON_ID);
  JoystickButton internalMoverDownButton = new JoystickButton(middleJoystick, Constants.INTERNAL_MOVER_DOWN_BOTTON_ID);
  JoystickButton intakeMotorButton = new JoystickButton(leftJoystick, Constants.INTAKE_MOTOR_BUTTON_ID);
  JoystickButton shootingMotorButton = new JoystickButton(rightJoystick, Constants.SHOOTING_MOTOR_BUTTON_ID);
  JoystickButton changeIntakePneumaticStateButton = new JoystickButton(middleJoystick, Constants.CHANGE_INTAKE_PNEUMATIC_STATE_BUTTON);
  JoystickButton changeClimbStateButton = new JoystickButton(rightJoystick, Constants.CHANGE_CLIMB_STATE_BUTTON); 
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
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
    changeIntakePneumaticStateButton.whileTrue(changeIntakeSolenoidCommand);
    internalMoverUpButton.whileTrue(internalMoverUp);
    internalMoverDownButton.whileTrue(internalMoverDown);
    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.
    changeClimbStateButton.whileTrue(climbStateChangeCommand);
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
