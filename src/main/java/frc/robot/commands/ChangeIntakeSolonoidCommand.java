package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class ChangeIntakeSolonoidCommand extends Command{
    
    private IntakeSubsystem intakeSubsystem;
    
    public ChangeIntakeSolonoidCommand(IntakeSubsystem intakeSubsystem){
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute(){
        intakeSubsystem.switchIntakeSolenoidState;
    }
}
