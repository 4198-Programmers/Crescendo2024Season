package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AmpBarPNSubsystem;

public class ChangeAmpBarPneumaticStateCommandUp extends Command{

    private AmpBarPNSubsystem ampBarSubsystem;
    
    public ChangeAmpBarPneumaticStateCommandUp(AmpBarPNSubsystem ampBarSubsystem){
        this.ampBarSubsystem = ampBarSubsystem;
        addRequirements(ampBarSubsystem);
    }
    
    @Override
    public void execute(){
        ampBarSubsystem.pullAmpBarDown();
    }
    //Did you know that the altitude on airplanes dries out your taste buds and makes food taste more bland?

    @Override
    public void end(boolean interrupted){
        ampBarSubsystem.ampBarKillSwitch();
    }
}