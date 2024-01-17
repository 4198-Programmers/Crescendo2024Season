package frc.robot.subsystems.AprilTags;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

public class PhotonVisionSubsystem {

    //set up the object for the camera.
    PhotonCamera camera = new PhotonCamera("camera");
    //collect the camera data.
    PhotonPipelineResult result;
    /*gives us a convenient location to store the target data
    and also gives us the ability to do things with the data.*/
    PhotonTrackedTarget target;
    double fiducialId;

    public void CheckTarget() {
        
    }

}
