package frc.robot.subsystems;

import com.pathplanner.lib.auto.NamedCommands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.units.Units;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.simpleCommands.AmpBarPneumaticStateCommand;
import frc.robot.commands.simpleCommands.IntakeCommand;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;
import frc.robot.commands.complexCommands.AutoAmpCommand;
import frc.robot.commands.complexCommands.AutoDriveCommand;
import frc.robot.commands.complexCommands.AutoIntakeCommand;
import frc.robot.commands.complexCommands.AutoSetShootingAngleCommand;
import frc.robot.commands.complexCommands.AutoShootingCommand;

public class AutoContainer extends SubsystemBase {
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

        SequentialCommandGroup redDefaultAuto;

        Pose2d firstPose = new Pose2d(new Translation2d(Units.Meters.of(0), Units.Meters.of(1)),
                        Rotation2d.fromDegrees(0));
        Pose2d secondPose = new Pose2d(new Translation2d(Units.Meters.of(1), Units.Meters.of(0)),
                        Rotation2d.fromDegrees(0));
        Pose2d thirdPose = new Pose2d(new Translation2d(Units.Meters.of(0), Units.Meters.of(-1)),
                        Rotation2d.fromDegrees(0));
        Pose2d lastPose = new Pose2d(new Translation2d(Units.Meters.of(-1), Units.Meters.of(0)),
                        Rotation2d.fromDegrees(0));

        public AutoContainer(IntakeSubsystem intakeSubsystem, ShootingAngleSubsytems shootingAngleSubsytems,
                        ShootingSubsystem shootingSubsystem, SwerveSubsystem swerveSubsystem,
                        LeftClimbSubsystem leftClimbSubsystem,
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

                NamedCommands.registerCommand("Auto Shoot Command", new AutoShootingCommand(shootingSubsystem,
                                internalMoverSubsystem, shootingAngleSubsytems, -8, 1, 1).withTimeout(1.5
                                ));
                NamedCommands.registerCommand("Auto Intake Command", new AutoIntakeCommand(intakeSubsystem,
                                internalMoverSubsystem, intakePneumaticsSubsystem, 1, 1).withTimeout(10));
                NamedCommands.registerCommand("Shooter Angle Command",
                                new AutoSetShootingAngleCommand(shootingAngleSubsytems, -8, 1).withTimeout(10));
                NamedCommands.registerCommand("Auto Amp Command",
                                new AutoAmpCommand(shootingSubsystem, internalMoverSubsystem, shootingAngleSubsytems,
                                                ampbarPNSubsystem, -8, 1, 1).withTimeout(2));
                NamedCommands.registerCommand("Amp Bar Pneumatics",
                                new AmpBarPneumaticStateCommand(ampbarPNSubsystem).withTimeout(2));
                // NamedCommands.registerCommand("Shooting Amp Command", new
                // ShootingCommand(shootingSubsystem, internalMoverSubsystem, 0.5, 1,
                // 2500).withTimeout(3));
                // NamedCommands.registerCommand("Shooting Command", new
                // ShootingCommand(shootingSubsystem, internalMoverSubsystem, 1, ,
                // 5000).withTimeout(3));
        }

