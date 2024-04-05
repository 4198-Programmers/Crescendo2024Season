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
        shootingSubsystem.shootOut(speedShoot);
        if (gap > 0.5) {
            // System.out.println("lowering shooter");
            shootingAngleSubsytems.move(-1);
        } else if (gap < -0.5) {
            // System.out.println("raising shooter");
            shootingAngleSubsytems.move(1);

        } else {
            shootingAngleSubsytems.stop();
            // System.out.println("Shooting Speed: " + shootingSubsystem.getSpeed());
            // System.out.println("Shooting Speed2: " + shootingSubsystem.getSpeed2());
        }

    }

    @Override
    public void end(boolean interrupted) {
        shootingAngleSubsytems.stop();
        shootingSubsystem.stop();
    }
}
