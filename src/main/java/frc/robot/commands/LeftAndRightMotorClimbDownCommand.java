package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorClimbSubsystem;

public class LeftAndRightMotorClimbDownCommand extends Command{

    private MotorClimbSubsystem motorClimbSubsystem;
    private double speed = 1;

    public LeftAndRightMotorClimbDownCommand(MotorClimbSubsystem motorClimbSubsystem, double speed) {
        this.motorClimbSubsystem = motorClimbSubsystem;
        this.speed = speed;
        addRequirements(motorClimbSubsystem);
    }


    @Override
    public void execute(){
        motorClimbSubsystem.setClimbMotorSpeedRight(speed);
        motorClimbSubsystem.setClimbMotorSpeedLeft(speed);
    }

    @Override
    public void end(boolean interrupted) {
        motorClimbSubsystem.stopBothClimbMotor();
    }
    
}