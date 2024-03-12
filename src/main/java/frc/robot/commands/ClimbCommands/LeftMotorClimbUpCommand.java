package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.MotorClimbSubsystem;

public class LeftMotorClimbUpCommand extends Command {

    private MotorClimbSubsystem motorClimbSubsystem;
    double maxClimb = Constants.CLIMB_MOTOR_MAX;
    double leftPosition;

    public LeftMotorClimbUpCommand(MotorClimbSubsystem m_motorClimbSubsystem) {
        this.motorClimbSubsystem = m_motorClimbSubsystem;
        this.leftPosition = motorClimbSubsystem.getClimbMotorLeftPosition();
        addRequirements(motorClimbSubsystem);
    }

    @Override
    public void execute(){
        System.out.print("climb motor position Right(use to find limits)" + motorClimbSubsystem.getClimbMotorRightPosition());
        System.out.print("climb motor position Left(use to find limits)" + motorClimbSubsystem.getClimbMotorLeftPosition());
        if(maxClimb >= leftPosition){
        motorClimbSubsystem.setClimbMotorSpeedLeft(Constants.LEFT_CLIMB_SET_SPEED);
    } else{
        motorClimbSubsystem.stopLeftClimbMotor();

    }
    }
  
    @Override
    public void end(boolean interrupted) {
        motorClimbSubsystem.stopLeftClimbMotor();
    }


}
