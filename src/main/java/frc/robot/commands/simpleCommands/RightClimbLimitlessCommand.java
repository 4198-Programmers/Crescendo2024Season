package frc.robot.commands.simpleCommands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.RightClimbSubsystem;

public class RightClimbLimitlessCommand extends Command{
    RightClimbSubsystem rightClimbSubsystem;
    double speed;
    DoubleSupplier throttle;
    
    public RightClimbLimitlessCommand(RightClimbSubsystem rightClimbSubsystem, double speed, DoubleSupplier throttle) {
        this.rightClimbSubsystem = rightClimbSubsystem;
        this.speed = speed;
        this.throttle = throttle;
        addRequirements(rightClimbSubsystem);
    }
     
    @Override
    public void execute() {
        System.out.println("Right Climb Position:" + rightClimbSubsystem.rightClimbMotorPosition());

       if (rightClimbSubsystem.rightClimbMotorPosition() <= Constants.RIGHT_CLIMB_MOTOR_MAX && rightClimbSubsystem.rightClimbMotorPosition() >= Constants.RIGHT_CLIMB_MOTOR_MIN){
        this.rightClimbSubsystem.move(this.speed * this.throttle.getAsDouble());
       }
    }

    @Override
    public void end(boolean interrupted) {
        this.rightClimbSubsystem.stop();
    }
}
