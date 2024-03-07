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
import frc.robot.commands.simpleCommands.ShootingCommand;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;
import frc.robot.commands.complexCommands.AutoAmpCommand;
import frc.robot.commands.complexCommands.AutoIntakeCommand;
import frc.robot.commands.complexCommands.AutoSetShootingAngleCommand;
import frc.robot.commands.complexCommands.AutoShootingCommand;

public class AutoContainer extends SubsystemBase{
    //used to choose Auto
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
        
        NamedCommands.registerCommand("Auto Shoot Command", new AutoShootingCommand(shootingSubsystem, internalMoverSubsystem, shootingAngleSubsytems, -8, 1, 1).withTimeout(3));
        NamedCommands.registerCommand("Auto Intake Command", new AutoIntakeCommand(intakeSubsystem, internalMoverSubsystem, intakePneumaticsSubsystem, 1, 1).withTimeout(5));
        NamedCommands.registerCommand("Shooter Angle Command" , new AutoSetShootingAngleCommand(shootingAngleSubsytems, -8, 1).withTimeout(5));
        NamedCommands.registerCommand("Auto Amp Command" , new AutoAmpCommand(shootingSubsystem, internalMoverSubsystem, shootingAngleSubsytems, ampbarPNSubsystem, -8, 1, 1).withTimeout(2));
        NamedCommands.registerCommand("Amp Bar Pneumatics", new AmpBarPneumaticStateCommand(ampbarPNSubsystem).withTimeout(2));
        NamedCommands.registerCommand("Shooting Amp Command", new ShootingCommand(shootingSubsystem, internalMoverSubsystem, 0.5, 2500).withTimeout(3));
        NamedCommands.registerCommand("Shooting Command", new ShootingCommand(shootingSubsystem, internalMoverSubsystem, 1, 5000).withTimeout(3));
}
    
        public void SetupAutoOptions(SendableChooser<Command> sendableChooser) {
        sendableChooser.addOption("Test back and forth", this.swerveSubsystem.getAutonomousCommand("test back and forth"));
        sendableChooser.addOption("Test back and amp", this.swerveSubsystem.getAutonomousCommand("test 2step back and right"));
        sendableChooser.addOption("Test Auto", this.swerveSubsystem.getAutonomousCommand("Test Auto"));

        sendableChooser.addOption("Right Side Out Only Auto", this.swerveSubsystem.getAutonomousCommand("Right Side Out Only Auto"));
        sendableChooser.addOption("Right Shoot and Out Only Auto", this.swerveSubsystem.getAutonomousCommand("Right Shoot and Out Only Auto"));
       //ONLY mean it will complete just the stated command in title 
        sendableChooser.addOption("Right Side and Amp Auto", this.swerveSubsystem.getAutonomousCommand("Right Side and Amp Auto"));
        sendableChooser.addOption("Right Side Full", this.swerveSubsystem.getAutonomousCommand("Right Side Full"));
        //FULL mean to the full extent of its capibilities 
        sendableChooser.addOption("Middle Full Auto", this.swerveSubsystem.getAutonomousCommand("Middle Full Auto"));

        sendableChooser.addOption("Left Out Only Auto", this.swerveSubsystem.getAutonomousCommand("Left Out Only Auto"));
        sendableChooser.addOption("Left Side Shoot and Out Only Auto", this.swerveSubsystem.getAutonomousCommand("Left Side Shoot and Out Only Auto"));
        sendableChooser.addOption("Left Side Out Auto", this.swerveSubsystem.getAutonomousCommand("Left Side Out Auto"));
        sendableChooser.addOption("Left Side Full Auto", this.swerveSubsystem.getAutonomousCommand("Left Side Full Auto"));
        
        sendableChooser.addOption("Amp Auto", this.swerveSubsystem.getAutonomousCommand("Amp Auto"));
        //amp commands/pnumatics are not re writen for auto 

        //address shooting encoder issue (start at 0 or set it at perfect angle before match)
        //added rotational target at the end of each statment (this might fix our rotational issues)

        //general locations on path planner
/*  Amp Location x 1.85 y 7.7 r -90
 *  Right Side starting x 0.75 y 4.5 r -60 
 *  Middle Side starting x 1.3 y 5.55 r 0 
 *  Left Side starting x 0.75 y 4.5 r -60 
 * 
 * shoot non button side 
 * intake on button side 
 * 
 *middle rings 
 * ring 1 (top) x 10 y 7.45
 * ring 2 x 10 y 5.9
 * ring 3 x 10 y 4.1 
 * ring 4 x 10 y 2.45 
 * ring 5 x 10 y 0.75
 * 
 */

        /*sendableChooser.addOption("makeABox", this.swerveSubsystem.driveToPose(firstPose)
                .andThen(this.swerveSubsystem.driveToPose(secondPose))
                .andThen(this.swerveSubsystem.driveToPose(thirdPose))
                .andThen(this.swerveSubsystem.driveToPose(lastPose)));
        sendableChooser.addOption("Red Auto 1", this.redDefaultAuto);
    */
        }

}
