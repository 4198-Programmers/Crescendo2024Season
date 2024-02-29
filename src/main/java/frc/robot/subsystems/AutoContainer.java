package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.units.Measure;
import edu.wpi.first.units.Units;
import edu.wpi.first.wpilibj.shuffleboard.LayoutType;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.commands.swervedrive.IntakeCommand;
import frc.robot.commands.swervedrive.LeftClimbCommand;
import frc.robot.subsystems.swervedrive.AmpbarPNSubsystem;
import frc.robot.subsystems.swervedrive.IntakePneumaticsSubsystem;
import frc.robot.subsystems.swervedrive.IntakeSubsystem;
import frc.robot.subsystems.swervedrive.InternalMoverSubsystem;
import frc.robot.subsystems.swervedrive.LeftClimbSubsystem;
import frc.robot.subsystems.swervedrive.RightClimbSubsystem;
import frc.robot.subsystems.swervedrive.ShootingAngleSubsytems;
import frc.robot.subsystems.swervedrive.ShootingSubsystem;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;
import frc.robot.commands.swervedrive.GameAutos.GameAutoDriveCommand;
import frc.robot.commands.swervedrive.GameAutos.GameAutoIntakeCommand;
import frc.robot.commands.swervedrive.GameAutos.GameAutoInternalMoverCommand;
import frc.robot.commands.swervedrive.GameAutos.GameAutoShootingAngleCommand;
import frc.robot.commands.swervedrive.GameAutos.GameAutoShootingCommand;

public class AutoContainer {
    // used to choose Auto
    Shuffleboard autoBoard;
    ShuffleboardTab autoTab;
    IntakeSubsystem intakeSubsystem;
    ShootingAngleSubsytems shootingAngleSubsytems;
    ShootingSubsystem shootingSubsystem;
    SwerveSubsystem swerveSubsystem;
    LeftClimbSubsystem leftClimbSubsystem;
    RightClimbSubsystem rightClimbSubsystem;
    InternalMoverSubsystem internalMoverSubsystem;
    AmpbarPNSubsystem ampbarPNSubsystem;
    IntakePneumaticsSubsystem intakePneumaticsSubsystem;
    
        Pose2d firstPose = new Pose2d(new Translation2d(Units.Meters.of(0), Units.Meters.of(1)),
                Rotation2d.fromDegrees(0));
        Pose2d secondPose = new Pose2d(new Translation2d(Units.Meters.of(1), Units.Meters.of(0)),
                Rotation2d.fromDegrees(0));
        Pose2d thirdPose = new Pose2d(new Translation2d(Units.Meters.of(0), Units.Meters.of(-1)),
                Rotation2d.fromDegrees(0));
        Pose2d lastPose = new Pose2d(new Translation2d(Units.Meters.of(-1), Units.Meters.of(0)),
                Rotation2d.fromDegrees(0));


    public AutoContainer(IntakeSubsystem intakeSubsystem, ShootingAngleSubsytems shootingAngleSubsytems,
            ShootingSubsystem shootingSubsystem, SwerveSubsystem swerveSubsystem, LeftClimbSubsystem leftClimbSubsystem,
            RightClimbSubsystem rightClimbSubsystem, InternalMoverSubsystem internalMoverSubsystem,
            AmpbarPNSubsystem ampbarPNSubsystem, IntakePneumaticsSubsystem intakePneumaticsSubsystem) {
        this.intakeSubsystem = intakeSubsystem;
        this.shootingAngleSubsytems = shootingAngleSubsytems;
        this.shootingSubsystem = shootingSubsystem;
        this.swerveSubsystem = swerveSubsystem;
        this.leftClimbSubsystem = leftClimbSubsystem;
        this.rightClimbSubsystem = rightClimbSubsystem;
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.ampbarPNSubsystem = ampbarPNSubsystem;
        this.intakePneumaticsSubsystem = intakePneumaticsSubsystem;
    }

    public void SetupAutoOptions(SendableChooser<Command> sendableChooser) {
        sendableChooser.setDefaultOption("Intake", new IntakeCommand(intakeSubsystem, internalMoverSubsystem, 0));
        sendableChooser.setDefaultOption("Test Auto 1", this.swerveSubsystem.getAutonomousCommand("Test Auto 1"));
        sendableChooser.addOption("GameAutoIntakeCommand",
                new GameAutoIntakeCommand(intakeSubsystem, intakePneumaticsSubsystem, internalMoverSubsystem, 0.5, 15000));

        sendableChooser.addOption("makeABox", this.swerveSubsystem.driveToPose(firstPose)
                .andThen(this.swerveSubsystem.driveToPose(secondPose))
                .andThen(this.swerveSubsystem.driveToPose(thirdPose))
                .andThen(this.swerveSubsystem.driveToPose(lastPose)));

    }

    SequentialCommandGroup redDefaultAuto = new SequentialCommandGroup(
        new GameAutoShootingAngleCommand(shootingAngleSubsytems, 1, 40, 2)
        .andThen(new GameAutoShootingCommand(shootingSubsystem, internalMoverSubsystem, 1, 1000))
        .andThen(this.swerveSubsystem.driveToPose(firstPose))
        .andThen(new GameAutoIntakeCommand(intakeSubsystem, intakePneumaticsSubsystem, internalMoverSubsystem, 0, 0))
        .andThen(this.swerveSubsystem.driveToPose(secondPose))
        .andThen(this.swerveSubsystem.driveToPose(secondPose))
        .andThen(new GameAutoShootingCommand(shootingSubsystem, internalMoverSubsystem, 0, 0))
        .andThen(this.swerveSubsystem.driveToPose(thirdPose))
        .andThen(this.swerveSubsystem.driveToPose(thirdPose))
        .andThen(new GameAutoIntakeCommand(intakeSubsystem, intakePneumaticsSubsystem, internalMoverSubsystem, 0, 0))
        .andThen(this.swerveSubsystem.driveToPose(lastPose))
        .andThen(this.swerveSubsystem.driveToPose(lastPose))
        .andThen(new GameAutoShootingCommand(shootingSubsystem, internalMoverSubsystem, 0, 0)));
}
