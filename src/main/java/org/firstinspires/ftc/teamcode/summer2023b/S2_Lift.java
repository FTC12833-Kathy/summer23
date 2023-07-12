package org.firstinspires.ftc.teamcode.summer2023b;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;

public class S2_Lift {
    private final LinearOpMode opMode;
    private DcMotor liftMotor = null;
    private Servo pivot = null;
    private DigitalChannel bottomLimit;

    final double LIFT_SPEED = 1;
    // final double TICKS_PER_REVOLUTION = 383.6; for 13:7 GoBilda motor
    final double MAX_HEIGHT = 2000;
    final int LIFT_INCREMENT = 12;

    int targetTicks = 0;

    boolean pivotForward = true;

    public S2_Lift(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void runLift() {
//        while (opMode && )
//        code to run lift mechanism

        opMode.telemetry.addData("Limit", isTriggered(bottomLimit));
        opMode.telemetry.addData("Encoder Ticks", liftMotor.getCurrentPosition());
        opMode.telemetry.addData("pivot", pivot.getPosition());

        if (opMode.gamepad2.right_trigger > 0.1){ //up
            if (isTriggered(bottomLimit)) {
                liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if (targetTicks + LIFT_INCREMENT < MAX_HEIGHT) {
                targetTicks += LIFT_INCREMENT;
                liftMotor.setTargetPosition(targetTicks);
                liftMotor.setPower(LIFT_SPEED);
            }
        } else if (opMode.gamepad2.left_trigger > 0.1) { //down
            if (isTriggered(bottomLimit)) {
                liftMotor.setPower(0);
                targetTicks = 0;
                liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            } else {
                targetTicks -= LIFT_INCREMENT;
                liftMotor.setTargetPosition(targetTicks);
                liftMotor.setPower(LIFT_SPEED);
            }
        }

        if (!isTriggered(bottomLimit) && opMode.gamepad2.x && pivotForward) {
            pivotForward = false;
            pivot.setPosition(0);
            while (opMode.opModeIsActive() && opMode.gamepad2.x) {
            }
        } else if (!isTriggered(bottomLimit) && opMode.gamepad2.x && !pivotForward) {
            pivotForward = true;
            pivot.setPosition(1);
            while (opMode.opModeIsActive() && opMode.gamepad2.x) {
            }
        }
    }

    public boolean isTriggered(DigitalChannel limit) {
        return !limit.getState();
    }

    private void init() {
        liftMotor = opMode.hardwareMap.get(DcMotor.class, "Lift");
        liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setTargetPosition(0);

        pivot = opMode.hardwareMap.get(Servo.class, "Pivot");
        pivot.setPosition(1);

        bottomLimit = opMode.hardwareMap.get(DigitalChannel.class, "BottomLimit");
    }
}
