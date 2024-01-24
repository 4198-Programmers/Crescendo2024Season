package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {

    private CANSparkMax intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_ID, MotorType.kBrushless);

    private RelativeEncoder intakeEncoder = intakeMotor.getEncoder();

    private DoubleSolenoid intakeSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.INTAKE_PNEUMATIC_CHANNEL_FORWARD, Constants.INTAKE_PNEUMATIC_CHANNEL_REVERSE);
    private Compressor intakeCompresser = new Compressor(Constants.INTAKE_PNUEMATIC_INTEGER, PneumaticsModuleType.CTREPCM);
    private boolean switchValue = false;
    
    public IntakeSubsystem(){
        this.initialize();
    }
    //Negative is one direction posititve is the other
    public void intakeMotorSpeed(double speed){
        intakeMotor.set(speed);
    }

    public void intakeMotorStop(){
        intakeMotor.set(0);

    }

    public double getIntakePosition(){
        double motorPosition = intakeEncoder.getPosition();
        return motorPosition;
    }

    public void switchIntakeDoubleSolenoidState(){
        switchValue = !switchValue;
    }

    public void open (){
        intakeSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void close (){
        intakeSolenoid.set(DoubleSolenoid.Value.kReverse);
    
    }

    public boolean isOpen (){
        return this.intakeSolenoid.isFwdSolenoidDisabled();
    }

    public void intakePneumaticKillSwitch(){
        //intakeSolenoid.set(false);
    }

    public void initialize(){
        intakeCompresser.enableDigital();
        //intakeSolenoid.set(switchValue);
    }

}