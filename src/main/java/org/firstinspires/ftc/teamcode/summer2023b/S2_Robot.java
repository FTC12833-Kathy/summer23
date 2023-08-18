package org.firstinspires.ftc.teamcode.summer2023b;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public class S2_Robot {
    private LinearOpMode opMode;

    public S2_Drivetrain drivetrain;
    public S2_Lift lift;
    public S2_Collector collector;

    private ElapsedTime runtime = new ElapsedTime();

    public S2_Robot(LinearOpMode opMode){
        this.opMode = opMode;
    }

    public void init() {
        //drivetrain = new S2_Drivetrain(opMode);
        lift = new S2_Lift(opMode);
        collector = new S2_Collector(opMode);
        drivetrain = new S2_Drivetrain(opMode);
    }

}