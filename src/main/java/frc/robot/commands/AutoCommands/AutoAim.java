package frc.robot.commands.AutoCommands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootingSubsystem;
import frc.robot.subsystems.AprilTags.PhotonVisionSubsystem;

public class AutoAim extends Command {

    private PhotonVisionSubsystem vision = new PhotonVisionSubsystem();
    private ShootingSubsystem shooter = new ShootingSubsystem();
    private double angle;
    private double range;

    public AutoAim(PhotonVisionSubsystem visionSubsystem, ShootingSubsystem shooterSubsystem) {
        this.vision = visionSubsystem;
        this.shooter = shooterSubsystem;
        addRequirements(vision, shooter);
    }

    @Override
    public void execute() {
        this.range = vision.getRange();
        this.angle = vision.wantedAngle(range);
        shooter.setShooterAngle(angle, 1, 0.1);
    }

    @Override
    public boolean isFinished() {
        if((shooter.getShooterAngle() - 0.01) < this.angle && this.angle < (shooter.getShooterAngle() + 0.01)) {
            return true;
        } else {
            return false;
        }
    }
}
