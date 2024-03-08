package frc.robot.commands.simpleCommands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AmpbarPNSubsystem;

public class AmpBarPneumaticDownCommand extends Command{

    private AmpbarPNSubsystem ampBarSubsystem;
    
    public AmpBarPneumaticDownCommand(AmpbarPNSubsystem ampBarSubsystem){
        this.ampBarSubsystem = ampBarSubsystem;
        addRequirements(ampBarSubsystem);
    }
    
    @Override
    public void execute(){
        ampBarSubsystem.pullAmpBarUp();
    }
}