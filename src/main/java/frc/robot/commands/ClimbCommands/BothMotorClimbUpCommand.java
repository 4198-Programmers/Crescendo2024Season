package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.MotorClimbSubsystem;

public class BothMotorClimbUpCommand extends Command{

    private MotorClimbSubsystem motorClimbSubsystem;
    double climbMax = Constants.CLIMB_MOTOR_MAX;
    double leftPosition = motorClimbSubsystem.getClimbMotorLeftPosition();
    double rightPosition = motorClimbSubsystem.getClimbMotorRightPosition();

    public BothMotorClimbUpCommand(MotorClimbSubsystem motorClimbSubsystem) {
        this.motorClimbSubsystem = motorClimbSubsystem;
        addRequirements(motorClimbSubsystem);
    }


    @Override
    public void execute(){
        System.out.print("climb motor position Right(use to find limits)" + motorClimbSubsystem.getClimbMotorRightPosition());
        System.out.print("climb motor position Left(use to find limits)" + motorClimbSubsystem.getClimbMotorLeftPosition());
        if(climbMax >= leftPosition){
            if(climbMax >= rightPosition){
            motorClimbSubsystem.setClimbMotorSpeedRight( - Constants.BOTH_CLIMB_SET_SPEED);
            motorClimbSubsystem.setClimbMotorSpeedLeft( - Constants.BOTH_CLIMB_SET_SPEED);
            }
        } else {
            motorClimbSubsystem.stopBothClimbMotor();
        }
       
    }
 
    @Override
    public void end(boolean interrupted) {
        motorClimbSubsystem.stopBothClimbMotor();
    }

}
