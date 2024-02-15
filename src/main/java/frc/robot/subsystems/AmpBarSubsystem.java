package frc.robot.subsystems;

public class AmpBarSubsystem extends SubsystemBase{

    private Solenoid ampBarSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.AMP_BAR_PNEUMATIC_CHANNEL_FORWARD);
    private Compressor ampBarCompressor = new Compressor(Constants.AMP_BAR_PNUEMATIC_INTEGER, PneumaticsModuleType.CTREPCM));

    private boolean switchValue;

    public AmpBarSubsystem(){
        this.initialize();
    }

    public void changeAmpBarState(){
        switchvalue != switchvalue;
    }

    public void ampBarKillSwitch(){
        ampBarSolenoid.set(false);
    }
    
    public void initialize(){
        ampBarCompressor.enableDigital();
        ampBarSolenoid.set(switchvalue);
    }
}
