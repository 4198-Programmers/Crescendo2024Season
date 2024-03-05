package frc.robot.commands.GameAutos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.RightClimbSubsystem;

public class GameAutoRightClimbCommand extends Command{
    RightClimbSubsystem rightClimbSubsystem;
    double speed;
    double throttle;
    double time;
    double startTime;
    public boolean isFinished;
    
    public GameAutoRightClimbCommand(RightClimbSubsystem rightClimbSubsystem, double speed, double throttle, double time) {
        this.rightClimbSubsystem = rightClimbSubsystem;
        this.speed = speed;
        this.throttle = throttle;
        this.time = time;
        addRequirements(rightClimbSubsystem);
    }

    @Override
    public void initialize(){
        this.startTime = System.currentTimeMillis();
        this.isFinished = false;
    }
     
    @Override
    public void execute(){
        if(System.currentTimeMillis() <= startTime + time){
            rightClimbSubsystem.move(speed);
        } else {
            rightClimbSubsystem.move(0);
            this.isFinished = true;
        }  
    }

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }
}
