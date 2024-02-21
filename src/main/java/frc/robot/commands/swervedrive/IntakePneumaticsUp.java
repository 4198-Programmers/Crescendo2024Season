package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.IntakePneumaticsSubsystem;

public class IntakePneumaticsUp extends Command{

    private IntakePneumaticsSubsystem intakePneumatics;

    public IntakePneumaticsUp(IntakePneumaticsSubsystem intakePneumatics){
        this.intakePneumatics = intakePneumatics;
        addRequirements(intakePneumatics);
    }

    public void execute(){
        intakePneumatics.intakeUp();
    }
}