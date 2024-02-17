package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.IntakeSubsystem;
import frc.robot.subsystems.swervedrive.InternalMoverSubsystem;

public class IntakeCommand extends Command{
    public IntakeSubsystem intakeSubsystem;
    public InternalMoverSubsystem internalMoverSubsystem; 
    public double speed; 
//TODO check if speed should be set negative here
    public IntakeCommand(IntakeSubsystem intakeSubsystem, InternalMoverSubsystem internalMoverSubsystem, double speed){
        this.intakeSubsystem = intakeSubsystem; 
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.speed = speed; 
    addRequirements(intakeSubsystem);
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
