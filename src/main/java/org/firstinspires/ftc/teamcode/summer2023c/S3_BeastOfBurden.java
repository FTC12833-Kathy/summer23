package org.firstinspires.ftc.teamcode.summer2023c;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class S3_BeastOfBurden {
    private final LinearOpMode opMode;


    private DcMotorEx launcher = null;

    private CRServo pinwheel = null;
    private CRServo backWheel = null;

    private DistanceSensor innertakeDistance = null;
    private DistanceSensor pinwheelDistance = null;
    private DistanceSensor backDistance = null;

    private boolean isHandled = false;

    public S3_BeastOfBurden(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void runTransport() {
        if (pinwheelDistance.getDistance(DistanceUnit.INCH) > 1.2) {
            pinwheel.setPower(1);
        } else {
            pinwheel.setPower(0);
        }
        if (backDistance.getDistance(DistanceUnit.INCH) > 1.5) {
            backWheel.setPower(1);
        } else {
            backWheel.setPower(0);
        }
        opMode.telemetry.addData("Pinwheel distance", pinwheelDistance.getDistance(DistanceUnit.INCH));
        opMode.telemetry.addData("Back wheel distance", backDistance.getDistance((DistanceUnit.INCH)));

        if (opMode.gamepad2.right_trigger > .1) {

            launcher.setVelocity(1340);
            if(launcher.getVelocity() >= 1340){
                backWheel.setPower(1);
            }

        } else {
            launcher.setPower(0);
        }

        opMode.telemetry.addData("launcher velocity", launcher.getVelocity());
    }
    private void init(){
        launcher = opMode.hardwareMap.get(DcMotorEx.class, "Launcher");

        pinwheel = opMode.hardwareMap.get(CRServo.class, "Pinwheel");
        backWheel = opMode.hardwareMap.get(CRServo.class, "BackWheel");

        innertakeDistance = opMode.hardwareMap.get(DistanceSensor.class, "InnertakeDistance");
        pinwheelDistance = opMode.hardwareMap.get(DistanceSensor.class, "PinwheelDistance");
        backDistance = opMode.hardwareMap.get(DistanceSensor.class, "BackDistance");

        launcher.setDirection(DcMotorEx.Direction.REVERSE);
        backWheel.setDirection(DcMotorSimple.Direction.REVERSE);
    }
}
