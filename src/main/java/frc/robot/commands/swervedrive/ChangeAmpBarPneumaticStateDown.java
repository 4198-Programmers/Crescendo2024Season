package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AmpBarPNSubsystem;

public class ChangeAmpBarPneumaticStateCommandDown extends Command{

    private AmpBarPNSubsystem ampBarSubsystem;
    
    public ChangeAmpBarPneumaticStateCommandUp(AmpBarPNSubsystem ampBarSubsystem){
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