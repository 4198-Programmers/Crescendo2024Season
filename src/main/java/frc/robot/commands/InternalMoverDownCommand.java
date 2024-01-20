package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.InternalMoverSubsystem;

public class InternalMoverDownCommand extends Command {
    private InternalMoverSubsystem m_InternalMoverSubsystem;

    public InternalMoverDownCommand(InternalMoverSubsystem internalMoverSubsystem){
        internalMoverSubsystem = m_InternalMoverSubsystem;
        addRequirements(internalMoverSubsystem);
    }

    @Override
    public void execute(){
        m_InternalMoverSubsystem.down();
    }

    @Override
  public boolean isFinished() {
    return false;
  }
}
