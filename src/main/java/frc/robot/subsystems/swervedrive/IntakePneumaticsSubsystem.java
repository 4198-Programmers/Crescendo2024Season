package frc.robot.subsystems.swervedrive;

public class IntakePneumaticsSubsystem extends SubsystemBase {
    
    private Solenoid intakeSolenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.INTAKE_PNEUMATIC_CHANNEL);

    public IntakePneumaticsSubsystem(){}

    public void intakeDown(){
        intakeSolenoid.set(true);
    }

    public void intakeUp(){
        intakeSolenoid.set(false);
    }
}