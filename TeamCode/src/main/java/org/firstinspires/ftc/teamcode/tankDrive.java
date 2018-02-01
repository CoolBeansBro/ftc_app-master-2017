package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name = "tankDrive", group = "Tank")
public class tankDrive extends LinearOpMode {

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor glyph;
    Servo jewelArm;
    Servo leftGrabber;
    Servo rightGrabber;
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
    public void runOpMode()throws InterruptedException {
        backRight = hardwareMap.dcMotor.get("motor3");
        backLeft = hardwareMap.dcMotor.get("motor1");
        frontRight = hardwareMap.dcMotor.get("motor2");
        frontLeft = hardwareMap.dcMotor.get("motor0");
        jewelArm = hardwareMap.servo.get("servo0");
        leftGrabber = hardwareMap.servo.get("servo1");
        rightGrabber = hardwareMap.servo.get("servo2");
        glyph = hardwareMap.dcMotor.get("glyph");
        stop = hardwareMap.get(DigitalChannel.class, "stop");
        jewelArm = hardwareMap.servo.get("servo0");
        leftGrabber = hardwareMap.servo.get("servo1");
        rightGrabber = hardwareMap.servo.get("servo2");
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        stop.setMode(DigitalChannel.Mode.INPUT);


        leftGrabber.setPosition(LEFT_HOME);
        rightGrabber.setPosition(RIGHT_HOME);

        jewelArm.setPosition(ARM_UP);


        waitForStart();


        while (opModeIsActive()) {


            frontLeft.setPower(-gamepad1.left_stick_y / 2.5);
            backLeft.setPower(-gamepad1.left_stick_y / 2.5);
            frontRight.setPower(-gamepad1.right_stick_y / 2.5);
            backRight.setPower(-gamepad1.right_stick_y / 2.5);

            if (gamepad2.a) {
                leftGrabber.setPosition(LEFT_IN);
                rightGrabber.setPosition(RIGHT_IN);
            }
            if (gamepad2.x) {
                leftGrabber.setPosition(LEFT_OUT);
                rightGrabber.setPosition(RIGHT_OUT);

            }
            if (gamepad2.y) {
                jewelArm.setPosition(ARM_UP);
            }
            if (gamepad2.b) {
            }
            if (gamepad2.y) {
                jewelArm.setPosition(ARM_DOWN);
            }
            if (stop.getState() == false && gamepad2.left_stick_y >= 0) {
                glyph.setPower(0.0);
            } else {
                glyph.setPower(gamepad2.left_stick_y / 2.0);
            }
            if (stop.getState() == true) {
                telemetry.addData("stop", "Is Not Pressed");
            } else {
                telemetry.addData("stop", "Is Pressed");
            }

            telemetry.update();

            jewelArm.setPosition(-gamepad2.right_stick_y / 2.0);

        }
    }
}
