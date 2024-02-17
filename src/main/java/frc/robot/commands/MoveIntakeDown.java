package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class MoveIntakeDown extends Command{

    private IntakeSubsystem intakeSubsystem;

    public MoveIntakeDown(IntakeSubsystem intakeSubsystem){
        this.intakeSubsystem = intakeSubsystem;
    }

    @Override
    public void execute(){
        intakeSubsystem.close();
    }

    
}
