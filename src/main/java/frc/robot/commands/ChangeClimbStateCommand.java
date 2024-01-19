package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;

public class ChangeClimbStateCommand extends Command{

    private ClimbSubsystem climbSubsystem;

    public ChangeClimbStateCommand(ClimbSubsystem climbSubsystem){
        this.climbSubsystem = climbSubsystem;
        addRequirements(climbSubsystem);
    }
    
    @Override
    public void execute(){
        this.climbSubsystem.changeClimbPneumaticState();
    }
}
