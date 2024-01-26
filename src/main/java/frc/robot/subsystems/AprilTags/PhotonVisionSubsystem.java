package frc.robot.subsystems.AprilTags;

import org.photonvision.PhotonCamera;
import org.photonvision.PhotonUtils;
import org.photonvision.targeting.PhotonPipelineResult;
import org.photonvision.targeting.PhotonTrackedTarget;

import edu.wpi.first.math.estimator.SwerveDrivePoseEstimator;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Transform3d;
import edu.wpi.first.math.util.Units;
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
        this.result = camera.getLatestResult();
        if(result.hasTargets()) {
            double imageCaptureTime = result.getTimestampSeconds();
            Transform3d camToTarget = result.getBestTarget().getBestCameraToTarget();
            Pose3d camPose = Constants.TARGET_POSITION.transformBy(camToTarget);
            poseEstimator.addVisionMeasurement(camPose.toPose2d(), imageCaptureTime);
        }
    }

    public double getRange() {
        this.result = camera.getLatestResult();
        double range = PhotonUtils.calculateDistanceToTargetMeters(Constants.CAMERA_HEIGHT, Constants.TAG_HEIGHT, 
            Units.degreesToRadians(Constants.CAMERA_PITCH), result.getBestTarget().getPitch());
        return range;
    }

    public double wantedAngle(double targetRange) {
        //the "+" may need to be changed to a -
        double angle = Math.acos(targetRange/(Constants.SHOOTER_MAX_VELOCITY * 
        (Math.sqrt(2 * (Math.pow(Constants.SHOOTER_MAX_VELOCITY, 2)) 
        - 2 * (Constants.ACCELERATION_DUE_TO_GRAVITY) * (Constants.INITIAL_SHOOTER_HEIGHT) 
        + 2 * Math.sqrt((Math.pow((Constants.ACCELERATION_DUE_TO_GRAVITY * Constants.INITIAL_SHOOTER_HEIGHT)
        - (Math.pow(Constants.SHOOTER_MAX_VELOCITY, 2)), 2) 
        - Math.pow(Constants.ACCELERATION_DUE_TO_GRAVITY, 2) * (Math.pow(targetRange, 2) 
        + Math.pow(Constants.INITIAL_SHOOTER_HEIGHT, 2))))) / Constants.ACCELERATION_DUE_TO_GRAVITY)));
        return angle;
    }
    
}
