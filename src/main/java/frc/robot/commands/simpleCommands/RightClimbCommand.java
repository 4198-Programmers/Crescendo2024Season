package frc.robot.commands.simpleCommands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.RightClimbSubsystem;

public class RightClimbCommand extends Command{
    RightClimbSubsystem rightClimbSubsystem;
    double speed;
    DoubleSupplier throttle;
    
    public RightClimbCommand(RightClimbSubsystem rightClimbSubsystem, double speed, DoubleSupplier throttle) {
        this.rightClimbSubsystem = rightClimbSubsystem;
        this.speed = speed;
        this.throttle = throttle;
        addRequirements(rightClimbSubsystem);
    }
     
    @Override
    public void execute() {
        System.out.println("Right Climb Position:" + rightClimbSubsystem.rightClimbMotorPosition());

        if(rightClimbSubsystem.rightClimbMotorPosition() <= Constants.MAX_RIGHT_CLIMB_POSITION && rightClimbSubsystem.rightClimbMotorPosition() >= Constants.MIN_RIGHT_CLIMB_POSITION){
            rightClimbSubsystem.move(this.speed * Math.abs(this.throttle.getAsDouble()));
        //run fine when inside of the limits but will move opposite when statement is not true. 
            } else {
                rightClimbSubsystem.move(- (this.speed * Math.abs(this.throttle.getAsDouble())));
            }
    }

    @Override
    public void end(boolean interrupted) {
        this.rightClimbSubsystem.stop();
    }
}
