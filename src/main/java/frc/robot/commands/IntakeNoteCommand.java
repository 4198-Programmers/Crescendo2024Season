package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeNoteCommand extends Command{
    
    private IntakeSubsystem intakeSubsystem;
    
    public IntakeNoteCommand(IntakeSubsystem intakeSubsystem){
        this.intakeSubsystem = intakeSubsystem;
        addRequirements(intakeSubsystem);
    }
//1 open pnuematic
//2 run motors in (+ into bot)
//3 close pnuetmatic
//4 stop motor

    @Override
    public void execute(){
        this.intakeSubsystem.open();
        this.intakeSubsystem.intakeMotorSpeed(1);
    }

    @Override
    public void end(boolean interrupted){
        this.intakeSubsystem.close();
        this.intakeSubsystem.intakeMotorStop();
    }
}
