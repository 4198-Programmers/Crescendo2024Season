// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
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
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandJoystick;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.complexCommands.AutoAmpCommand;
import frc.robot.commands.complexCommands.AutoIntakeCommand;
import frc.robot.commands.complexCommands.AutoSetShootingAngleCommand;
import frc.robot.commands.complexCommands.AutoShootingCommand;
import frc.robot.commands.simpleCommands.AmpBarPneumaticDownCommand;
import frc.robot.commands.simpleCommands.AmpBarPneumaticStateCommand;
import frc.robot.commands.simpleCommands.AmpBarPneumaticUpCommand;
import frc.robot.commands.simpleCommands.IntakeCommand;
import frc.robot.commands.simpleCommands.IntakePneumaticsCommand;
import frc.robot.commands.simpleCommands.InternalMoverCommand;
import frc.robot.commands.simpleCommands.LeftClimbCommand;
import frc.robot.commands.simpleCommands.LeftClimbLimitlessCommand;
import frc.robot.commands.simpleCommands.RightClimbCommand;
import frc.robot.commands.simpleCommands.RightClimbLimitlessCommand;
import frc.robot.commands.simpleCommands.ShootingAngleCommand;
import frc.robot.commands.simpleCommands.ShootingCommand;
import frc.robot.commands.swervedrive.zeroGyro;
import frc.robot.commands.swervedrive.drivebase.AbsoluteDriveAdv;
import frc.robot.subsystems.AmpbarPNSubsystem;
import frc.robot.subsystems.AutoContainer;
import frc.robot.subsystems.IntakePneumaticsSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.subsystems.LeftClimbSubsystem;
import frc.robot.subsystems.RightClimbSubsystem;
import frc.robot.subsystems.ShootingAngleSubsytems;
import frc.robot.subsystems.ShootingSubsystem;
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

  private final AmpbarPNSubsystem ampbarPNSubsystem = new AmpbarPNSubsystem();
  private final IntakePneumaticsSubsystem intakePneumaticsSubsystem = new IntakePneumaticsSubsystem();

  //Joysticks 
   Joystick rightJoystick = new Joystick(Constants.RIGHT_JOYSTICK_ID);
   Joystick middleJoystick = new Joystick(Constants.MIDDLE_JOYSTICK_ID);
   Joystick leftJoystick = new Joystick(Constants.LEFT_JOYSTICK_ID);

   //buttons 
    JoystickButton intakeInButton = new JoystickButton(leftJoystick, Constants.JOYSTICK_BUTTON_1);
    JoystickButton zeroGyroButton = new JoystickButton(leftJoystick, Constants.JOYSTICK_BUTTON_11);

    JoystickButton autoIntakeButton = new JoystickButton(middleJoystick, Constants.JOYSTICK_BUTTON_1);

    JoystickButton autoShootButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_1);
    JoystickButton autoAmpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_2);
    JoystickButton shootingButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_3);
    JoystickButton shooterAngleDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_4);
    JoystickButton ampButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_5);
    JoystickButton shooterAngleUpButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_6);
    JoystickButton lClimbDownLimitlessButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_7);
    JoystickButton lClimbUpLimitlessButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_8);
    JoystickButton rClimbDownLimitlessButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_9);
    JoystickButton rClimbUpLimitlessButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_10);
    JoystickButton setLowShooterButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_11);
    JoystickButton angleShootSpeakerButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_12);

    //JoystickButton interalMoverDownButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_3);
    //JoystickButton bClimbDownLimitlessButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_11);
    //JoystickButton bClimbUpLimitlessButton = new JoystickButton(rightJoystick, Constants.JOYSTICK_BUTTON_12);

