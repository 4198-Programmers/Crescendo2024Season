package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AmpBarSubsystem;

public class ChangeAmpBarPneumaticStateCommand extends Command{

    private AmpBarSubsystem ampBarSubsystem;
    
    public ChangeAmpBarPneumaticStateCommand(AmpBarSubsystem ampBarSubsystem){
        this.ampBarSubsystem = ampBarSubsystem;
        addRequirements(ampBarSubsystem);
    }
    
    @Override
    public void execute(){
        ampBarSubsystem.pullAmpBarUp();
    }

    @Override
    public void end(boolean interrupted){
        ampBarSubsystem.ampBarKillSwitch();
    }
}