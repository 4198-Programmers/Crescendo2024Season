package frc.robot.commands.complexCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootingAngleSubsytems;

public class AutoSetShootingAngleCommand extends Command {
    ShootingAngleSubsytems shootingAngleSubsytems;
    double speedAngleShooter;
    double anglePosition;
    boolean isFinished;

    public AutoSetShootingAngleCommand(ShootingAngleSubsytems shootingAngleSubsytems, double anglePosition, double speedAngleShooter){
        this.shootingAngleSubsytems = shootingAngleSubsytems;
        this.speedAngleShooter = speedAngleShooter;
        this.anglePosition = anglePosition;
        addRequirements(shootingAngleSubsytems);
    }

    @Override
    public void initialize() {
        isFinished = false;
    }

    @Override
    public void execute() {
        System.out.println("shootingAngle: " + shootingAngleSubsytems.encoderPosition());
        
        double gap = shootingAngleSubsytems.encoderPosition() - anglePosition;

       if (gap > 0.5) {
            System.out.println("lowering shooter");
            shootingAngleSubsytems.move(-speedAngleShooter);
        } else if (gap < -0.5) {
            System.out.println("raising shooter");
            shootingAngleSubsytems.move(speedAngleShooter);
        } else {
            shootingAngleSubsytems.stop();
            isFinished = true;
        }
    }

    @Override
    public boolean isFinished(){
        return isFinished;
    }

    @Override
    public void end(boolean interrupted) {
        shootingAngleSubsytems.stop();
    }
}
