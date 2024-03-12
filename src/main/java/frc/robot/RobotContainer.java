// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.subsystems.MotorClimbSubsystem;
import frc.robot.subsystems.AmpBarSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootingSubsystem;
import frc.robot.subsystems.Swerve.SwerveSubsystem;
import frc.robot.commands.InternalMoverDownCommand;
import frc.robot.commands.InternalMoverUpCommand;
import frc.robot.commands.MoveAmpMotorDown;
import frc.robot.commands.MoveAmpMotorUp;
import frc.robot.commands.MoveIntakeDown;
import frc.robot.commands.MoveIntakeUp;
import frc.robot.commands.AimAngleDownCommand;
import frc.robot.commands.AimAngleupCommand;

import frc.robot.commands.ShooterAngleCommand;
import frc.robot.commands.ShootingMotorCommand;
import frc.robot.commands.SwerveTeleopDrive;
import frc.robot.commands.ClimbCommands.BothMotorClimbDownCommand;
import frc.robot.commands.ClimbCommands.BothMotorClimbUpCommand;
import frc.robot.commands.ClimbCommands.LeftMotorClimbDownCommand;
import frc.robot.commands.ClimbCommands.LeftMotorClimbUpCommand;
import frc.robot.commands.ClimbCommands.RightMotorClimbDownCommand;
import frc.robot.commands.ClimbCommands.RightMotorClimbUpCommand;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  //Singletons
  private Compressor pneumaticsCompressor = new Compressor(21, PneumaticsModuleType.CTREPCM);
  // Subsystems
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShootingSubsystem shootingSubsytem = new ShootingSubsystem();
  private final InternalMoverSubsystem internalMoverSubsystem = new InternalMoverSubsystem();
  private final MotorClimbSubsystem motorClimbSubsystem = new MotorClimbSubsystem();
  private final AmpBarSubsystem ampBarSubsystem = new AmpBarSubsystem();
  private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();

  //Commands
  private MoveIntakeDown moveIntakeDown = new MoveIntakeDown(intakeSubsystem);
  private MoveIntakeUp moveIntakeUp = new MoveIntakeUp(intakeSubsystem);
  private ShootingMotorCommand shootingMotorCommand = new ShootingMotorCommand(shootingSubsytem);

  private InternalMoverUpCommand internalMoverUp = new InternalMoverUpCommand(internalMoverSubsystem);
  private InternalMoverDownCommand internalMoverDown = new InternalMoverDownCommand(internalMoverSubsystem);
  private MoveAmpMotorUp moveAmpMotorUp = new MoveAmpMotorUp(ampBarSubsystem);
  private MoveAmpMotorDown moveAmpMotorDown = new MoveAmpMotorDown(ampBarSubsystem);
  
  private ShooterAngleCommand shooterAngleCommand = new ShooterAngleCommand(shootingSubsytem, 0, 1, 0.05);
  private AimAngleDownCommand aimAngleDownCommand = new AimAngleDownCommand(shootingSubsytem); 
  private AimAngleupCommand aimAngleupCommand = new AimAngleupCommand(shootingSubsytem);

  private BothMotorClimbDownCommand bothMotorClimbDownCommand = new BothMotorClimbDownCommand(motorClimbSubsystem);
  private BothMotorClimbUpCommand bothMotorClimbUpCommand = new BothMotorClimbUpCommand(motorClimbSubsystem);
  private LeftMotorClimbDownCommand leftMotorClimbDownCommand = new LeftMotorClimbDownCommand(motorClimbSubsystem);
  private LeftMotorClimbUpCommand leftMotorClimbUpCommand = new LeftMotorClimbUpCommand(motorClimbSubsystem);
  private RightMotorClimbDownCommand rightMotorClimbDownCommand = new RightMotorClimbDownCommand(motorClimbSubsystem);
  private RightMotorClimbUpCommand rightMotorClimbUpCommand = new RightMotorClimbUpCommand(motorClimbSubsystem);

  //Joysticks
  Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_PORT);
  Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_PORT);
  Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_PORT);

  
  //Buttons
  JoystickButton internalMoverUpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_5);
  JoystickButton internalMoverDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_3);

  JoystickButton intakeMotorButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_2);

  JoystickButton shootingMotorButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_1);

  JoystickButton moveIntakeUpButton = new JoystickButton(leftJoystick, Constants.JOYSTICK_BUTTON_3);
  JoystickButton moveIntakeDownButton = new JoystickButton(leftJoystick, Constants.JOYSTICK_BUTTON_4);
  JoystickButton moveAmpBarUpButton = new JoystickButton(leftJoystick, Constants.JOYSTICK_BUTTON_5);
  JoystickButton moveAmpBarDownButton = new JoystickButton(leftJoystick, Constants.JOYSTICK_BUTTON_6);

  JoystickButton ShootingAngleUpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_6);
  JoystickButton ShootingAngleDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_4);

  JoystickButton BothMotorClimbUpButton = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_8);
  JoystickButton BothMotorClimbDownButton = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_7);
  JoystickButton LeftMotorClimbButtonUp = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_5);
  JoystickButton LeftMotorClimbButtonDown = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_3);
  JoystickButton RightMotorClimbButtonUp = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_6);
  JoystickButton RightMotorClimbButtonDown = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_4);
 
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    //Singletons
    pneumaticsCompressor.enableDigital();
    // Configure the trigger bindings
    configureBindings();
     swerveSubsystem.setDefaultCommand(new SwerveTeleopDrive(
      swerveSubsystem, 
    () -> leftJoystick.getX(), 
       () -> leftJoystick.getY(), 
     () -> middleJoystick.getX(), 
     () -> true));
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

    shootingMotorButton.whileTrue(shootingMotorCommand);
    internalMoverUpButton.whileTrue(internalMoverUp);
    internalMoverDownButton.whileTrue(internalMoverDown);
   // shootingAngleButton.whileTrue(shooterAngleCommand);
    
    moveAmpBarDownButton.whileTrue(moveAmpMotorDown);
    moveAmpBarUpButton.whileTrue(moveAmpMotorUp);
    moveIntakeDownButton.whileTrue(moveIntakeDown);
    moveIntakeUpButton.whileTrue(moveIntakeUp);

    
    LeftMotorClimbButtonUp.whileTrue(leftMotorClimbUpCommand);
    LeftMotorClimbButtonDown.whileTrue(leftMotorClimbDownCommand);
    RightMotorClimbButtonUp.whileTrue(rightMotorClimbUpCommand);
    RightMotorClimbButtonDown.whileTrue(rightMotorClimbDownCommand);
    BothMotorClimbDownButton.whileTrue(bothMotorClimbDownCommand);
    BothMotorClimbUpButton.whileTrue(bothMotorClimbUpCommand);

    ShootingAngleUpButton.whileTrue(aimAngleupCommand);
    ShootingAngleDownButton.whileTrue(aimAngleDownCommand);

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
