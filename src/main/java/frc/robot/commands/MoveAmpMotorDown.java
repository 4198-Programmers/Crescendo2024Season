package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.AmpBarSubsystem;

public class MoveAmpMotorDown extends Command{

    private AmpBarSubsystem ampBarSubsystem;

    public MoveAmpMotorDown(AmpBarSubsystem ampBarSubsystem){
        this.ampBarSubsystem = ampBarSubsystem;
    }

    @Override
    public void execute() {
        ampBarSubsystem.pushAmpBarDown();
    }
    
}