package frc.robot.commands.complexCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AmpbarPNSubsystem;
import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.subsystems.ShootingAngleSubsytems;
import frc.robot.subsystems.ShootingSubsystem;

public class AutoAmpCommand extends Command {
    ShootingSubsystem shootingSubsystem;
    InternalMoverSubsystem internalMoverSubsystem;
    ShootingAngleSubsytems shootingAngleSubsytems;
    AmpbarPNSubsystem ampbarPNSubsystem;
    double speedInteralMover;
    double speedShoot;
    double anglePosition;

    public AutoAmpCommand(ShootingSubsystem shootingSubsytems, InternalMoverSubsystem internalMoverSubsystem,
            ShootingAngleSubsytems shootingAngleSubsytems, AmpbarPNSubsystem ampbarPNSubsystem, double anglePosition,
            double speedShoot, double speedInteralMover) {
        this.shootingSubsystem = shootingSubsytems;
        this.internalMoverSubsystem = internalMoverSubsystem;
        this.shootingAngleSubsytems = shootingAngleSubsytems;
        this.ampbarPNSubsystem = ampbarPNSubsystem;
        this.speedShoot = -speedShoot;
        this.speedInteralMover = speedInteralMover;
        this.anglePosition = anglePosition;
        addRequirements(shootingSubsytems, internalMoverSubsystem, shootingAngleSubsytems);
    }

    @Override
    public void initialize() {
      //  ampbarPNSubsystem.initialize();
    }
    @Override
    public void execute() {
        // System.out.println("shootingAngle: " + shootingAngleSubsytems.encoderPosition());
        // System.out.println("shootingSpeed: " + shootingSubsystem.getSpeed());

        // speedInteralMover = shootingAngleSubsytems.encoderPosition() >= -20 ?
        // speedInteralMover/-20 : speedInteralMover;
        double gap = shootingAngleSubsytems.encoderPosition() - anglePosition;
        
        if (gap > 0.2) {
            // System.out.println("lowering shooter");
            shootingAngleSubsytems.move(-1);
        } else if (gap < -0.2) {
            // System.out.println("raising shooter");
            shootingAngleSubsytems.move(1);
        } else {
            shootingAngleSubsytems.stop();
            shootingSubsystem.shootOut(speedShoot);
            if (2000 <= shootingSubsystem.getSpeed() && -6 <= shootingSubsystem.getSpeed2()){
                // System.out.println("Shooting Speed: " + shootingSubsystem.getSpeed());
                // System.out.println("Shooting Speed2: " + shootingSubsystem.getSpeed2());

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
