package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class AmpBarSubsystem extends SubsystemBase{

    private Solenoid ampBarSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.AMP_BAR_PNEUMATIC_CHANNEL);
    private Compressor ampBarCompressor = new Compressor(Constants.AMP_BAR_PNUEMATIC_INTEGER, PneumaticsModuleType.CTREPCM);

    private boolean switchValue;

    public AmpBarSubsystem(){
        this.initialize();
    }

    public void changeAmpBarState(){
        switchValue =! switchValue;
    }

    public void ampBarKillSwitch(){
        ampBarSolenoid.set(false);
    }
    
    public void initialize(){
        ampBarCompressor.enableDigital();
        ampBarSolenoid.set(switchValue);
    }
}
