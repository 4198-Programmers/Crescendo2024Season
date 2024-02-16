package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.MotorClimbSubsystem;

public class LeftAndRightMotorClimbDownCommand extends Command{

    private MotorClimbSubsystem motorClimbSubsystem;

    public LeftAndRightMotorClimbDownCommand(MotorClimbSubsystem motorClimbSubsystem) {
        this.motorClimbSubsystem = motorClimbSubsystem;
        addRequirements(motorClimbSubsystem);
    }


    @Override
    public void execute(){
        motorClimbSubsystem.setClimbMotorSpeedRight(0.3);
        motorClimbSubsystem.setClimbMotorSpeedLeft(0.3);
    }

    @Override
    public void end(boolean interrupted) {
        motorClimbSubsystem.stopBothClimbMotor();
    }

}