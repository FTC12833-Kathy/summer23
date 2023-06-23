package org.firstinspires.ftc.teamcode.summer2023a;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

public class S1_Collector {
    private LinearOpMode opMode;

    private Servo grabber = null;


    public S1_Collector(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void runCollector() {
//        code to run collector mechanism (or whatever the servo is used for)
    }

    private void init() {
        grabber = opMode.hardwareMap.get(Servo.class,"Collector");

    }

}
