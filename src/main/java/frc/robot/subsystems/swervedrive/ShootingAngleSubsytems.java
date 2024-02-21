package frc.robot.subsystems.swervedrive;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShootingAngleSubsytems extends SubsystemBase{
    private CANSparkMax shootingAngleMotor = new CANSparkMax(Constants.SHOOTER__ANGLE_MOTOR_ID, MotorType.kBrushless);
    //TODO add limit swtich that prevents it from runnign into the electronic pannels in the front
    private DigitalInput bottomlimitSwitch = new DigitalInput(Constants.BOTTOM_LIMIT_SWITCH_ID);
    public void move(double speed){
        shootingAngleMotor.set(speed);
    }
    
    public void stop(){
        shootingAngleMotor.set(0);
    }

    public boolean checkSwitch() {
        return bottomlimitSwitch.get();
    }

}
