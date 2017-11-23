package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Us on 11/2/2017.
 */

@TeleOp(name = "tankDrive", group = "Tank")
public class tankDrive extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    Servo left;
    Servo right;

    public final static double LEFT_HOME = 0.0; // starting servo position
    public final static double LEFT_IN = 0.0; //smallest servo value(0)
    public final static double LEFT_OUT = 0.75;// largest servo value(135)

    public final static double RIGHT_HOME = 0.75; // starting servo position
    public final static double RIGHT_IN = 0.75; //smallest servo value(0)
    public final static double RIGHT_OUT = 0.0;// largest servo value(135)

 @Override
    public void init() {
        backRight = hardwareMap.dcMotor.get("motor3");
        backLeft = hardwareMap.dcMotor.get("motor1");
        frontRight = hardwareMap.dcMotor.get("motor2");
        frontLeft = hardwareMap.dcMotor.get("motor0");
        left = hardwareMap.servo.get("servo0");
        right = hardwareMap.servo.get("servo1");

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        left.setPosition(LEFT_HOME);
        right.setPosition(RIGHT_HOME);



 }

    @Override
    public void loop() {

        frontLeft.setPower(-gamepad1.left_stick_y/2.0);
        backLeft.setPower(-gamepad1.left_stick_y/2.0);
        frontRight.setPower(-gamepad1.right_stick_y/2.0);
        backRight.setPower(-gamepad1.right_stick_y/2.0);

        if (gamepad2.a) {
            left.setPosition(LEFT_IN);
            right.setPosition(RIGHT_IN);
        }
       if (gamepad2.x) {
            left.setPosition(LEFT_OUT);
            right.setPosition(RIGHT_OUT);

       }

    }
}
