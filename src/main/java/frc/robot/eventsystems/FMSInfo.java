package frc.robot.eventsystems;

import java.util.concurrent.atomic.AtomicBoolean;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.PubSubOption;
import edu.wpi.first.networktables.StringSubscriber;
import edu.wpi.first.networktables.StringTopic;
import edu.wpi.first.networktables.TimestampedString;
import frc.robot.Constants;

public class FMSInfo {
    final StringSubscriber stringSubscriber;
//GP104_A4
    final AtomicBoolean isAmplifiedAtomic = new AtomicBoolean(false);

    public FMSInfo() {
        super();
        NetworkTableInstance networkTableInstance = NetworkTableInstance.getDefault();
        StringTopic networkTable = networkTableInstance.getStringTopic("/FMSInfo/EventName");
        stringSubscriber = networkTable.subscribe(null, PubSubOption.keepDuplicates(true),
                PubSubOption.pollStorage(10));
    }

    public void periodic() {
        var events = stringSubscriber.readQueue();
        for (TimestampedString timestampedString : events) {
            if (timestampedString.value == Constants.Events.AMP_EVENT_NAME_ON) {
                setAmplified(true);
            }
            if (timestampedString.value == Constants.Events.AMP_EVENT_NAME_OFF) {
                setAmplified(false);
            }
        }
    }

    public void setAmplified(boolean on){
        this.isAmplifiedAtomic.set(on);
    }

    public boolean isAmplified() {
        return this.isAmplifiedAtomic.get();
    }

    public void close() {
        this.stringSubscriber.close();
    }
}
