package org.firstinspires.ftc.teamcode.summer2023c;

import android.icu.lang.UCharacter;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;


public class S3_Robot {
    private LinearOpMode opMode;



    //public S3_Drivetrain drivetrain;
    public S3_BeastOfBurden BOB;
    public S3_Collector collector;

    public  S3_Robot(LinearOpMode opMode){
        this.opMode = opMode;
    }

    public void init(){
        //drivetrain = new S3_Drivetrain(opMode);
        BOB = new S3_BeastOfBurden(opMode);
        collector = new S3_Collector(opMode);

    }



}
