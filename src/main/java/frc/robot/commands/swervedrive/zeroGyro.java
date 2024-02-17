package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DrivebaseConstants;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;

public class zeroGyro extends Command{
    SwerveSubsystem driveBase;

    public zeroGyro(SwerveSubsystem driveBase) {
        this.driveBase = driveBase;
        addRequirements(driveBase);
    }

    @Override
    public void execute() {
        driveBase.zeroGyro();
    }
}