JoystickButton PnUp = new JoystickButton(leftJoystick, 6);
JoystickButton PnDown = new JoystickButton(leftJoystick, 4);




    SendableChooser<Command> autoChooser = new SendableChooser<>();
    AutoContainer autoContainer = new AutoContainer(intakeSubsystem, shootingAngleSubsytems, shootingSubsystem, drivebase, 
    leftClimbSubsystem, rightClimbSubsystem, internalMoverSubsystem, ampbarPNSubsystem, intakePneumaticsSubsystem);
    
    
   public RobotContainer()
  {
    this.autoContainer.SetupAutoOptions(autoChooser);
    Shuffleboard.getTab("Autos").add(autoChooser);
    CameraServer.startAutomaticCapture();
    CameraServer.startAutomaticCapture(1);
    Shuffleboard.getTab("Autos").addBoolean("Middle limit switch", () -> internalMoverSubsystem.middleLimitStatus());
    compressor.enableDigital();
    drivebase.zeroGyro();

    
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

//right joystick 
zeroGyroButton.whileTrue(new zeroGyro(drivebase));
intakeInButton.whileTrue(new IntakeCommand(intakeSubsystem, internalMoverSubsystem, Constants.INTAKE_MOTOR_SPEED));

//left joystick 
autoIntakeButton.whileTrue(new AutoIntakeCommand(intakeSubsystem, internalMoverSubsystem, intakePneumaticsSubsystem,0.5 , 1));

  //left Joystick
//interalMoverDownButton.whileTrue(new InternalMoverCommand(internalMoverSubsystem, -Constants.INTERNAL_MOVER_SPEED));
shooterAngleUpButton.whileTrue(new ShootingAngleCommand(shootingAngleSubsytems, -Constants.SHOOTING_ANGLE_MOTOR_SPEED));
shooterAngleDownButton.whileTrue(new ShootingAngleCommand(shootingAngleSubsytems, Constants.SHOOTING_ANGLE_MOTOR_SPEED));
shootingButton.whileTrue(new ShootingCommand(shootingSubsystem, internalMoverSubsystem, - Constants.SHOOTING_MOTOR_SPEED, rightJoystick, Constants.MAX_SHOOTING_SPEED));
lClimbUpLimitlessButton.whileTrue(new LeftClimbLimitlessCommand(leftClimbSubsystem, -Constants.CLIMB_SPEED, () -> middleJoystick.getThrottle()));
lClimbDownLimitlessButton.whileTrue(new LeftClimbLimitlessCommand(leftClimbSubsystem, Constants.CLIMB_SPEED, () -> middleJoystick.getThrottle()));
rClimbUpLimitlessButton.whileTrue(new RightClimbLimitlessCommand(rightClimbSubsystem, -Constants.CLIMB_SPEED, () -> middleJoystick.getThrottle()));
rClimbDownLimitlessButton.whileTrue(new RightClimbLimitlessCommand(rightClimbSubsystem, Constants.CLIMB_SPEED, () -> middleJoystick.getThrottle()));
//bClimbUpLimitlessButton.whileTrue(new RightClimbLimitlessCommand(rightClimbSubsystem, -Constants.CLIMB_SPEED, () -> middleJoystick.getThrottle())
//  .alongWith(new LeftClimbLimitlessCommand(leftClimbSubsystem, Constants.CLIMB_SPEED, () -> middleJoystick.getThrottle())));
//bClimbDownLimitlessButton.whileTrue(new RightClimbLimitlessCommand(rightClimbSubsystem, Constants.CLIMB_SPEED, () -> middleJoystick.getThrottle())
//  .alongWith(new LeftClimbLimitlessCommand(leftClimbSubsystem, -Constants.CLIMB_SPEED, () -> middleJoystick.getThrottle())));
autoAmpButton.toggleOnTrue(new AutoAmpCommand(shootingSubsystem, internalMoverSubsystem, shootingAngleSubsytems, ampbarPNSubsystem, -0.5, 0.5, 0.5));
autoShootButton.toggleOnTrue(new AutoShootingCommand(shootingSubsystem, internalMoverSubsystem, shootingAngleSubsytems, -8, 1, 0.5));
angleShootSpeakerButton.whileTrue(new AutoSetShootingAngleCommand(shootingAngleSubsytems, -8, 0.5));
setLowShooterButton.whileTrue(new AutoSetShootingAngleCommand(shootingAngleSubsytems, -0.5, 0.5));
ampButton.toggleOnTrue(new AmpBarPneumaticStateCommand(ampbarPNSubsystem));

PnDown.toggleOnTrue(new AmpBarPneumaticDownCommand(ampbarPNSubsystem));
PnUp.toggleOnTrue(new AmpBarPneumaticUpCommand(ampbarPNSubsystem));



//-12.24 amp location 61

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

    //return drivebase.getAutonomousCommand("command");

    return autoChooser.getSelected();
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
