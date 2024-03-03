package frc.robot.commands.GameAutos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.subsystems.ShootingSubsystem;

public class GameAutoShootingCommand extends Command {
    ShootingSubsystem shootingSubsystem;
    InternalMoverSubsystem internalMoverSubsystem;
    double speed;
    double time;
    double startTime;
    private boolean isFinished;

    
    public GameAutoShootingCommand(ShootingSubsystem shootingSubsystem, InternalMoverSubsystem internalMoverSubsystem, double speed, double time){
        this.shootingSubsystem = shootingSubsystem;
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.speed = speed;
        this.time = time;
        this.startTime = System.currentTimeMillis();
        this.isFinished = false;
        addRequirements(shootingSubsystem, internalMoverSubsystem);
    }

    @Override
    public void execute() {
        if (System.currentTimeMillis() <= startTime + time && shootingSubsystem.getVelocity() <= Constants.MAX_SHOOTING_SPEED) {
            shootingSubsystem.shootOut(speed);
        } else if (System.currentTimeMillis() <= startTime + time && shootingSubsystem.getVelocity() >= Constants.MAX_SHOOTING_SPEED) {
            shootingSubsystem.shootOut(speed);
            internalMoverSubsystem.move(speed);
        } else {
            shootingSubsystem.shootOut(0);
            this.isFinished = true;
        }
    }
    @Override
    public boolean isFinished() {
        return this.isFinished;
    }
}
