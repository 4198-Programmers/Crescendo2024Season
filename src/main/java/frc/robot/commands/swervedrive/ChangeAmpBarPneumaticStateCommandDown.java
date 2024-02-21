package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.AmpbarPNSubsystem;

public class ChangeAmpBarPneumaticStateCommandDown extends Command{
    private AmpbarPNSubsystem ampBarSubsystem;
    
    public ChangeAmpBarPneumaticStateCommandDown(AmpbarPNSubsystem ampBarSubsystem){
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
