package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeMotorOutCommand extends Command{

    private IntakeSubsystem intakeSubsystem;

    public IntakeMotorOutCommand(IntakeSubsystem intakesubsystem){
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute(){
        intakeSubsystem.intakeMotorOut();
    }

    
}