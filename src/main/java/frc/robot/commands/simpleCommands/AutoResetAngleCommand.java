package frc.robot.commands.simpleCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootingAngleSubsytems;

public class AutoResetAngleCommand extends Command {
 ShootingAngleSubsytems shootingAngleSubsytems;
    double speed;
    boolean isFinished;

    public AutoResetAngleCommand(ShootingAngleSubsytems shootingAngleSubsytems, double speed){
        this.shootingAngleSubsytems = shootingAngleSubsytems; 
        this.speed = speed;
        addRequirements(shootingAngleSubsytems);
    }

    @Override
    public void execute(){
        //System.out.println("limitSwitch: " + shootingAngleSubsytems.checkSwitch());
        //System.out.println("shooting Angle encoder: " + shootingAngleSubsytems.encoderPosition());

        if(shootingAngleSubsytems.checkSwitch()) {
        shootingAngleSubsytems.move(speed);
        } else {
            shootingAngleSubsytems.resetAngle();
            shootingAngleSubsytems.move( - speed);

            isFinished = true; 

        }
     }

    @Override
    public boolean isFinished(){
        return isFinished;
    }
    
}
