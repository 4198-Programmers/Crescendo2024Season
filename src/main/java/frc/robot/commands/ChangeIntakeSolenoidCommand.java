package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class ChangeIntakeSolenoidCommand extends Command{
    
    private IntakeSubsystem intakeSubsystem;
    
    public ChangeIntakeSolenoidCommand(IntakeSubsystem intakeSubsystem){
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute(){
        intakeSubsystem.switchIntakeSolenoidState();
    }
}
