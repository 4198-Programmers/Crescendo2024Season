package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AmpBarSubsystem;

public class ChangeAmpBarPneumaticStateCommand extends Command{

    private AmpBarSubsystem ampBarSubsystem;
    
    public ChangeAmpBarPneumaticStateCommand(AmpBarSubsystem ampBarSubsystem){
        this.ampBarSubsystem = ampBarSubsystem;
        addRequirements(ampBarSubsystem);
    }
    
    public void execute(){
        ampBarSubsystem.changeAmpBarState();
    }
}