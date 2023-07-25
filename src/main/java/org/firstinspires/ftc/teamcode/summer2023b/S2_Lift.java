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

    final double MANUAL_LIFT_SPEED = 1;
    final double AUTO_LIFT_SPEED = .6;

    //  383.6 ticks per rev for 13:7 GoBilda motor
    final double MAX_HEIGHT = 2000;
    final int LIFT_INCREMENT = 12;
    final int PIVOT_CLEARANCE = 650;
    int targetTicks = 0;

    boolean pivotForward = true;
    boolean pivotIsHandled = false;
    boolean limitIsHandled = false;

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
            if (isTriggered(bottomLimit)) {// sets motor mode
                liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if (targetTicks + LIFT_INCREMENT < MAX_HEIGHT) {// updates the slide ticks
                targetTicks += LIFT_INCREMENT;
                liftMotor.setTargetPosition(targetTicks);
                liftMotor.setPower(MANUAL_LIFT_SPEED);
            }
        } else if (opMode.gamepad2.left_trigger > 0.1) { //down
            if (liftMotor.getMode() != DcMotor.RunMode.RUN_TO_POSITION ){
                liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            }
            if (isTriggered(bottomLimit)) {//stops slide for going too far down
                liftMotor.setPower(0);
                targetTicks = 0;
                liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            } else {
                targetTicks -= LIFT_INCREMENT; // updates slide ticks
                liftMotor.setTargetPosition(targetTicks);
                liftMotor.setPower(MANUAL_LIFT_SPEED);
            }
        }

        if (opMode.gamepad2.x && !pivotIsHandled){ // pivot
            if (pivotForward && liftMotor.getCurrentPosition() >= PIVOT_CLEARANCE){//pivot an flip too low
                pivot.setPosition(0);
                pivotForward = false;
            } else if (liftMotor.getCurrentPosition() >= PIVOT_CLEARANCE){
                pivot.setPosition(1);
                pivotForward = true;
            }
            pivotIsHandled = true;
        } else if (!opMode.gamepad2.x && pivotIsHandled){
            pivotIsHandled = false;
        }

        if(opMode.gamepad2.y){// auto medium height
            liftMotor.setTargetPosition(1994);
            targetTicks = 1994;
            liftMotor.setPower(AUTO_LIFT_SPEED);
        }

        if(opMode.gamepad2.b){//auto collect height
            liftMotor.setTargetPosition(0);
            targetTicks = 0;
            liftMotor.setPower(AUTO_LIFT_SPEED);
        }






    }

    public boolean isTriggered(DigitalChannel limit) {// fixes the limit get state
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
