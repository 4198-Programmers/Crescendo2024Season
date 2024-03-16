package frc.robot.commands.simpleCommands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.LeftClimbSubsystem;

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
        //System.out.println("left Climb Position:" + leftClimbSubsystem.getPosition());
        if(leftClimbSubsystem.getPosition() >= Constants.MAX_LEFT_CLIMB_POSITION){
            leftClimbSubsystem.move(- Math.abs(this.speed));
        //run fine when inside of the limits but will move opposite when statement is not true. 
            } else if(leftClimbSubsystem.getPosition() <= Constants.MIN_LEFT_CLIMB_POSITION) {
                leftClimbSubsystem.move(Math.abs(this.speed));
        } else {
                leftClimbSubsystem.move((this.speed));
            }
   }

    @Override
    public void end(boolean interrupted) {
        leftClimbSubsystem.move(0);
       }
    }
