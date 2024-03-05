package frc.robot.commands.GameAutos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.LeftClimbSubsystem;

public class GameAutoLeftClimbCommand extends Command{
    LeftClimbSubsystem leftClimbSubsystem;
    double speed;
    double throttle;
    double time;
    double startTime;
    public boolean isFinished;

    public GameAutoLeftClimbCommand(LeftClimbSubsystem leftClimbSubsystem, double speed, double throttle, double time) {
        this.leftClimbSubsystem = leftClimbSubsystem;
        this.speed = speed;
        this.throttle = throttle;
        this.time = time;
        addRequirements(leftClimbSubsystem);
    }
    
    @Override
    public void initialize(){
        this.startTime = System.currentTimeMillis();
        this.isFinished = false;
    }

    @Override
    public void execute() {
        if (System.currentTimeMillis() <= startTime + time) {
            leftClimbSubsystem.move(speed);
        } else {
            leftClimbSubsystem.move(0);
            this.isFinished = true;
        }  
    }
    

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }
}
