package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.MotorClimbSubsystem;

public class BothMotorClimbDownCommand extends Command{

    private MotorClimbSubsystem motorClimbSubsystem;
//TODO write relitive encoder print statments so that we can make climb limits 
    public BothMotorClimbDownCommand(MotorClimbSubsystem motorClimbSubsystem) {
        this.motorClimbSubsystem = motorClimbSubsystem;
        addRequirements(motorClimbSubsystem);
    }


    @Override
    public void execute(){
        motorClimbSubsystem.setClimbMotorSpeedRight(Constants.BOTH_CLIMB_SET_SPEED);
        motorClimbSubsystem.setClimbMotorSpeedLeft(Constants.BOTH_CLIMB_SET_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        motorClimbSubsystem.stopBothClimbMotor();
    }

}