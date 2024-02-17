package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.LeftClimbSubsystem;

public class LeftClimbCommand extends Command{
    LeftClimbSubsystem leftClimbSubsystem;
    double speed;

    public LeftClimbCommand(LeftClimbSubsystem leftClimbSubsystem, double speed) {
        this.leftClimbSubsystem = leftClimbSubsystem;
        this.speed = speed;
        addRequirements(leftClimbSubsystem);
    }
    
    @Override
    public void execute() {
        leftClimbSubsystem.move(speed);
    }

    @Override
    public void end(boolean interrupted) {
        leftClimbSubsystem.stop();
    }
}
