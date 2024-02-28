package frc.robot.commands.swervedrive.auto;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.IntakePneumaticsSubsystem;
import frc.robot.subsystems.swervedrive.IntakeSubsystem;
import frc.robot.subsystems.swervedrive.InternalMoverSubsystem;

public class AutoIntakeCommand extends Command{
    public IntakeSubsystem intakeSubsystem;
    public IntakePneumaticsSubsystem intakePneumaticsSubsystem;
    public InternalMoverSubsystem internalMoverSubsystem; 
    public double speedInternal; 
    public DigitalInput digitalInput;
    double speedIntake;

    public AutoIntakeCommand(IntakeSubsystem intakeSubsystem, InternalMoverSubsystem internalMoverSubsystem, IntakePneumaticsSubsystem intakePneumaticsSubsystem, double speedInternal, double speedIntake){
        this.intakeSubsystem = intakeSubsystem; 
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.intakePneumaticsSubsystem = intakePneumaticsSubsystem;
        this.speedInternal = speedInternal; 
        this.speedIntake = speedIntake;
    addRequirements(intakeSubsystem, internalMoverSubsystem, intakePneumaticsSubsystem);
    }

    @Override
    public void execute(){
        System.out.println("Sensor Status: " + internalMoverSubsystem.middleLimitStatus());
        
        if(internalMoverSubsystem.middleLimitStatus()) {
        intakeSubsystem.intakeMotorSpeed(-speedIntake);
        internalMoverSubsystem.move(speedInternal);
        intakePneumaticsSubsystem.intakeUp();
        } else {
            intakeSubsystem.stop();
            internalMoverSubsystem.stop();
            intakePneumaticsSubsystem.intakeDown();
        }

    }

    @Override
    public void end(boolean interrupted){
        intakeSubsystem.stop();
        internalMoverSubsystem.stop();
        intakePneumaticsSubsystem.intakeDown();
    }
    
}
