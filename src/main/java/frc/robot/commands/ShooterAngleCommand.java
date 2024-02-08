package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootingSubsystem;


public class ShooterAngleCommand extends Command{
    ShootingSubsystem shooter;
    double angle;
    double speed;
    double tolerance;
    public ShooterAngleCommand(ShootingSubsystem shooterSubsystem, double angleParam, double speedParam, double toleranceParam) {
        this.shooter = shooterSubsystem;
        this.angle = angleParam;
        this.speed = speedParam;
        this.tolerance = toleranceParam;
        addRequirements(shooterSubsystem);
    }

    @Override
    public void execute() {
        shooter.setShooterAngle(angle, speed, tolerance);
    }
}
