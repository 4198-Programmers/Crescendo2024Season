package frc.robot.commands.swervedrive.auto;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.IntakeSubsystem;
import frc.robot.subsystems.swervedrive.InternalMoverSubsystem;

public class AutoIntakeCommand extends Command{
    public IntakeSubsystem intakeSubsystem;
    public InternalMoverSubsystem internalMoverSubsystem; 
    public double speed; 
    public DigitalInput digitalInput;

    public AutoIntakeCommand(IntakeSubsystem intakeSubsystem, InternalMoverSubsystem internalMoverSubsystem, double speed){
        this.intakeSubsystem = intakeSubsystem; 
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.speed = speed; 
    addRequirements(intakeSubsystem);
    }

    @Override
    public void execute(){
        if(!internalMoverSubsystem.middleLimitStatus()) {
        intakeSubsystem.intakeMotorSpeed(speed);
        internalMoverSubsystem.move(- speed);
        intakeSubsystem.PnOpen();
        }
    }

    @Override
    public void end(boolean interrupted){
        intakeSubsystem.stop();
       intakeSubsystem.PnClose();
    internalMoverSubsystem.stop();
    }
    
}
