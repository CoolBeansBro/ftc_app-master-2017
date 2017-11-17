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
    Servo blockPull;

    public final static double ARM_HOME = 0.0; // starting servo position
    public final static double ARM_MIN_RANGE = 0.0; //smallest servo value(0)
    public final static double ARM_MAX_RANGE = 0.75;// largest servo value(135)

 @Override
    public void init() {
        backRight = hardwareMap.dcMotor.get("motor3");
        backLeft = hardwareMap.dcMotor.get("motor1");
        frontRight = hardwareMap.dcMotor.get("motor2");
        frontLeft = hardwareMap.dcMotor.get("motor0");
        blockPull = hardwareMap.servo.get("servo0");

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {

        frontLeft.setPower(-gamepad1.left_stick_y/2.0);
        backLeft.setPower(-gamepad1.left_stick_y/2.0);
        frontRight.setPower(-gamepad1.right_stick_y/2.0);
        backRight.setPower(-gamepad1.right_stick_y/2.0);

        if (gamepad2.a) {
            blockPull.setPosition(0.75);
        }
       if (gamepad2.x) {
            blockPull.setPosition(0.0);
       }

    }
}
