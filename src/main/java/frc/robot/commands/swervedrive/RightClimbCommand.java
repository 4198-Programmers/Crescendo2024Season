package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.RightClimbSubsystem;

public class RightClimbCommand extends Command{
    RightClimbSubsystem rightClimbSubsystem;
    double speed;
    double throttle;
    
    public RightClimbCommand(RightClimbSubsystem rightClimbSubsystem, double speed, double throttle) {
        this.rightClimbSubsystem = rightClimbSubsystem;
        this.speed = speed;
        this.throttle = throttle;
        addRequirements(this.rightClimbSubsystem);
    }
     
    @Override
    public void execute() {
        this.rightClimbSubsystem.move(this.speed * this.throttle);
    }

    @Override
    public void end(boolean interrupted) {
        this.rightClimbSubsystem.stop();
    }
}
