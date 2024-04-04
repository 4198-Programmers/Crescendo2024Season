package frc.robot.commands.complexCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ShootingAngleSubsytems;
import frc.robot.subsystems.ShootingSubsystem;

public class AutoBirdFeedCommand extends Command {
    private ShootingAngleSubsytems shootingAngleSubsytems;
    private ShootingSubsystem shootingSubsystem;
    double anglePosition;
    double speedShoot;

    public AutoBirdFeedCommand(ShootingAngleSubsytems shootingAngleSubsytems, ShootingSubsystem ShootingSubsystem,
            double anglePosition, double speedShoot) {
        this.shootingAngleSubsytems = shootingAngleSubsytems;
        this.shootingSubsystem = ShootingSubsystem;
        this.anglePosition = anglePosition;
        this.speedShoot = speedShoot;
        addRequirements(shootingAngleSubsytems, shootingSubsystem);
    }

    @Override
    public void execute() {
        double gap = shootingAngleSubsytems.encoderPosition() - anglePosition;
        if (gap > 0.5) {
            // System.out.println("lowering shooter");
            shootingAngleSubsytems.move(anglePosition);
        } else if (gap < -0.5) {
            // System.out.println("raising shooter");
            shootingSubsystem.shootOut(speedShoot);
            shootingAngleSubsytems.move(-anglePosition);

        } else {
            shootingAngleSubsytems.stop();
            shootingSubsystem.shootOut(speedShoot);
            // System.out.println("Shooting Speed: " + shootingSubsystem.getSpeed());
            // System.out.println("Shooting Speed2: " + shootingSubsystem.getSpeed2());

            if (Constants.MAX_SHOOTING_SPEED <= shootingSubsystem.getSpeed()
                    && Constants.MAX_SHOOTING_SPEED_2 <= shootingSubsystem.getSpeed2()) {
                // System.out.println("Shooting Speed: " + shootingSubsystem.getSpeed());
                // System.out.println("Shooting Speed2: " + shootingSubsystem.getSpeed2());

                shootingSubsystem.shootOut(speedShoot);
                shootingAngleSubsytems.move(gap);
            }
        }

    }

    @Override
    public void end(boolean interrupted) {
        shootingAngleSubsytems.stop();
        shootingSubsystem.stop();
    }
}
