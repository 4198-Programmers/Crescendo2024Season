package frc.robot.commands.GameAutos;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.SwerveSubsystem;

public class GameAutoDriveCommand extends Command {
    SwerveSubsystem swerveSubsystem;
    DoubleSupplier translationX;
    DoubleSupplier translationY;
    DoubleSupplier angularRotationX;
    double time;
    double startTime;
    public boolean isFinished;

    public GameAutoDriveCommand(SwerveSubsystem swerveSubsystem, DoubleSupplier translationX, 
    DoubleSupplier translationY, DoubleSupplier angularRotationX, double runTime){
        this.swerveSubsystem = swerveSubsystem;
        this.time = runTime;
        this.translationX = translationX;
        this.translationY = translationY;
        this.angularRotationX = angularRotationX;
        this.startTime = System.currentTimeMillis();
        this.isFinished = false;
        addRequirements(swerveSubsystem);
    }

       @Override
       public void execute() {
        if (System.currentTimeMillis() <= startTime + time) {
            swerveSubsystem.driveCommand(translationX, translationY, angularRotationX);
        }else {
            swerveSubsystem.driveCommand(() -> 0, () -> 0, () -> 0);
            this.isFinished = true;
        }
        
       }

       @Override
       public boolean isFinished() {
           return isFinished;
       }
}
