package frc.robot.commands.swervedrive;

import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.swervedrive.ShootingAngleSubsytems;

public class ShootingAngleCommand extends Command {
    ShootingAngleSubsytems shootingAngleSubsytems;
    double speed;

    public ShootingAngleCommand(ShootingAngleSubsytems shootingAngleSubsytems, double speed){
        this.shootingAngleSubsytems = shootingAngleSubsytems; 
        this.speed = speed;
        addRequirements(shootingAngleSubsytems);
    }

    @Override
    public void execute(){
        if(!shootingAngleSubsytems.checkSwitch()) {
        shootingAngleSubsytems.move(this.speed);   
        }
     }

    @Override
    public void end(boolean interrupted){
        shootingAngleSubsytems.stop();
    }
    
}
