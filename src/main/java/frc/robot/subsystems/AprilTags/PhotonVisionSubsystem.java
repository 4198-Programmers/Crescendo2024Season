package frc.robot.subsystems.AprilTags;

import org.photonvision.PhotonCamera;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Transform3d;
import frc.robot.Constants;

public class PhotonVisionSubsystem {

    //set up the object for the camera.
    PhotonCamera camera = new PhotonCamera("camera");
    //collect the camera data.
    PhotonPipelineResult result;
    /*gives us a convenient location to store the target data
    and also gives us the ability to do things with the data.*/
    PhotonTrackedTarget target;
    double fiducialId;

    public void CheckTarget(SwerveDrivePoseEstimator poseEstimator) {
        if(result.hasTargets()) {
            double imageCaptureTIme = result.getTimestampSeconds();
            Transform3d camToTarget = result.getBestTarget().getBestCameraToTarget();
            Pose3d camPose = Constants.TARGET_POSITION.transformBy(camToTarget);
            poseEstimator.addVisionMeasurement(camPose.toPose2d(), imageCaptureTIme);
        }
    }

}
