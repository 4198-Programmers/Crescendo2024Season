package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootingSubsystem;

public class ShootingMotorCommand extends Command {
    
    private ShootingSubsystem shootingSubsytem;
    private double speed;

    public ShootingMotorCommand(ShootingSubsystem shootingSubsytem, double speed){
        this.shootingSubsytem = shootingSubsytem;
        this.speed = speed;
        addRequirements(shootingSubsytem);
    }

    @Override
    public void execute(){
        shootingSubsytem.shootingMotorSpeed(speed);
    }

}