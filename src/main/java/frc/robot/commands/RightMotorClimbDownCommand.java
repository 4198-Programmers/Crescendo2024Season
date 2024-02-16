package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorClimbSubsystem;


public class RightMotorClimbDownCommand extends Command {
    
    private MotorClimbSubsystem motorClimbSubsystem;

    public RightMotorClimbDownCommand(MotorClimbSubsystem motorClimbSubsystem) {
        this.motorClimbSubsystem = motorClimbSubsystem;
        addRequirements(motorClimbSubsystem);
    }
    
    @Override
    public void execute(){
        motorClimbSubsystem.setClimbMotorSpeedRight(1);
    }

}