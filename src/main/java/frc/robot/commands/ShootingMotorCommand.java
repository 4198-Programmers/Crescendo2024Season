package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootingSubsytem;

public class ShootingMotorCommand extends Command {
    
    private ShootingSubsytem shootingSubsytem;
    private double speed;

    public ShootingMotorCommand(ShootingSubsytem shootingSubsytem, double speed){
        this.shootingSubsytem = shootingSubsytem;
        this.speed = speed;
        addRequirements(shootingSubsytem);
    }

    @Override
    public void execute(){
        shootingSubsytem.ShootingMotorSpeed(speed);
    }

}