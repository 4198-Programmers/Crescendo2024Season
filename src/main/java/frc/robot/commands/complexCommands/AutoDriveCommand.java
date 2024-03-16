package frc.robot.commands.complexCommands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;

public class AutoDriveCommand extends Command{
    SwerveSubsystem swerveDriveBase;
    DoubleSupplier xSpeed;
    DoubleSupplier ySpeed;
    DoubleSupplier zRotation;
    public AutoDriveCommand(SwerveSubsystem swerve, DoubleSupplier xSpeed, DoubleSupplier ySpeed, DoubleSupplier zRotation) {
        this.swerveDriveBase = swerve;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.zRotation = zRotation;
        addRequirements(swerve);
    }

    @Override
    public void execute() {
        // System.out.println("Executing Drive Command");
        swerveDriveBase.driveCommand(xSpeed, ySpeed, zRotation);
    }

    @Override
    public void end(boolean interrupted) {
        // System.out.println("Ending Drive Command");
        swerveDriveBase.driveCommand(()-> 0, ()-> 0, ()-> 0);
    }
}
