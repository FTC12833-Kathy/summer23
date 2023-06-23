package org.firstinspires.ftc.teamcode.summer2023b;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class S2_Drivetrain {
    private LinearOpMode opMode;
    
    private DcMotor backLeftMotor = null;
    private DcMotor backRightMotor = null;
    private DcMotor frontLeftMotor = null;
    private DcMotor frontRightMotor = null;

    private double flMotorPower;
    private double frMotorPower;
    private double blMotorPower;
    private double brMotorPower;

    private boolean halfSpeed = false;
    private boolean isHandled = false;

    private double max = 1;

    public S2_Drivetrain(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void driveWithSticks() {
        double drive = -opMode.gamepad1.left_stick_y;
        double strafe = opMode.gamepad1.left_stick_x;
        double turn = opMode.gamepad1.right_stick_x;

        flMotorPower = (drive + turn + strafe);
        frMotorPower = (drive - turn - strafe);
        blMotorPower = (drive + turn - strafe);
        brMotorPower = (drive - turn + strafe);

        if (Math.abs(drive) + Math.abs(turn) + Math.abs(strafe) > 1) {
            max = Math.abs(drive) + Math.abs(turn) + Math.abs(strafe);
            flMotorPower = flMotorPower / max;
            frMotorPower = frMotorPower / max;
            blMotorPower = blMotorPower / max;
            brMotorPower = brMotorPower / max;
        }

//        if (opMode.gamepad1.a && !isHandled) {
//            halfSpeed = !halfSpeed;
//            isHandled = true;
//        } else if (!opMode.gamepad1.a) {
//            isHandled = false;
//        }
//
//        if (halfSpeed) {
//            flMotorPower = flMotorPower / 2;
//            frMotorPower = frMotorPower / 2;
//            blMotorPower = blMotorPower / 2;
//            brMotorPower = brMotorPower / 2;
//        }

        frontLeftMotor.setPower(flMotorPower);
        frontRightMotor.setPower(frMotorPower);
        backLeftMotor.setPower(blMotorPower);
        backRightMotor.setPower(brMotorPower);
        max = 1;

        opMode.telemetry.addData("drive", drive);
        opMode.telemetry.addData("strafe", strafe);
        opMode.telemetry.addData("turn", turn);

        opMode.telemetry.addData("fl power", flMotorPower);
        opMode.telemetry.addData("fr power", frMotorPower);
        opMode.telemetry.addData("bl power", blMotorPower);
        opMode.telemetry.addData("br power", brMotorPower);

        opMode.telemetry.update();
    }

    private void init() {
        frontLeftMotor = opMode.hardwareMap.get(DcMotor.class, "FLMotor");
        frontRightMotor = opMode.hardwareMap.get(DcMotor.class, "FRMotor");
        backLeftMotor = opMode.hardwareMap.get(DcMotor.class, "BLMotor");
        backRightMotor = opMode.hardwareMap.get(DcMotor.class, "BRMotor");

        backLeftMotor.setDirection(DcMotor.Direction.REVERSE);
        backRightMotor.setDirection(DcMotor.Direction.REVERSE);
    }
}