package frc.robot.commands.swervedrive.GameAutos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.InternalMoverSubsystem;

public class GameAutoInternalMoverCommand extends Command {
    public InternalMoverSubsystem internalMoverSubsystem; 
    double speed;
    double time;
    double startTime;
    public boolean isFinished;

    public GameAutoInternalMoverCommand(InternalMoverSubsystem internalMoverSubsystem, double speed, double time){
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.speed = speed;
        this.time = time;
        this.startTime = System.currentTimeMillis();
        this.isFinished = false;
        addRequirements(internalMoverSubsystem);
    }
    
    @Override
    public void execute(){
        if (System.currentTimeMillis() <= startTime + time) {
            internalMoverSubsystem.move(speed);
        }else {
            internalMoverSubsystem.move(0);
            this.isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }
}
