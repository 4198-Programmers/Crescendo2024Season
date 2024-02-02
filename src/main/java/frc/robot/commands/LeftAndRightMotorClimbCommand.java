package frc.robot.commands;

import frc.robot.subsystems.MotorClimbSubsystem;

public class LeftAndRightMotorClimbCommand {

    private MotorClimbSubsystem motorClimbSubsystem;
    private double speed;

    public LeftAndRightMotorClimbCommand(MotorClimbSubsystem motorClimbSubsystem, double speed) {
        this.motorClimbSubsystem = motorClimbSubsystem;
        this.speed = speed;
        addRequirements(motorClimbSubsystem);
    }


    @Override
    public void execute(){
        motorClimbSubsystem.setClimbMotorSpeedRight(speed);
        motorClimbSubsystem.setClimbMotorSpeedLeft(speed);
    }
    
}
