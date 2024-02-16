package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorClimbSubsystem;

public class LeftMotorClimbUpCommand extends Command {

    private MotorClimbSubsystem motorClimbSubsystem;

    public LeftMotorClimbUpCommand(MotorClimbSubsystem motorClimbSubsystem) {
        this.motorClimbSubsystem = motorClimbSubsystem;
        addRequirements(motorClimbSubsystem);
    }

    @Override
    public void execute(){
        motorClimbSubsystem.setClimbMotorSpeedRight(-0.1);
    }
  
    @Override
    public void end(boolean interrupted) {
        motorClimbSubsystem.stopLeftClimbMotor();
    }


}
