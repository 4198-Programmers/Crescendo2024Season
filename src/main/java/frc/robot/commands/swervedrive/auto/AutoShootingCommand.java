package frc.robot.commands.swervedrive.auto;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.swervedrive.InternalMoverSubsystem;
import frc.robot.subsystems.swervedrive.ShootingAngleSubsytems;
import frc.robot.subsystems.swervedrive.ShootingSubsystem;

public class AutoShootingCommand extends Command {
    ShootingSubsystem shootingSubsystem;
    InternalMoverSubsystem internalMoverSubsystem; 
    ShootingAngleSubsytems shootingAngleSubsytems;
    double speedInteralMover;
    double speedShoot;
    double anglePosition;

    public AutoShootingCommand(ShootingSubsystem shootingSubsytems, InternalMoverSubsystem internalMoverSubsystem, ShootingAngleSubsytems shootingAngleSubsytems, double anglePosition, double speedShoot, double speedInteralMover){
        this.shootingSubsystem = shootingSubsytems;
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.shootingAngleSubsytems = shootingAngleSubsytems;
        this.speedShoot = -speedShoot;
        this.speedInteralMover = speedInteralMover;
        this.anglePosition = anglePosition;
        addRequirements(shootingSubsytems, internalMoverSubsystem, shootingAngleSubsytems);
    }

    @Override
    public void execute() {
        System.out.println("shootingAngle: " + shootingAngleSubsytems.encoderPosition());
        
        double gap = shootingAngleSubsytems.encoderPosition() - anglePosition;

       if (gap > 0.5) {
            System.out.println("lowering shooter");
            shootingAngleSubsytems.move(-speedInteralMover);
        } else if (gap < -0.5) {
            System.out.println("raising shooter");
            shootingAngleSubsytems.move(speedInteralMover);
        } else {
            shootingAngleSubsytems.stop();
            shootingSubsystem.shootOut(speedShoot);
             if (Constants.MAX_SHOOTING_SPEED <= shootingSubsystem.getSpeed()){
            internalMoverSubsystem.move(speedInteralMover);
        }
    }
}
    
    @Override
    public void end(boolean interrupted) {
        shootingSubsystem.stop();
        internalMoverSubsystem.stop();
        shootingAngleSubsytems.stop();
    }
}
