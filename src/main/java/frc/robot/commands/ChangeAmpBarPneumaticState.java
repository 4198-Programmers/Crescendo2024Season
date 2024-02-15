public class ChangeAmpBarPneumaticStateCommand extends Command{

    private AmpBarSubsystem ampBarSubsystem;
    
    public ChangeAmpBarPneumaticStateCommand(){
        this.ampBarSubsystem = ampBarSubsystem;
        .addRequirements(ampBarSubsystem);
    }
    
    public void execute(){
        ampBarSubsystem.changeAmpBarState();
    }
}