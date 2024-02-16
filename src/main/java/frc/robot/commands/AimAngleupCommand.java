package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ShootingSubsystem;

public class AimAngleupCommand extends Command{

ShootingSubsystem shootingSubsystem;

public AimAngleupCommand(ShootingSubsystem shooterSubsystem){
    this.shootingSubsystem = shooterSubsystem; 

    addRequirements(shooterSubsystem);
}

@Override
public void execute(){
    shootingSubsystem.shootingMotorAngle(Constants.SHOOTING_ANGLE_INCREASE_SPEED);
}

@Override
public void end(boolean interrupted) {
    shootingSubsystem.shootingMotorAngleStop();
}
}
