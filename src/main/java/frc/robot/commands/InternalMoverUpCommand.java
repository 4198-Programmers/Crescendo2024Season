package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.InternalMoverSubsystem;

public class InternalMoverUpCommand extends Command{
    private InternalMoverSubsystem m_internalMoverSubsystem;

    
    public InternalMoverUpCommand(InternalMoverSubsystem internalMoverSubsystem){
      m_internalMoverSubsystem = internalMoverSubsystem;
        addRequirements(internalMoverSubsystem);
    }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_internalMoverSubsystem.up();
  }

  @Override
  public void end(boolean interrupted) {
    m_internalMoverSubsystem.stop();
  }
}
