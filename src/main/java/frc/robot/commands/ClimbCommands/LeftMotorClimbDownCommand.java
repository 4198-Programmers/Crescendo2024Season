package frc.robot.commands.ClimbCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.MotorClimbSubsystem;

public class LeftMotorClimbDownCommand extends Command {

    private MotorClimbSubsystem motorClimbSubsystem;
    double climbMin = Constants.CLIMB_MOTOR_MIN;
    double leftPosition = motorClimbSubsystem.getClimbMotorLeftPosition();

    public LeftMotorClimbDownCommand(MotorClimbSubsystem motorClimbSubsystem) {
        this.motorClimbSubsystem = motorClimbSubsystem;
        addRequirements(motorClimbSubsystem);
    }


    @Override
    public void execute(){
        System.out.print("climb motor position Right(use to find limits)" + motorClimbSubsystem.getClimbMotorRightPosition());
        System.out.print("climb motor position Left(use to find limits)" + motorClimbSubsystem.getClimbMotorLeftPosition());
        if(climbMin <= leftPosition){
        motorClimbSubsystem.setClimbMotorSpeedLeft( - Constants.LEFT_CLIMB_SET_SPEED);
        }else {
            motorClimbSubsystem.stopLeftClimbMotor();
        }
    }
 
    @Override
    public void end(boolean interrupted) {
        motorClimbSubsystem.stopLeftClimbMotor();
    }

}
