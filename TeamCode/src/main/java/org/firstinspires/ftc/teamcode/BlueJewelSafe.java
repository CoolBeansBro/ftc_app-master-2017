/*package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;
import java.util.Queue;



/**
 * Created by Aniketh on 11/18/2017.

@Autonomous
public class BlueJewelSafe extends LinearOpMode {
    /**
     * Created by Aniketh on 11/16/2017.

    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    ColorSensor colorSensor;
    Servo jewelArm;
    BNO055IMU imu;
    Orientation angles;
    Acceleration gravity;

    public final static double JEWEL_UP = 0.0; //smallest servo value(0)
    public final static double JEWEL_DOWN = 0.6;// largest servo value(135)
    private ElapsedTime runtime = new ElapsedTime();


    @Override
    public void runOpMode() throws InterruptedException {
        backRight = hardwareMap.dcMotor.get("motor3");
        backLeft = hardwareMap.dcMotor.get("motor1");
        frontRight = hardwareMap.dcMotor.get("motor2");
        frontLeft = hardwareMap.dcMotor.get("motor0");
        jewelArm = hardwareMap.servo.get("servo2");

        colorSensor = hardwareMap.get(ColorSensor.class, "colorSensor");
        imu = hardwareMap.get(BNO055IMU.class, "imu");

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        jewelArm.setPosition(JEWEL_UP);

        telemetry.addData("Say", "Hello Driver");    //
        telemetry.update();


        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        imu.initialize(parameters);

        void composeTelemetry() {

            // At the beginning of each telemetry update, grab a bunch of data
            // from the IMU that we will then display in separate lines.
            telemetry.addAction(new Runnable() { @Override public void run()
            {
                // Acquiring the angles is relatively expensive; we don't want
                // to do that in each of the three items that need that info, as that's
                // three times the necessary expense.
                angles   = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
                gravity  = imu.getGravity();
            }
            });

            telemetry.addLine()
                    .addData("status", new Func<String>() {
                        @Override public String value() {
                            return imu.getSystemStatus().toShortString();
                        }
                    })
                    .addData("calib", new Func<String>() {
                        @Override public String value() {
                            return imu.getCalibrationStatus().toString();
                        }
                    });

            telemetry.addLine()
                    .addData("heading", new Func<String>() {
                        @Override public String value() {
                            return formatAngle(angles.angleUnit, angles.firstAngle);
                        }
                    })
                    .addData("roll", new Func<String>() {
                        @Override public String value() {
                            return formatAngle(angles.angleUnit, angles.secondAngle);
                        }
                    })
                    .addData("pitch", new Func<String>() {
                        @Override public String value() {
                            return formatAngle(angles.angleUnit, angles.thirdAngle);
                        }
                    });

            telemetry.addLine()
                    .addData("grvty", new Func<String>() {
                        @Override public String value() {
                            return gravity.toString();
                        }
                    })
                    .addData("mag", new Func<String>() {
                        @Override public String value() {
                            return String.format(Locale.getDefault(), "%.3f",
                                    Math.sqrt(gravity.xAccel*gravity.xAccel
                                            + gravity.yAccel*gravity.yAccel
                                            + gravity.zAccel*gravity.zAccel));
                        }
                    });
        }



        waitForStart();

        jewelArm.setPosition(JEWEL_DOWN);

        if (colorSensor.red() > colorSensor.blue()){
            while(opModeIsActive() /*&& gyroHeading < 45){

            frontLeft.setPower(-0.25);
            backLeft.setPower(-0.25);
            frontRight.setPower(0.25);
            backRight.setPower(0.25);

        }
    }


        else {
        while(opModeIsActive() /*&& gyroHeading < -45){

            if (imu.getHeading() < 180 && runtime.seconds() <= 5){
                frontLeft.setPower(0.25);
                backLeft.setPower(0.25);
                frontRight.setPower(-0.25);
                backRight.setPower(-0.25);
            }
            else{
                while(opModeIsActive() && runtime.seconds() <= 5){
                    frontLeft.setPower(-0.25);
                    backLeft.setPower(-0.25);
                    frontRight.setPower(0.25);
                    backRight.setPower(0.25);
                }
            }
        }

    }

        jewelArm.setPosition(JEWEL_UP);

    //Moves robot into safe zone
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.8)) {
        frontLeft.setPower(-0.5);
        backLeft.setPower(-0.5);
        frontRight.setPower(-0.5);
        backRight.setPower(-0.5);

    }
}
}*/

