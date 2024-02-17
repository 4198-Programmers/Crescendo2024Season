package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.subsystems.ShootingSubsystem;

public class AutoShoot extends Command {

    InternalMoverSubsystem internalMoverSubsystem; 
    ShootingSubsystem shootingSubsystem; 

    public AutoShoot(InternalMoverSubsystem internalMoverSubsystem, ShootingSubsystem shootingSubsystem){
        this.internalMoverSubsystem = internalMoverSubsystem; 
        this.shootingSubsystem = shootingSubsystem; 
        addRequirements(internalMoverSubsystem, shootingSubsystem);
    }
  
    @Override
    public void execute(){
        if(internalMoverSubsystem.noteStatus()){
        shootingSubsystem.shootingMotorSpeed(Constants.SHOOTING_MOTOR_SPEED);
        internalMoverSubsystem.up();
    } 

    }

    @Override
    public void end(boolean interrupted) {
        shootingSubsystem.shootingMotorStop();
        internalMoverSubsystem.stop();
    }
}

