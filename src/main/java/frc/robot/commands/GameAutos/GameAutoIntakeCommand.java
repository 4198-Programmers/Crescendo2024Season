package frc.robot.commands.GameAutos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakePneumaticsSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.InternalMoverSubsystem;

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
    addRequirements(intakeSubsystem, internalMoverSubsystem, intakePneumaticsSubsystem);
    }

    @Override 
    public void initialize(){
     this.startTime = System.currentTimeMillis();
    this.isFinished = false;
    System.out.println("GameAutoIntakeCommand Initialize");
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
        System.out.println("GameAutoIntakeCommand Execute");

    }

    @Override
    public boolean isFinished() {
        System.out.println("GameAutoIntakeCommand isFinished");
        return this.isFinished;
        
    }
}
