package frc.robot.commands.simpleCommands;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.InternalMoverSubsystem;

public class IntakeCommand extends Command{
    public IntakeSubsystem intakeSubsystem;
    public InternalMoverSubsystem internalMoverSubsystem; 
    public double speed; 
    public DigitalInput digitalInput;

    public IntakeCommand(IntakeSubsystem intakeSubsystem, InternalMoverSubsystem internalMoverSubsystem, double speed){
        this.intakeSubsystem = intakeSubsystem; 
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.speed = speed; 
    addRequirements(intakeSubsystem, internalMoverSubsystem);
    }

    @Override
    public void execute(){
        intakeSubsystem.intakeMotorSpeed(speed);
        internalMoverSubsystem.move(- speed);
    }

    @Override
    public void end(boolean interrupted){
        intakeSubsystem.stop();
   //     intakeSubsystem.PnClose();
        internalMoverSubsystem.stop();
    }
    
}
