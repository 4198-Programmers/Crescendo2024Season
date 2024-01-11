package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeMotorInCommand extends Command{

    private IntakeSubsystem intakeSubsystem;

    public IntakeMotorInCommand(IntakeSubsystem intakesubsystem){
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute(){
        intakeSubsystem.intakeMotorIn();
    }

    
}
