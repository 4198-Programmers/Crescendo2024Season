package frc.robot.commands.simpleCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.subsystems.ShootingSubsystem;

public class ShootingCommand extends Command {
    ShootingSubsystem shootingSubsystem;
    InternalMoverSubsystem internalMoverSubsystem;
    double speed;
    double maxShootingSpeedLimit;

    public ShootingCommand(ShootingSubsystem shootingSubsytems,InternalMoverSubsystem internalMoverSubsystem, double speed, double maxShootingSpeedLimit){
        this.shootingSubsystem = shootingSubsytems;
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.speed = speed;
        this.maxShootingSpeedLimit = maxShootingSpeedLimit;
        addRequirements(shootingSubsytems, internalMoverSubsystem);
    }

    @Override
    public void execute() {
        shootingSubsystem.shootOut(speed);
             if (maxShootingSpeedLimit <= shootingSubsystem.getSpeed()){
            internalMoverSubsystem.move(0.5);
        }    
    }
    
    @Override
    public void end(boolean interrupted) {
        shootingSubsystem.stop();
        internalMoverSubsystem.stop();
    }
}
