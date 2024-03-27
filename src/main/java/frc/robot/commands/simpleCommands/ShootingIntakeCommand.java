package frc.robot.commands.simpleCommands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.InternalMoverSubsystem;
import frc.robot.subsystems.ShootingSubsystem;

public class ShootingIntakeCommand extends Command {
    ShootingSubsystem shootingSubsystem;
    double speed;

    public ShootingIntakeCommand(ShootingSubsystem shootingSubsytems,
            double speed) {
        this.shootingSubsystem = shootingSubsytems;
        this.speed = speed;
        addRequirements(shootingSubsytems);
    }

    @Override
    public void execute() {
        // System.out.println("Throttle: " + joystick.getThrottle());
        shootingSubsystem.shootOut(-speed);

    }

    @Override
    public void end(boolean interrupted) {
        shootingSubsystem.stop();
    }
}
