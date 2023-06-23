package org.firstinspires.ftc.teamcode.summer2023b;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;

public class S2_Lift {
    private LinearOpMode opMode;


    private DigitalChannel limitSwitch;


    public S2_Lift(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void runLift() {
//        code to run lift mechanism
    }

    private void init() {
//        lift = opMode.hardwareMap.get(DcMotor.class, "Lift");
    }

}
