package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by Aniketh on 11/16/2017.
 */
@Autonomous
public class AutoBlue extends LinearOpMode {
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor glyph;
    Servo jewelArm;
    Servo leftGrabber;
    Servo rightGrabber;
    ColorSensor colorSensor;
    DigitalChannel stop;


    public final static double LEFT_HOME = 1; // starting servo position
    public final static double LEFT_IN = 0.75; //smallest servo value
    public final static double LEFT_OUT = 0.25;// largest servo value

    public final static double RIGHT_HOME = 0; // starting servo position
    public final static double RIGHT_IN = 0.25; //smallest servo value
    public final static double RIGHT_OUT = 0.75;/// largest servo val

    public final static double ARM_UP = 0.0;
    public final static double ARM_DOWN = 0.6;

    private ElapsedTime runtime = new ElapsedTime();



    @Override
    public void runOpMode() throws InterruptedException {
        backRight = hardwareMap.dcMotor.get("motor3");
        backLeft = hardwareMap.dcMotor.get("motor1");
        frontRight = hardwareMap.dcMotor.get("motor2");
        frontLeft = hardwareMap.dcMotor.get("motor0");
        jewelArm = hardwareMap.servo.get("servo0");
        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        leftGrabber = hardwareMap.servo.get("servo1");
        rightGrabber = hardwareMap.servo.get("servo2");
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        //stating the led that is on the color sensor, as turned on
        boolean bLedOn = true;

        colorSensor.enableLed(bLedOn);

        leftGrabber.setPosition(LEFT_HOME);
        rightGrabber.setPosition(RIGHT_HOME);

        jewelArm.setPosition(ARM_UP);

        while (stop.getState() == true) {
            glyph.setPower(-0.5);
        }
        runtime.reset();

        while(runtime.seconds() > 2.0) {
            glyph.setPower(0.5);
        }

        waitForStart();


        //moving jewel push inbetween jewels
        jewelArm.setPosition(ARM_DOWN);


        runtime.reset();

        while (opModeIsActive() && runtime.seconds() < 2) {
        }

        runtime.reset();


        if (colorSensor.red() > colorSensor.blue()) {
            //turns for 0.2 seconds
            while (opModeIsActive() && (runtime.seconds() < 0.25)) {
                frontLeft.setPower(0.25);
                backLeft.setPower(0.25);
                frontRight.setPower(-0.25);
                backRight.setPower(-0.25);
            }
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);

            runtime.reset();
            while (opModeIsActive() && runtime.seconds() < 1) {
            }
            //moving jewel arm back to home
            jewelArm.setPosition(ARM_UP);
            runtime.reset();
            while (opModeIsActive() && runtime.seconds() < 1) {
            }
            runtime.reset();


            while (opModeIsActive() && (runtime.seconds() < 0.25)) {
                frontLeft.setPower(-0.25);
                backLeft.setPower(-0.25);
                frontRight.setPower(0.25);
                backRight.setPower(0.25);
            }
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        } else {
            //turns for 0.2 seconds
            while (opModeIsActive() && (runtime.seconds() < 0.25)) {
                frontLeft.setPower(-0.25);
                backLeft.setPower(-0.25);
                frontRight.setPower(0.25);
                backRight.setPower(0.25);
            }
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);

            runtime.reset();
            while (opModeIsActive() && runtime.seconds() < 1) {
            }
            //moving jewel push back to home
            jewelArm.setPosition(ARM_UP);
            runtime.reset();
            while (opModeIsActive() && runtime.seconds() < 1) {
            }
            runtime.reset();


            while (opModeIsActive() && (runtime.seconds() < 0.25)) {
                frontLeft.setPower(0.3);
                backLeft.setPower(0.3);
                frontRight.setPower(-0.3);
                backRight.setPower(-0.3);
            }
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }


        //Moves back wheels off balancing stone
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            backLeft.setPower(-0.15);
            backRight.setPower(-0.15);
        }

        //turns robot toward safe zone
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            backLeft.setPower(-0.4);
            backRight.setPower(0.1);
        }

        //Moves robot into safe zone
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            frontLeft.setPower(-0.5);
            backLeft.setPower(-0.5);
            frontRight.setPower(-0.5);
            backRight.setPower(-0.5);
        }

        //moves away from crypto box slightly so glyph counts as scored
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 1.0)) {
            frontLeft.setPower(0.5);
            backLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backRight.setPower(0.5);
        }



    }
}

