package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class ChangeIntakePneumaticStateCommand extends Command{

    private IntakeSubsystem intakeSubsystem;
    
    public ChangeIntakePneumaticStateCommand(IntakeSubsystem intakeSubsystem){
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }
    
    public void execute(){
        intakeSubsystem.switchIntakeSolenoidState();
    }
}
