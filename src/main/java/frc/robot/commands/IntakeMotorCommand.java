package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeMotorCommand extends Command{

    private IntakeSubsystem intakeSubsystem;
    private double speed;

    public IntakeMotorCommand(IntakeSubsystem intakesubsystem, double speed){
        this.intakeSubsystem = intakesubsystem;
        this.speed = -speed;
        addRequirements(intakeSubsystem);
    }

    @Override
    public void execute(){
        intakeSubsystem.intakeMotorSpeed(speed);
    }

    @Override
    public void end(boolean interrupted) {
        intakeSubsystem.intakeMotorSpeed(0);
    }

    
}
