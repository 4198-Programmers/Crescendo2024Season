package frc.robot.commands.complexCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;

public class AutoDriveCommand extends Command{
    SwerveSubsystem swerveDriveBase;
    double xSpeed;
    double ySpeed;
    double zRotation;
    public AutoDriveCommand(SwerveSubsystem swerve, double xSpeed, double ySpeed, double zRotation) {
        this.swerveDriveBase = swerve;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zRotation = zRotation;
        addRequirements(swerveDriveBase);
    }

    @Override
    public void execute() {
        swerveDriveBase.driveCommand(()-> xSpeed, ()-> ySpeed, ()-> zRotation);
    }

    @Override
    public void end(boolean interrupted) {
        swerveDriveBase.driveCommand(()-> 0, ()-> 0, ()-> 0);
    }
}
