package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShootingSubsytem;

public class ShootingMotorOutCommand extends Command {
    
    private ShootingSubsytem shootingSubsytem;

    public ShootingMotorOutCommand(ShootingSubsytem shootingSubsytem){
        this.shootingSubsytem = shootingSubsytem;
        addRequirements(shootingSubsytem);
    }

    @Override
    public void execute(){
        shootingSubsytem.shootingMotorOut();
    }

}