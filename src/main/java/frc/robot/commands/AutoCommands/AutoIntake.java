package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.InternalMoverSubsystem;

public class AutoIntake extends Command{
    IntakeSubsystem intakeSubsystem;
    InternalMoverSubsystem internalMoverSubsystem;

    public AutoIntake(IntakeSubsystem intakeSubsystem, InternalMoverSubsystem internalMoverSubsystem){
        this.intakeSubsystem = intakeSubsystem;
        this.internalMoverSubsystem = internalMoverSubsystem;
        addRequirements(intakeSubsystem, internalMoverSubsystem);
    }
    @Override
    public void execute() {
        intakeSubsystem.autoIntake(Constants.INTAKE_MOTOR_SPEED);
        internalMoverSubsystem.up();
    }
    
    @Override
    public boolean isFinished() {
        return internalMoverSubsystem.noteStatus();
    }
}
