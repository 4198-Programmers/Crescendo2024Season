package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.MotorClimbSubsystem;


public class RightMotorClimbDownCommand extends Command {
    
    private MotorClimbSubsystem motorClimbSubsystem;
    double climbMin = Constants.CLIMB_MOTOR_MIN;
    double rightPosition;

    public RightMotorClimbDownCommand(MotorClimbSubsystem m_motorClimbSubsystem) {
        this.motorClimbSubsystem = m_motorClimbSubsystem;
        this.rightPosition = motorClimbSubsystem.getClimbMotorRightPosition();
        addRequirements(motorClimbSubsystem);
    }
    
    @Override
    public void execute(){
        System.out.print("climb motor position Right(use to find limits)" + motorClimbSubsystem.getClimbMotorRightPosition());
        System.out.print("climb motor position Left(use to find limits)" + motorClimbSubsystem.getClimbMotorLeftPosition());
        if(climbMin <= rightPosition){
            motorClimbSubsystem.setClimbMotorSpeedRight(Constants.RIGHT_CLIMB_SET_SPEED);
        } else {
            motorClimbSubsystem.stopRightClimbMotor();

        }

    }

    @Override
    public void end(boolean interrupted) {
        motorClimbSubsystem.stopRightClimbMotor();
    }

}