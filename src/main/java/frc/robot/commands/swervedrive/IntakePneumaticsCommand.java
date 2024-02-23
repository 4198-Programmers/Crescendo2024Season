package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.IntakePneumaticsSubsystem;

public class IntakePneumaticsCommand extends Command{

    private IntakePneumaticsSubsystem intakePneumatics;

    public IntakePneumaticsCommand(IntakePneumaticsSubsystem intakePneumatics){
        this.intakePneumatics = intakePneumatics;
        addRequirements(intakePneumatics);
    }

    @Override
    public void execute(){
        intakePneumatics.intakeDown();
    }

    @Override
    public void end(boolean interrupted){
        intakePneumatics.intakeUp();
    }
}