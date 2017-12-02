package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Aniketh on 11/16/2017.
 */
@Autonomous
public class Auto_Red extends LinearOpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    ColorSensor colorSensor;
    Servo pushJewel;
    public final static double JEWEL_UP = 0.0; //smallest servo value(0)
    public final static double JEWEL_DOWN = 0.75;// largest servo value(135)
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        backRight = hardwareMap.dcMotor.get("motor3");
        backLeft = hardwareMap.dcMotor.get("motor1");
        frontRight = hardwareMap.dcMotor.get("motor2");
        frontLeft = hardwareMap.dcMotor.get("motor0");
        pushJewel = hardwareMap.servo.get("servo1");
        colorSensor = hardwareMap.colorSensor.get("colorSensor");

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        //stating the led that is on the color sensor, as turned on
        boolean bLedOn = true;

        colorSensor.enableLed(bLedOn);

        pushJewel.setPosition(JEWEL_UP);


        waitForStart();


        //moving jewel push inbetween jewels
        pushJewel.setPosition(JEWEL_DOWN);

        runtime.reset();

        while(runtime.seconds() < 2){}


        if (colorSensor.red() > colorSensor.blue()){
            //turns for 0.2 seconds
            while (opModeIsActive() && (runtime.seconds() < 0.2)) {
                frontLeft.setPower(0.25);
                backLeft.setPower(0.25);
                frontRight.setPower(-0.25);
                backRight.setPower(-0.25);
            }

            //moving jewel push back to home
            pushJewel.setPosition(JEWEL_UP);

            while (opModeIsActive() && (runtime.seconds() < 0.2)) {
                frontLeft.setPower(-0.25);
                backLeft.setPower(-0.25);
                frontRight.setPower(0.25);
                backRight.setPower(0.25);
            }
        }
        else {
            //turns for 0.2 seconds
            while (opModeIsActive() && (runtime.seconds() < 0.2)) {
                frontLeft.setPower(-0.25);
                backLeft.setPower(-0.25);
                frontRight.setPower(0.25);
                backRight.setPower(0.25);
            }

            //moving jewel push back to home
            pushJewel.setPosition(JEWEL_UP);

            while (opModeIsActive() && (runtime.seconds() < 0.2)) {
                frontLeft.setPower(0.25);
                backLeft.setPower(0.25);
                frontRight.setPower(-0.25);
                backRight.setPower(-0.25);
            }
        }



        //Moves robot into safe zone
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            frontLeft.setPower(0.5);
            backLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backRight.setPower(0.5);
        }

    }
}
