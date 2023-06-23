package org.firstinspires.ftc.teamcode.summer2023a;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class S1_Drivetrain {
    private LinearOpMode opMode;

    private DcMotor backLeftDrive = null;
    private DcMotor backRightDrive = null;
    private DcMotor frontLeftDrive = null;
    private DcMotor frontRightDrive = null;

    private double flMotorPower;
    private double frMotorPower;
    private double blMotorPower;
    private double brMotorPower;

    private boolean halfSpeed = false;
    private boolean isHandled = false;

    private double max = 1;

    public S1_Drivetrain(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void driveWithSticks() {
        double drive = -opMode.gamepad1.left_stick_y;
        double strafe = opMode.gamepad1.left_stick_x;
        double turn = opMode.gamepad1.right_stick_x;

        if (Math.abs(drive) + Math.abs(turn) + Math.abs(strafe) > 1) {
            max = Math.abs(drive) + Math.abs(turn) + Math.abs(strafe);
        }

        flMotorPower = (drive + turn + strafe) / max;
        frMotorPower = (drive - turn - strafe) / max;
        blMotorPower = (drive + turn - strafe) / max;
        brMotorPower = (drive - turn + strafe) / max;

        if (opMode.gamepad1.a && !isHandled) {
            halfSpeed = !halfSpeed;
            isHandled = true;
        } else if (!opMode.gamepad1.a) {
            isHandled = false;
        }

        if (halfSpeed) {
            flMotorPower = flMotorPower / 2;
            frMotorPower = frMotorPower / 2;
            blMotorPower = blMotorPower / 2;
            brMotorPower = brMotorPower / 2;
        }

        frontLeftDrive.setPower(flMotorPower);
        frontRightDrive.setPower(frMotorPower);
        backLeftDrive.setPower(blMotorPower);
        backRightDrive.setPower(brMotorPower);
        max = 1;
    }

    private void init() {
        frontLeftDrive = opMode.hardwareMap.get(DcMotor.class, "FLMotor");
        frontRightDrive = opMode.hardwareMap.get(DcMotor.class, "FRMotor");
        backLeftDrive = opMode.hardwareMap.get(DcMotor.class, "BLMotor");
        backRightDrive = opMode.hardwareMap.get(DcMotor.class, "BRMotor");

        frontLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        frontRightDrive.setDirection(DcMotor.Direction.FORWARD);
        backLeftDrive.setDirection(DcMotor.Direction.REVERSE);
        backRightDrive.setDirection(DcMotor.Direction.FORWARD);

    }

}