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

    final double LIFT_SPEED = 0.3;

    public S2_Lift(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void runLift() {
//        while (opMode && )
//        code to run lift mechanism

        opMode.telemetry.addData("Limit", isTriggered(bottomLimit));

        if (opMode.gamepad2.right_trigger > 0.1){ //up
            liftMotor.setPower(LIFT_SPEED);
        } else if (opMode.gamepad2.left_trigger > 0.1 && !isTriggered(bottomLimit)) { //down
            liftMotor.setPower(-LIFT_SPEED);
        } else {
            liftMotor.setPower(0);
        }
    }

    public boolean isTriggered(DigitalChannel limit) {
        return !limit.getState();
    }

    private void init() {
        liftMotor = opMode.hardwareMap.get(DcMotor.class, "Lift");
        pivot = opMode.hardwareMap.get(Servo.class, "Pivot");
        bottomLimit = opMode.hardwareMap.get(DigitalChannel.class, "BottomLimit");
    }
}
