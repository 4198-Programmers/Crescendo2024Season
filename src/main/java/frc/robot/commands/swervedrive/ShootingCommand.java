package frc.robot.commands.swervedrive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.swervedrive.ShootingAngleSubsytems;
import frc.robot.subsystems.swervedrive.ShootingSubsystem;

public class ShootingCommand extends Command {
    ShootingSubsystem shootingSubsystem;
    double speed;

    public ShootingCommand(ShootingSubsystem shootingSubsytems, double speed){
        this.shootingSubsystem = shootingSubsytems;
        this.speed = speed;
        addRequirements(shootingSubsytems);
    }

    @Override
    public void execute() {
        shootingSubsystem.shootOut(speed);
    }
    
    @Override
    public void end(boolean interrupted) {
        shootingSubsystem.stop();
    }
}
