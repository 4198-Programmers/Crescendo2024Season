package frc.robot.commands.complexCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.subsystems.ShootingAngleSubsytems;
import frc.robot.subsystems.ShootingSubsystem;

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
            shootingSubsystem.shootOut(speedShoot);
            shootingAngleSubsytems.move(speedInteralMover);

        } else {
            shootingAngleSubsytems.stop();
            shootingSubsystem.shootOut(speedShoot);
                System.out.println("Shooting Speed: " + shootingSubsystem.getSpeed());
                System.out.println("Shooting Speed2: " + shootingSubsystem.getSpeed2());

             if (Constants.MAX_SHOOTING_SPEED <= shootingSubsystem.getSpeed() && Constants.MAX_SHOOTING_SPEED_2 <= shootingSubsystem.getSpeed2()){
                System.out.println("Shooting Speed: " + shootingSubsystem.getSpeed());
                System.out.println("Shooting Speed2: " + shootingSubsystem.getSpeed2());

            shootingSubsystem.shootOut(speedShoot);
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