        public void SetupAutoOptions(SendableChooser<Command> sendableChooser) {
                // Autos we can attempt
                sendableChooser.addOption("Amp Auto H", this.swerveSubsystem.getAutonomousCommand("Amp Auto H"));

                sendableChooser.addOption("Right Side Taxi H Auto",
                                this.swerveSubsystem.getAutonomousCommand("Right Side Taxi H Auto"));
                sendableChooser.addOption("Right Side 2 Note H Auto",
                                this.swerveSubsystem.getAutonomousCommand("Right Side 2 Note H Auto"));
                sendableChooser.addOption("Left Side Taxi H Auto",
                                this.swerveSubsystem.getAutonomousCommand("Left Side Taxi H Auto"));
                sendableChooser.addOption("Left Side 2 Note H Auto",
                                this.swerveSubsystem.getAutonomousCommand("Left Side 2 Note H Auto"));

                sendableChooser.addOption("Test back and forth",
                                this.swerveSubsystem.getAutonomousCommand("test back and forth"));
                sendableChooser.addOption("test 2step back and right",
                                this.swerveSubsystem.getAutonomousCommand("test 2step back and right"));
                sendableChooser.addOption("Test Auto", this.swerveSubsystem.getAutonomousCommand("Test Auto"));
                sendableChooser.addOption("Just Taxi Auto",
                                this.swerveSubsystem.getAutonomousCommand("Just Back Only Auto"));
                sendableChooser.addOption("Just Shoot Auto", new AutoShootingCommand(shootingSubsystem,
                                internalMoverSubsystem, shootingAngleSubsytems, -8, 1, 1));
                sendableChooser.addOption("Right Side Out Only Auto",
                                this.swerveSubsystem.getAutonomousCommand("Right Side Out Only Auto"));
                sendableChooser.addOption("Right Shoot and Out Only Auto",
                                this.swerveSubsystem.getAutonomousCommand("Right Shoot and Out Only Auto"));
                // ONLY mean it will complete just the stated command in title
                // sendableChooser.addOption("Right Side and Amp Auto",
                // this.swerveSubsystem.getAutonomousCommand("Right Side and Amp Auto"));
                // sendableChooser.addOption("Right Side Full",
                // this.swerveSubsystem.getAutonomousCommand("Right Side Full"));
                // FULL mean to the full extent of its capibilities
                sendableChooser.addOption("Middle Full Auto",
                                this.swerveSubsystem.getAutonomousCommand("Middle Full Auto"));

                sendableChooser.addOption("Left Out Only Auto",
                                this.swerveSubsystem.getAutonomousCommand("Left Out Only Auto"));
                sendableChooser.addOption("Left Side Shoot and Out Only Auto",
                                this.swerveSubsystem.getAutonomousCommand("Left Side Shoot and Out Only Auto"));

                sendableChooser.addOption("RotateAuto", this.swerveSubsystem.getAutonomousCommand("Rotate Auto"));
                sendableChooser.addOption("Middle 2 Note Auto", this.swerveSubsystem.getAutonomousCommand("Middle 2 Note Auto"));
                sendableChooser.addOption("HAuto 2 Note Middle", chooseSequentialCommand(0));
                sendableChooser.addOption("HAuto 2 Note Amp Blue", chooseSequentialCommand(1));
                sendableChooser.addOption("HAuto 2 Note Amp Red", chooseSequentialCommand(2));
                sendableChooser.addOption("HAuto Taxi", chooseSequentialCommand(3));
                // sendableChooser.addOption("Left Side Out Auto",
                // this.swerveSubsystem.getAutonomousCommand("Left Side Out Auto"));
                // sendableChooser.addOption("Left Side Full Auto",
                // this.swerveSubsystem.getAutonomousCommand("Left Side Full Auto"));

                // sendableChooser.addOption("Amp Auto",
                // this.swerveSubsystem.getAutonomousCommand("Amp Auto"));
                // amp commands/pnumatics are not re writen for auto

                // general locations on path planner
                /*
                 * Amp Location x 1.85 y 7.7 r -90
                 * Right Side starting x 0.75 y 4.5 r -60
                 * Middle Side starting x 1.3 y 5.55 r 0
                 * Left Side starting x 0.75 y 4.5 r -60
                 * 
                 * shoot non button side
                 * intake on button side
                 * 
                 * middle rings
                 * ring 1 (top) x 10 y 7.45
                 * ring 2 x 10 y 5.9
                 * ring 3 x 10 y 4.1
                 * ring 4 x 10 y 2.45
                 * ring 5 x 10 y 0.75
                 * 
                 */

                /*
                 * sendableChooser.addOption("makeABox",
                 * this.swerveSubsystem.driveToPose(firstPose)
                 * .andThen(this.swerveSubsystem.driveToPose(secondPose))
                 * .andThen(this.swerveSubsystem.driveToPose(thirdPose))
                 * .andThen(this.swerveSubsystem.driveToPose(lastPose)));
                 * sendableChooser.addOption("Red Auto 1", this.redDefaultAuto);
                 */
        }

