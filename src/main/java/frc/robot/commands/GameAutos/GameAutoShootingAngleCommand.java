package frc.robot.commands.GameAutos;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootingAngleSubsytems;

public class GameAutoShootingAngleCommand extends Command {
    ShootingAngleSubsytems shootingAngleSubsytems;
    double speed;
    double angle;
    double tolerance;
    double startTime;
    private boolean isFinished;

    public GameAutoShootingAngleCommand(ShootingAngleSubsytems shootingAngleSubsytems, double speed, double angle, double tolerance){
        this.shootingAngleSubsytems = shootingAngleSubsytems; 
        this.speed = speed;
        this.angle = angle;
        this.tolerance = tolerance;
        addRequirements(shootingAngleSubsytems);
    }

    @Override
    public void initialize(){
        this.startTime = System.currentTimeMillis();
        this.isFinished = false;
    }

    @Override
    public void execute(){
        if(!shootingAngleSubsytems.checkSwitch() && shootingAngleSubsytems.getAngle() <= angle - tolerance) {
        shootingAngleSubsytems.move(speed);   
        } else if(!shootingAngleSubsytems.checkSwitch() && shootingAngleSubsytems.getAngle() >= angle - tolerance) {
        shootingAngleSubsytems.move(-speed);
        } else {
            shootingAngleSubsytems.move(0);
            this.isFinished = true;
        }
     }

    @Override
    public boolean isFinished() {
        return this.isFinished;
    }
}
