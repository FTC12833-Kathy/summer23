package org.firstinspires.ftc.teamcode.summer2023a;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;

public class S1_Lift {
    private LinearOpMode opMode;

    private DcMotor lift = null;

    private DigitalChannel limitSwitch;


    public S1_Lift(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void runLift() {
//        code to run lift mechanism
    }

    private void init() {
        lift = opMode.hardwareMap.get(DcMotor.class, "Lift");
    }

}
