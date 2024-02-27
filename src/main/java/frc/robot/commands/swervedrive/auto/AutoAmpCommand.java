package frc.robot.commands.swervedrive.auto;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.swervedrive.AmpbarPNSubsystem;
import frc.robot.subsystems.swervedrive.InternalMoverSubsystem;
import frc.robot.subsystems.swervedrive.ShootingAngleSubsytems;
import frc.robot.subsystems.swervedrive.ShootingSubsystem;

public class AutoAmpCommand extends Command {
    ShootingSubsystem shootingSubsystem;
    InternalMoverSubsystem internalMoverSubsystem; 
    ShootingAngleSubsytems shootingAngleSubsytems;
    AmpbarPNSubsystem ampbarPNSubsystem;
    double speedInteralMover;
    double speedShoot;
    double anglePosition;

    public AutoAmpCommand(ShootingSubsystem shootingSubsytems, InternalMoverSubsystem internalMoverSubsystem, ShootingAngleSubsytems shootingAngleSubsytems, AmpbarPNSubsystem ampbarPNSubsystem, double anglePosition, double speedShoot, double speedInteralMover){
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
        
        if (shootingAngleSubsytems.encoderPosition() <= anglePosition){
            shootingAngleSubsytems.move(speedInteralMover);
        } else if (shootingAngleSubsytems.encoderPosition() >= anglePosition){
                shootingAngleSubsytems.move( - speedInteralMover);
        } else {
            shootingAngleSubsytems.stop();
        }

        shootingSubsystem.shootOut(speedShoot);
        ampbarPNSubsystem.pullAmpBarUp();

        System.out.println("shooter speed" + shootingSubsystem.getSpeed());

        if (Constants.MAX_SHOOTING_SPEED <= shootingSubsystem.getSpeed() && shootingAngleSubsytems.encoderPosition() == anglePosition){
            internalMoverSubsystem.move(speedInteralMover);
        }
    }
    
    @Override
    public void end(boolean interrupted) {
        shootingSubsystem.stop();
        internalMoverSubsystem.stop();
        shootingAngleSubsytems.stop();
        ampbarPNSubsystem.pullAmpBarDown();
    }
}
