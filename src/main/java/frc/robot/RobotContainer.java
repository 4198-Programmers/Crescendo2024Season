// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.RobotBase;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.swervedrive.AmpbarPNCommand;
import frc.robot.commands.swervedrive.IntakeCommand;
import frc.robot.commands.swervedrive.InternalMoverCommand;
import frc.robot.commands.swervedrive.LeftClimbCommand;
import frc.robot.commands.swervedrive.RightClimbCommand;
import frc.robot.commands.swervedrive.ShootingAngleCommand;
import frc.robot.commands.swervedrive.ShootingCommand;
import frc.robot.commands.swervedrive.zeroGyro;
import frc.robot.commands.swervedrive.drivebase.AbsoluteDriveAdv;
import frc.robot.subsystems.swervedrive.AmpbarPNSubsystem;
import frc.robot.subsystems.swervedrive.IntakeSubsystem;
import frc.robot.subsystems.swervedrive.InternalMoverSubsystem;
import frc.robot.subsystems.swervedrive.LeftClimbSubsystem;
import frc.robot.subsystems.swervedrive.RightClimbSubsystem;
import frc.robot.subsystems.swervedrive.ShootingAngleSubsytems;
import frc.robot.subsystems.swervedrive.ShootingSubsystem;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;
import java.io.File;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a "declarative" paradigm, very
 * little robot logic should actually be handled in the {@link Robot} periodic methods (other than the scheduler calls).
 * Instead, the structure of the robot (including subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer
{
//swerve (DO NOT TOUTCH)
  // The robot's subsystems and commands are defined here...
  private final SwerveSubsystem drivebase = new SwerveSubsystem(new File(Filesystem.getDeployDirectory(),
                                                                         "swerve/neo"));
  // CommandJoystick rotationController = new CommandJoystick(1);
  // Replace with CommandPS4Controller or CommandJoystick if needed
  CommandJoystick driverController = new CommandJoystick(1);

  // CommandJoystick driverController   = new CommandJoystick(3);//(OperatorConstants.DRIVER_CONTROLLER_PORT);
  XboxController driverXbox = new XboxController(0);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */

   private Compressor compressor = new Compressor(21, PneumaticsModuleType.CTREPCM);
   
   //subsystems 
   private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final InternalMoverSubsystem internalMoverSubsystem = new InternalMoverSubsystem();
  private final ShootingAngleSubsytems shootingAngleSubsytems = new ShootingAngleSubsytems();
  private final ShootingSubsystem shootingSubsystem = new ShootingSubsystem();
  private final LeftClimbSubsystem leftClimbSubsystem = new LeftClimbSubsystem();
  private final RightClimbSubsystem rightClimbSubsystem = new RightClimbSubsystem();
  private final AmpbarPNSubsystem ampbarPNSubsystem = new AmpbarPNSubsystem(compressor);

  //Joysticks 
   Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_ID);
   Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_ID);
   Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_ID);

   //buttons 
    JoystickButton intakeInButton = new JoystickButton(leftJoystick, Constants.JOYSTICK_BUTTON_1);
    JoystickButton intakeOutButton = new JoystickButton(leftJoystick, Constants.JOYSTICK_BUTTON_2);
    JoystickButton zeroGyroButton = new JoystickButton(leftJoystick, Constants.JOYSTICK_BUTTON_11);

    JoystickButton interalMoverUpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_5);
    JoystickButton interalMoverDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_3);
    JoystickButton shooterAngleUpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_6);
    JoystickButton shooterAngleDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_4);
    JoystickButton shootingButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_1);
    JoystickButton rClimbUpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_10);
    JoystickButton rClimbDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_9);
    JoystickButton lClimbUpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_8);
    JoystickButton lClimbDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_7);
    JoystickButton bClimbDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_11);
    JoystickButton bClimbUpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_12);
    JoystickButton ampButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_4);


   public RobotContainer()
  {
    // Configure the trigger bindings
    configureBindings();
//Swerve buttons (DO NOT TOUCH)
    AbsoluteDriveAdv closedAbsoluteDriveAdv = new AbsoluteDriveAdv(drivebase,
                                                                   () -> MathUtil.applyDeadband(leftJoystick.getY(),
                                                                                                OperatorConstants.LEFT_Y_DEADBAND),
                                                                   () -> MathUtil.applyDeadband(leftJoystick.getX(),
                                                                                                OperatorConstants.LEFT_X_DEADBAND),
                                                                   () -> MathUtil.applyDeadband(middleJoystick.getX(),
                                                                                                OperatorConstants.RIGHT_X_DEADBAND),
                                                                   driverXbox::getYButtonPressed,
                                                                   driverXbox::getAButtonPressed,
                                                                   driverXbox::getXButtonPressed,
                                                                   driverXbox::getBButtonPressed);

    // Applies deadbands and inverts controls because joysticks
    // are back-right positive while robot
    // controls are front-left positive
    // left stick controls translation
    // right stick controls the desired angle NOT angular rotation
    Command driveFieldOrientedDirectAngle = drivebase.driveCommand(
        () -> MathUtil.applyDeadband(leftJoystick.getY(), OperatorConstants.LEFT_Y_DEADBAND),
        () -> MathUtil.applyDeadband(leftJoystick.getX(), OperatorConstants.LEFT_X_DEADBAND),
        () -> middleJoystick.getX(),
        () -> middleJoystick.getY());

    // Applies deadbands and inverts controls because joysticks
    // are back-right positive while robot
    // controls are front-left positive
    // left stick controls translation
    // right stick controls the angular velocity of the robot
    Command driveFieldOrientedAnglularVelocity = drivebase.driveCommand(
        () -> MathUtil.applyDeadband(leftJoystick.getY(), OperatorConstants.LEFT_Y_DEADBAND),
        () -> MathUtil.applyDeadband(leftJoystick.getX(), OperatorConstants.LEFT_X_DEADBAND),
        () -> MathUtil.applyDeadband(middleJoystick.getX(), OperatorConstants.LEFT_X_DEADBAND));

    Command driveFieldOrientedDirectAngleSim = drivebase.simDriveCommand(
        () -> MathUtil.applyDeadband(driverXbox.getLeftY(), OperatorConstants.LEFT_Y_DEADBAND),
        () -> MathUtil.applyDeadband(driverXbox.getLeftX(), OperatorConstants.LEFT_X_DEADBAND),
        () -> driverXbox.getRawAxis(2));

    drivebase.setDefaultCommand(
        !RobotBase.isSimulation() ? driveFieldOrientedAnglularVelocity : driveFieldOrientedDirectAngleSim);
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary predicate, or via the
   * named factories in {@link edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for
   * {@link CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller PS4}
   * controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight joysticks}.
   */
  private void configureBindings()
  {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
//Swerve DO NOT TOUCH
    new JoystickButton(driverXbox, 1).onTrue((new InstantCommand(drivebase::zeroGyro)));
    new JoystickButton(driverXbox, 3).onTrue(new InstantCommand(drivebase::addFakeVisionReading));
    new JoystickButton(driverXbox,
                       2).whileTrue(
        Commands.deferredProxy(() -> drivebase.driveToPose(
                                   new Pose2d(new Translation2d(4, 4), Rotation2d.fromDegrees(0)))
                              ));
//    new JoystickButton(driverXbox, 3).whileTrue(new RepeatCommand(new InstantCommand(drivebase::lock, drivebase)));
  
//non swerve button binding
zeroGyroButton.whileTrue(new zeroGyro(drivebase));
intakeInButton.whileTrue(new IntakeCommand(intakeSubsystem, internalMoverSubsystem, -Constants.INTAKE_MOTOR_SPEED));
intakeOutButton.whileTrue(new IntakeCommand(intakeSubsystem, internalMoverSubsystem,  Constants.INTAKE_MOTOR_SPEED));
interalMoverUpButton.whileTrue(new InternalMoverCommand(internalMoverSubsystem, Constants.INTERNAL_MOVER_SPEED));
interalMoverDownButton.whileTrue(new InternalMoverCommand(internalMoverSubsystem, -Constants.INTERNAL_MOVER_SPEED));
shooterAngleUpButton.whileTrue(new ShootingAngleCommand(shootingAngleSubsytems, -Constants.SHOOTING_MOTOR_SPEED));
shooterAngleDownButton.whileTrue(new ShootingAngleCommand(shootingAngleSubsytems, Constants.SHOOTING_MOTOR_SPEED));
shootingButton.whileTrue(new ShootingCommand(shootingSubsystem, Constants.SHOOTING_MOTOR_SPEED));
lClimbUpButton.whileTrue(new LeftClimbCommand(leftClimbSubsystem, Constants.CLIMB_SPEED));
lClimbDownButton.whileTrue(new LeftClimbCommand(leftClimbSubsystem, -Constants.CLIMB_SPEED));
rClimbUpButton.whileTrue(new RightClimbCommand(rightClimbSubsystem, Constants.CLIMB_SPEED));
rClimbDownButton.whileTrue(new RightClimbCommand(rightClimbSubsystem, -Constants.CLIMB_SPEED));
bClimbUpButton.whileTrue(new RightClimbCommand(rightClimbSubsystem, Constants.CLIMB_SPEED)
  .alongWith(new LeftClimbCommand(leftClimbSubsystem, Constants.CLIMB_SPEED)));
bClimbDownButton.whileTrue(new RightClimbCommand(rightClimbSubsystem, -Constants.CLIMB_SPEED)
  .alongWith(new LeftClimbCommand(leftClimbSubsystem, -Constants.CLIMB_SPEED)));
ampButton.onTrue(new AmpbarPNCommand(ampbarPNSubsystem));

}

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand()
  {
    // An example command will be run in autonomous
    //return drivebase.getAutonomousCommand("New Auto");
    return null;
  }

  public void setDriveMode()
  {
    //drivebase.setDefaultCommand();
  }

  public void setMotorBrake(boolean brake)
  {
    drivebase.setMotorBrake(brake);
  }
}
