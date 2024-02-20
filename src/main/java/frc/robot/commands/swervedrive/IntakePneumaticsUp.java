package frc.robot.commands.swervedrive;

public class IntakePneumaticsUp extends Command{

    private IntakePneumaticsSubsystem intakePneumatics;

    public IntakePneumaticsUp(IntakePneumaticsSubsystem intakePneumatics){
        this.intakePneumatics = intakePneumatics;
        addRequirements(intakePneumatics)
    }

    public void execute(){
        intakePneumatics.intakeUp();
    }
}