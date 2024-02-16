package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ShootingSubsystem;

public class AimAngleDownCommand extends Command{
    ShootingSubsystem shootingSubsystem;

    public AimAngleDownCommand(ShootingSubsystem shootingSubsystem){
    this.shootingSubsystem = shootingSubsystem; 
    
    addRequirements(shootingSubsystem);
    }
    
@Override
public void execute(){
    shootingSubsystem.shootingMotorAngle(Constants.SHOOTING_ANGLE_DECREASE_SPEED);
}

@Override
public void end(boolean interrupted) {
    shootingSubsystem.shootingMotorAngleStop();
}
}
