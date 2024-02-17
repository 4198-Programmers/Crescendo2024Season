package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ShootingSubsystem;

public class ShootingMotorCommand extends Command {
    
    private ShootingSubsystem shootingSubsytem;

    public ShootingMotorCommand(ShootingSubsystem shootingSubsytem){
        this.shootingSubsytem = shootingSubsytem;
        addRequirements(shootingSubsytem);
    }

    @Override
    public void execute(){
        shootingSubsytem.shootingMotorSpeed(Constants.SHOOTING_MOTOR_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        shootingSubsytem.shootingMotorSpeed(0);
    }
}