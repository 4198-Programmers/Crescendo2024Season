package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.MotorClimbSubsystem;

public class BothMotorClimbUpCommand extends Command{

    private MotorClimbSubsystem motorClimbSubsystem;

    public BothMotorClimbUpCommand(MotorClimbSubsystem motorClimbSubsystem) {
        this.motorClimbSubsystem = motorClimbSubsystem;
        addRequirements(motorClimbSubsystem);
    }


    @Override
    public void execute(){
         motorClimbSubsystem.setClimbMotorSpeedRight( - Constants.BOTH_CLIMB_SET_SPEED);
        motorClimbSubsystem.setClimbMotorSpeedLeft( - Constants.BOTH_CLIMB_SET_SPEED);
    }
 
    @Override
    public void end(boolean interrupted) {
        motorClimbSubsystem.stopBothClimbMotor();
    }

}
