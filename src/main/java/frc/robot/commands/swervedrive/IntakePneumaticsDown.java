package frc.robot.commands.swervedrive;

public class IntakePneumaticsDown extends Command{

    private IntakePneumaticsSubsystem intakePneumatics;

    public IntakePneumaticsDown(IntakePneumaticsSubsystem intakePneumatics){
        this.intakePneumatics = intakePneumatics;
        addRequirements(intakePneumatics)
    }

    public void execute(){
        intakePneumatics.intakeDown();
    }
}