package frc.robot.commands.swervedrive;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.AmpbarPNSubsystem;

public class AmpbarPNCommand extends Command{
    AmpbarPNSubsystem ampbarPNSubsystem;

    public AmpbarPNCommand(AmpbarPNSubsystem ampbarPNSubsystem){
        this.ampbarPNSubsystem = ampbarPNSubsystem;
        addRequirements(ampbarPNSubsystem);
    }

    @Override
    public void execute(){
        ampbarPNSubsystem.toggle();
    }   
}
