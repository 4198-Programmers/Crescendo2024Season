package frc.robot.commands.simpleCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.InternalMoverSubsystem;

public class InternalMoverCommand extends Command {
    public InternalMoverSubsystem internalMoverSubsystem; 
    double speed;

    public InternalMoverCommand(InternalMoverSubsystem internalMoverSubsystem, double speed){
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.speed = speed;
        addRequirements(internalMoverSubsystem);
    }
    
    @Override
    public void execute(){
        internalMoverSubsystem.move(this.speed);
    }

    @Override 
    public void end(boolean interrupted){
        internalMoverSubsystem.stop();
    }
}
