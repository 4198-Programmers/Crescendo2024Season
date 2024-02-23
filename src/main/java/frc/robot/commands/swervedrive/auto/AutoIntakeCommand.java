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
    public double speed; 
    public DigitalInput digitalInput;

    public AutoIntakeCommand(IntakeSubsystem intakeSubsystem, InternalMoverSubsystem internalMoverSubsystem, IntakePneumaticsSubsystem intakePneumaticsSubsystem, double speed){
        this.intakeSubsystem = intakeSubsystem; 
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.intakePneumaticsSubsystem = intakePneumaticsSubsystem;
        this.speed = speed; 
    addRequirements(intakeSubsystem, internalMoverSubsystem, intakePneumaticsSubsystem);
    }

    @Override
    public void execute(){
        System.out.println("Sensor Status: " + internalMoverSubsystem.middleLimitStatus());
        
    //    if(!internalMoverSubsystem.middleLimitStatus()) {
        intakeSubsystem.intakeMotorSpeed(-speed);
        internalMoverSubsystem.move(- speed);
        intakePneumaticsSubsystem.intakeDown();
    //    }
    }

    @Override
    public void end(boolean interrupted){
        intakeSubsystem.stop();
        internalMoverSubsystem.stop();
    }
    
}
