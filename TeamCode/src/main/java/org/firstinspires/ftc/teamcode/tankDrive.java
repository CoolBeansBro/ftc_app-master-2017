package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;



@TeleOp(name = "tankDrive", group = "Tank")
public class tankDrive extends OpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor glyph;
    Servo jewelArm;
    Servo leftGrabber;
    Servo rightGrabber;

    public final static double LEFT_HOME = 0.0; // starting servo position
    public final static double LEFT_IN = 0.0; //smallest servo value(0)
    public final static double LEFT_OUT = 0.75;// largest servo value(135)

    public final static double RIGHT_HOME = 1.00; // starting servo position
    public final static double RIGHT_IN = 0.75; //smallest servo value(0)
    public final static double RIGHT_OUT = 0.0;/// largest servo value(135)

    public final static double ARM_UP = 0.0;
    public final static double ARM_DOWN = 0.6;

    @Override
    public void init() {
        backRight = hardwareMap.dcMotor.get("motor3");
        backLeft = hardwareMap.dcMotor.get("motor1");
        frontRight = hardwareMap.dcMotor.get("motor2");
        frontLeft = hardwareMap.dcMotor.get("motor0");
        jewelArm = hardwareMap.servo.get("pushJewel");
        leftGrabber = hardwareMap.servo.get("leftGrabber");
        rightGrabber = hardwareMap.servo.get("rightGrabber");
        glyph = hardwareMap.dcMotor.get("glyph");
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        leftGrabber.setPosition(LEFT_HOME);
        rightGrabber.setPosition(RIGHT_HOME);

        jewelArm.setPosition(ARM_UP);

 }

    @Override
    public void loop() {

        frontLeft.setPower(-gamepad1.left_stick_y/2.0);
        backLeft.setPower(-gamepad1.left_stick_y/2.0);
        frontRight.setPower(-gamepad1.right_stick_y/2.0);
        backRight.setPower(-gamepad1.right_stick_y/2.0);

        if (gamepad2.a) {
            leftGrabber.setPosition(LEFT_IN);
            rightGrabber.setPosition(RIGHT_IN);
        }
        if (gamepad2.x) {
            leftGrabber.setPosition(LEFT_OUT);
            rightGrabber.setPosition(RIGHT_OUT);

       }
        if  (gamepad2.y) {
            jewelArm.setPosition(ARM_UP);
        }
        if  (gamepad2.b){
            jewelArm.setPosition(ARM_DOWN);

        }

       glyph.setPower(gamepad2.left_stick_y/2.0);
       jewelArm.setPosition(-gamepad2.right_stick_y/2.0);
    }
}
