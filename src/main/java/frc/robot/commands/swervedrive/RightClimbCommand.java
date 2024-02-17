package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.RightClimbSubsystem;

public class RightClimbCommand extends Command{
    RightClimbSubsystem rightClimbSubsystem;
    double speed;

    public RightClimbCommand(RightClimbSubsystem rightClimbSubsystem, double speed) {
        this.rightClimbSubsystem = rightClimbSubsystem;
        this.speed = speed;
        addRequirements(rightClimbSubsystem);
    }
     
    @Override
    public void execute() {
        rightClimbSubsystem.move(speed);
    }

    @Override
    public void end(boolean interrupted) {
        rightClimbSubsystem.stop();
    }
}
