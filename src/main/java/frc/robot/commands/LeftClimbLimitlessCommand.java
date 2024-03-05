package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.swervedrive.LeftClimbSubsystem;

public class LeftClimbLimitlessCommand extends Command{
    LeftClimbSubsystem leftClimbSubsystem;
    double speed;
    DoubleSupplier throttle;
    
    public LeftClimbLimitlessCommand(LeftClimbSubsystem leftClimbSubsystem, double speed, DoubleSupplier throttle) {
        this.leftClimbSubsystem = leftClimbSubsystem;
        this.speed = speed;
        this.throttle = throttle;
        addRequirements(leftClimbSubsystem);
    }
     
    @Override
    public void execute() {
        System.out.println("left Climb Position:" + leftClimbSubsystem.getPosition());
        this.leftClimbSubsystem.move(this.speed * this.throttle.getAsDouble());
    }

    @Override
    public void end(boolean interrupted) {
        this.leftClimbSubsystem.stop();
    }
}
