package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootingSubsystem;

public class AimAngleupCommand extends CommandBase{

ShootingSubsystem shooterSubsystem;

public AimAngleupCommand(ShootingSubsystem shooterSubsystem){
    this.shooterSubsystem = shooterSubsystem; 

    addRequirements(shooterSubsystem);
}

}
