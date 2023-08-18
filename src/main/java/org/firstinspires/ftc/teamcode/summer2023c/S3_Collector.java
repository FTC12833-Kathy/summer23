package org.firstinspires.ftc.teamcode.summer2023c;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class S3_Collector {
    private final LinearOpMode opMode;

    private DcMotor intake = null;
    private DcMotor innertake = null;

    private Servo phoneMount = null;

    public S3_Collector(LinearOpMode opMode) {
        this.opMode = opMode;
        init();
    }

    public void runCollector(){
        if (opMode.gamepad2.right_bumper){
            intake.setPower(1);
            innertake.setPower(1);
        } else if (opMode.gamepad2.left_bumper){
            intake.setPower(-1);
            innertake.setPower(-1);
        } else{
            intake.setPower(0);
            innertake.setPower(0);
        }

    }

    public void init(){
        intake = opMode.hardwareMap.get(DcMotor.class, "Intake");
        innertake = opMode.hardwareMap.get(DcMotor.class, "Innertake");
        intake.setDirection(DcMotor.Direction.REVERSE);
        innertake.setDirection(DcMotor.Direction.REVERSE);
        phoneMount = opMode.hardwareMap.get(Servo.class, "PhoneMount");
        phoneMount.setPosition(0);
    }


}