        public Command chooseSequentialCommand(int choice) {
                switch (choice) {
                        // Middle Auto
                        case 0:
                                return new AutoSetShootingAngleCommand(shootingAngleSubsytems, -8, 1)
                                                .andThen(new AutoShootingCommand(shootingSubsystem,
                                                                internalMoverSubsystem, shootingAngleSubsytems, -8, 1,
                                                                1).withTimeout(3))
                                                .andThen(new AutoDriveCommand(swerveSubsystem, () -> -1, () -> 0, () -> 0).withTimeout(3)
                                                                .alongWith(new IntakeCommand(intakeSubsystem,
                                                                                internalMoverSubsystem, 1)
                                                                                .withTimeout(5)))
                                                .andThen(new AutoDriveCommand(swerveSubsystem, () -> 1, () -> 0, () -> 0).withTimeout(3))
                                                .andThen(new AutoSetShootingAngleCommand(shootingAngleSubsytems, -8, 1))
                                                .andThen(new AutoShootingCommand(shootingSubsystem,
                                                                internalMoverSubsystem, shootingAngleSubsytems, -8, 1,
                                                                1));
                        // Blue Amp 2 Note Auto
                        case 1:
                                return new AutoDriveCommand(swerveSubsystem, () -> 1, () -> -1, () -> -1)
                                                                .withTimeout(3)
                                                .andThen(new AutoAmpCommand(shootingSubsystem, internalMoverSubsystem,
                                                                shootingAngleSubsytems, ampbarPNSubsystem, -1, 1, 1)
                                                                .withTimeout(3))
                                                .andThen(new AutoDriveCommand(swerveSubsystem, () -> 1, () -> 1, () -> 1).withTimeout(4)
                                                                .alongWith(new AutoIntakeCommand(intakeSubsystem,
                                                                                internalMoverSubsystem,
                                                                                intakePneumaticsSubsystem, 1, 1)))
                                                .andThen(new AutoDriveCommand(swerveSubsystem, () -> -1, () -> -1, () -> -1)
                                                                .withTimeout(4))
                                                .andThen(new AutoAmpCommand(shootingSubsystem, internalMoverSubsystem,
                                                                shootingAngleSubsytems, ampbarPNSubsystem, -1, 1, 1))
                                                .andThen(new AutoDriveCommand(swerveSubsystem, () -> 1, () -> 0, () -> 0).withTimeout(5));
                        // Red Amp 2 Note Auto
                        case 2:
                                return new AutoDriveCommand(swerveSubsystem, () -> 1, () -> 1, () -> -1).withTimeout(3)
                                                .andThen(new AutoAmpCommand(shootingSubsystem, internalMoverSubsystem,
                                                                shootingAngleSubsytems, ampbarPNSubsystem, -1, 1, 1)
                                                                .withTimeout(3))
                                                .andThen(new AutoDriveCommand(swerveSubsystem, () -> 1, () -> -1, () -> 1).withTimeout(4)
                                                                .alongWith(new AutoIntakeCommand(intakeSubsystem,
                                                                                internalMoverSubsystem,
                                                                                intakePneumaticsSubsystem, 1, 1)))
                                                .andThen(new AutoDriveCommand(swerveSubsystem, () -> -1, () -> 1, () -> -1)
                                                                .withTimeout(4))
                                                .andThen(new AutoAmpCommand(shootingSubsystem, internalMoverSubsystem,
                                                                shootingAngleSubsytems, ampbarPNSubsystem, -1, 1, 1))
                                                .andThen(new AutoDriveCommand(swerveSubsystem, () -> 1, () -> 0, () -> 0).withTimeout(5));
                        case 3:
                                return new AutoDriveCommand(swerveSubsystem, () -> 1, () -> 0, () -> 0).withTimeout(4);
                default: return null;
                        }
        }
}
