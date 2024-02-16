package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.MotorClimbSubsystem;

public class LeftMotorClimbUpCommand extends Command {

    private MotorClimbSubsystem motorClimbSubsystem;

    public LeftMotorClimbUpCommand(MotorClimbSubsystem motorClimbSubsystem) {
        this.motorClimbSubsystem = motorClimbSubsystem;
        addRequirements(motorClimbSubsystem);
    }

    @Override
    public void execute(){
        motorClimbSubsystem.setClimbMotorSpeedLeft(Constants.LEFT_CLIMB_SET_SPEED);
    }
  
    @Override
    public void end(boolean interrupted) {
        motorClimbSubsystem.stopLeftClimbMotor();
    }


}
