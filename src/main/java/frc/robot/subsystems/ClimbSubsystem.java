package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ClimbSubsystem extends SubsystemBase {
    
    private DoubleSolenoid climbPneumatic = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.CLIMB_PNEUMATIC_CHANNEL_A, Constants.CLIMB_PNEUMATIC_CHANNEL_B);
    private Compressor climbCompressor = new Compressor(Constants.CLIMB_PNUEMATIC_INTEGER, PneumaticsModuleType.CTREPCM);
    private Value pneumaticPositionValue = Value.kOff;

    public ClimbSubsystem(){
        this.initialize();
    }


    public void changeClimbPneumaticState(){
        switch (pneumaticPositionValue) {
            case kOff:
            pneumaticPositionValue = Value.kForward;
            break;
            case kForward:
            pneumaticPositionValue = Value.kReverse;
            break;
            case kReverse:
            pneumaticPositionValue = Value.kForward;
            break;
            default:
            pneumaticPositionValue = Value.kOff;

        }
    }


    public void initialize(){
        this.climbCompressor.enableDigital();
        this.climbPneumatic.set(this.pneumaticPositionValue);
    }

}
