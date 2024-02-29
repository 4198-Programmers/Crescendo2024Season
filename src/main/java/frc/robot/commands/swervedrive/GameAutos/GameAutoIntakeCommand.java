package frc.robot.commands.swervedrive.GameAutos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.IntakePneumaticsSubsystem;
import frc.robot.subsystems.swervedrive.IntakeSubsystem;
import frc.robot.subsystems.swervedrive.InternalMoverSubsystem;

public class GameAutoIntakeCommand extends Command{
    IntakeSubsystem intakeSubsystem;
    InternalMoverSubsystem internalMoverSubsystem; 
    IntakePneumaticsSubsystem intakePneumaticsSubsystem;
    double speed; 
    double time;
    double startTime;
    boolean isFinished;

    public GameAutoIntakeCommand(IntakeSubsystem intakeSubsystem, IntakePneumaticsSubsystem intakePneumaticsSubsystem, 
    InternalMoverSubsystem internalMoverSubsystem, double speed, double time){
        this.intakeSubsystem = intakeSubsystem; 
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.intakePneumaticsSubsystem = intakePneumaticsSubsystem;
        this.speed = speed; 
        this.time = time;
        this.startTime = System.currentTimeMillis();
        this.isFinished = false;
    addRequirements(intakeSubsystem, internalMoverSubsystem);
    }

    @Override
    public void execute(){
        if(!internalMoverSubsystem.middleLimitStatus() && System.currentTimeMillis() <= time + startTime) {
        intakeSubsystem.intakeMotorSpeed(speed);
        internalMoverSubsystem.move(- speed);
        intakePneumaticsSubsystem.intakeDown();
        } else {
            intakeSubsystem.intakeMotorSpeed(0);
            internalMoverSubsystem.move(0);
            intakePneumaticsSubsystem.intakeUp();
            this.isFinished = true;
        }
    }

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }
}
