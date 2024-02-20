package frc.robot.commands.swervedrive.auto;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.swervedrive.InternalMoverSubsystem;
import frc.robot.subsystems.swervedrive.ShootingSubsystem;

public class AutoShootingCommand extends Command {
    ShootingSubsystem shootingSubsystem;
    InternalMoverSubsystem internalMoverSubsystem; 
    double speedInteralMover;
    double speedShoot;

    public AutoShootingCommand(ShootingSubsystem shootingSubsytems, InternalMoverSubsystem internalMoverSubsystem, double speedShoot, double speedInteralMover){
        this.shootingSubsystem = shootingSubsytems;
        this.speedShoot = speedShoot;
        addRequirements(shootingSubsytems, internalMoverSubsystem);
    }

    @Override
    public void execute() {

        shootingSubsystem.shootOut(speedShoot);
        
        if (Constants.MAX_SHOOTING_SPEED >= shootingSubsystem.getSpeed()){
            internalMoverSubsystem.move(speedInteralMover);
        }
    }
    
    @Override
    public void end(boolean interrupted) {
        shootingSubsystem.stop();
    }
}
