package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.IntakePneumaticsSubsystem;

public class IntakePneumaticsDown extends Command{

    private IntakePneumaticsSubsystem intakePneumatics;

    public IntakePneumaticsDown(IntakePneumaticsSubsystem intakePneumatics){
        this.intakePneumatics = intakePneumatics;
        addRequirements(intakePneumatics);
    }

    public void execute(){
        intakePneumatics.intakeDown();
    }
}