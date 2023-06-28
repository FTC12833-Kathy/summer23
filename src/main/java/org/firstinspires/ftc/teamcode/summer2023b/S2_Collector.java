package org.firstinspires.ftc.teamcode.summer2023b;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class S2_Collector {
    private final LinearOpMode opMode;

    private DcMotor frontCollector = null;
    private DcMotor backCollector = null;


    public S2_Collector(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void runCollector() {
//        code to run collector
        if(opMode.gamepad2.right_bumper){ //collects
            frontCollector.setPower(1);
            backCollector.setPower(1);
        }else if (opMode.gamepad2.left_bumper){ //spits out
            frontCollector.setPower(-1);
            backCollector.setPower(-1);
        }else{
            frontCollector.setPower(0);
            backCollector.setPower(0);
        }
    }

    private void init() {
        frontCollector = opMode.hardwareMap.get(DcMotor.class,"FrontCollector");
        backCollector = opMode.hardwareMap.get(DcMotor.class,"BackCollector");
    }
}
