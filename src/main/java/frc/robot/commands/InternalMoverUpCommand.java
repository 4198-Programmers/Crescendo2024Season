package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.InternalMoverSubsystem;

public class InternalMoverUpCommand extends CommandBase{
    private InternalMoverSubsystem m_internalMoverSubsystem;

    
    public InternalMoverUpCommand(InternalMoverSubsystem internalMoverSubsystem){
        internalMoverSubsystem = m_internalMoverSubsystem;

        addRequirements(internalMoverSubsystem);
    }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_internalMoverSubsystem.up();
  }

  @Override
  public boolean isFinished() {
    return false;
  }

}
