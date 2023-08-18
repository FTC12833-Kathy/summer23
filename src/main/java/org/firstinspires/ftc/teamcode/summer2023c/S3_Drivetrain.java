package org.firstinspires.ftc.teamcode.summer2023c;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class S3_Drivetrain {
    private final LinearOpMode opMode;

    private DcMotor flMotor = null;
    private DcMotor frMotor = null;
    private DcMotor blMotor = null;
    private DcMotor brMotor = null;

    public S3_Drivetrain(LinearOpMode opMode) {
        this.opMode = opMode;

//        flMotor = opMode.hardwareMap.get(DcMotor.class, "FLMotor");
//        frMotor = opMode.hardwareMap.get(DcMotor.class, "FRMotor");
//        blMotor = opMode.hardwareMap.get(DcMotor.class, "BLMotor");
//        brMotor = opMode.hardwareMap.get(DcMotor.class, "BRMotor");
//
//        blMotor.setDirection(DcMotorSimple.Direction.REVERSE);
//        brMotor.setDirection(DcMotorSimple.Direction.REVERSE);

    }
}
