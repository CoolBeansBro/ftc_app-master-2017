package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Aniketh on 11/16/2017.
 */
@Autonomous
public class AutoSafeZone extends LinearOpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;

    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        backRight = hardwareMap.dcMotor.get("motor3");
        backLeft = hardwareMap.dcMotor.get("motor1");
        frontRight = hardwareMap.dcMotor.get("motor2");
        frontLeft = hardwareMap.dcMotor.get("motor0");

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();

        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            frontLeft.setPower(0.5);
            backLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backRight.setPower(0.5);
        }

    }
}
