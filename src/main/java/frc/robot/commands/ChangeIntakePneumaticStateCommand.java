public class ChangeIntakePneumaticStateCommand extends Command{

    private IntakeSubsystem intakeSubsystem;
    
    public ChangeIntakePneumaticStateCommand(){
        this.intakeSubsystem = intakeSubsystem;
        .addRequirements(intakeSubsystem);
    }
    
    public void execute(){
        intakeSubsystem.switchIntakeSolenoidState();
    }
}
