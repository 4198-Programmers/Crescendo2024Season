package frc.robot.commands.swervedrive;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.swervedrive.LeftClimbSubsystem;

public class LeftClimbCommand extends Command{
    LeftClimbSubsystem leftClimbSubsystem;
    double speed;
    DoubleSupplier throttle;

    public LeftClimbCommand(LeftClimbSubsystem leftClimbSubsystem, double speed, DoubleSupplier throttle) {
        this.leftClimbSubsystem = leftClimbSubsystem;
        this.speed = speed;
        this.throttle = throttle;
        addRequirements(leftClimbSubsystem);
    }
    
    @Override
    public void execute() {
        System.out.println("left Climb Position:" + leftClimbSubsystem.getPosition());
        if(leftClimbSubsystem.getPosition() <= Constants.MAX_LEFT_CLIMB_POSITION){
        leftClimbSubsystem.move( this.speed * this.throttle.getAsDouble());
            
        if(leftClimbSubsystem.getPosition() >= Constants.MIN_LEFT_CLIMB_POSITION){
                leftClimbSubsystem.move(  (this.speed * this.throttle.getAsDouble()));
        }
    } else {
        leftClimbSubsystem.move(this.speed * this.throttle.getAsDouble());
    }
   }

    @Override
    public void end(boolean interrupted) {
        leftClimbSubsystem.move(0);
       }
    }
